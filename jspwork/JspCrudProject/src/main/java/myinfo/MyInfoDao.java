package myinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import oracle_db.DbConnect;

public class MyInfoDao {
	
	DbConnect db=new DbConnect();
	
	//insert
	public void insertMyinfo(MyInfoDto dto) //	dto 안에 있는 메서드 불러오기...
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null; //서버에 전송만 하기때문에 ResultSet필요없음
		
		String sql="insert into myinfo values(seq1.nextval,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			
			//업데이트-둘 다 같음.
//			pstmt.execute();
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
	//select
	//Vector
//	public Vector<MyInfoDto> getAllDatas()
//	{
//		Vector<MyInfoDto> list=new Vector<MyInfoDto>();
//		return list;
//	}
		
	//List
	public List<MyInfoDto> getAllDatas()
	{
		List<MyInfoDto> list=new Vector<MyInfoDto>();
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//num의 오름차순 조회
		String sql="select * from myinfo order by num asc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//여러개의 데이터 조회시는 while / 하나는 if
			while(rs.next())
			{
				//반드시 while문 앞에서 dto선언
				MyInfoDto dto=new MyInfoDto();
				//db에 있는 데이터를 가져와서 초기에 설정한 dto에 값을 넣는다.
				dto.setNum(rs.getString("num")); 
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setSdate(rs.getTimestamp("sdate"));
				
				//리스트에 추가 필수
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}		
		return list;
	}
	
	//delete
	public void deleteMyinfo(String num)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from myinfo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, num);
			
			//업데이트
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//update
	//수정에 필요한 하나의 데이터를 조회
	public MyInfoDto getOneData(String num)
	{
		//dto=한 명의 맴버값?
		MyInfoDto dto=new MyInfoDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myinfo where num="+num;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//수정하려는 하나의 데이터만 필요하므로 if
			if(rs.next())
			{
				dto.setNum(rs.getString("num")); //db에서 넘어온 값이다?
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	//수정
	//(String num)만 넣으면 안됨
	public void updateMyinfo(MyInfoDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update myinfo set name=?, addr=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setString(3, dto.getNum());
			
			//업데이트
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
}
