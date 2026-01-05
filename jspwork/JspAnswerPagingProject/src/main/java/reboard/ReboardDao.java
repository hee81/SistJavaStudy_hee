package reboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myboard.BoardDto;
import mysql.db.DbConnect;

public class ReboardDao {

	DbConnect db=new DbConnect();
	
	//num의 max값 구해서 리턴(null이면 0리턴)
	public int getMaxNum()
	{
		int max=0;
		
		//별칭?주기
		String sql="select ifnull(max(num),0)max from reboard";
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				//둘 다 가능
				//max=rs.getInt("max");
				max=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return max;
	}
	
	//데이터 추가시 같은 그룹 중 전달받은 step보다 큰 값을 가진 데이터들은 무조건 +1한다(ex.원글에 댓글 여러개 달릴 때)
	public void updateRestep(int regroup, int restep)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		//원글step0  댓글step1 새로운댓글은 +1해야함....
		String sql="update reboard set restep=restep+1 where regroup=? and restep>?";
		                          
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, regroup);
			pstmt.setInt(2, restep);
			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//insert---제일중요!!
	//새글로 추가할지, 답글로 추가할지
	//판단은 db에 있는 num이 null이면 새글로 null
	//아니면 답글로 insert
	public void insertReboard(ReboardDto dto)
	{
		String num=dto.getNum();
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		
		String sql="insert into reboard values(null,?,?,?,?,?,?,?,0,now())";
		
		if(num==null) {
			//새글을 의미
			regroup=this.getMaxNum()+1;
			restep=0;
			relevel=0;
		}else {
			//답글을 의미
			//같은그룹중에서 restep이 전달받은값보다 큰경우 무조건1증가
			this.updateRestep(regroup, restep);
			//그리고 전달받은 level,step은 1증가
			relevel+=1;
			restep+=1;
		}
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPass());
			
			pstmt.setInt(5, regroup);
			pstmt.setInt(6, restep);
			pstmt.setInt(7, relevel);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//디테일페이지-선택한 하나의 데이터 불러오기
	public ReboardDto getData(String num)
	{
		ReboardDto dto=new ReboardDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from reboard where num="+num;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPass(rs.getString("pass"));
				dto.setRegroup(rs.getInt("regroup"));
				dto.setRestep(rs.getInt("restep"));
				dto.setRelevel(rs.getInt("relevel"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	//디테일페이지안의 조회수1증가
	public void updateReadCount(String num)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update reboard set readcount=readcount+1 where num="+num;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	////페이징_1.범위에 따른 리스트,2.총 목록갯수
	//페이징1.범위에 따른 리스트
	public List<ReboardDto> getPagingList(int start,int perpage)
	{
		//페이징은 arraylist가 원활
		List<ReboardDto> list=new ArrayList<ReboardDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from reboard order by regroup desc,restep asc limit ?,?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, perpage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ReboardDto dto=new ReboardDto();
				
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPass(rs.getString("pass"));
				dto.setRegroup(rs.getInt("regroup"));
				dto.setRestep(rs.getInt("restep"));
				dto.setRelevel(rs.getInt("relevel"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//페이징2.총 목록갯수
	public int getTotalCount()
	{
		int tot=0;
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from reboard";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				tot=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return tot;
	}
	
	//비번이 맞을 경우 true 반환하기
	public boolean isEqualPass(String num,String pass)
	{
		boolean flag=false;
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from reboard where num=? and pass=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, num);
			pstmt.setString(2, pass);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1)==1) //생략가능
					flag=true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return flag;
	}
	

	//update..writer,subject,content
	public void updateReboard(ReboardDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update reboard set writer=?, subject=?, content=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//delete
	public void deleteReboard(String num)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from reboard where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//삭제를 했는데 원글이 삭제된 경우 답글의 맨 앞에 빨강색으로 [원글이 삭제된 답글]출력하기
	//원글 존재 유무 검사-있을 경우 true
	public boolean isGroupStep(int regroup)
	{
		boolean flag=false;
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from reboard where regroup=? and restep=0";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, regroup);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				flag=true;
			}	
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return flag;
	}


}
