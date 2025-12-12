package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle_db.DbConnect;

public class MemberDao {

	DbConnect db=new DbConnect();
	
	//insert
	public void insertMember(MemberDto dto)
	{
		String sql="insert into member values(seq1.nextval,?,?,?,?,sysdate)";
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩-순서대로 필수!!
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHp());
			pstmt.setString(3, dto.getDriver());
			pstmt.setString(4, dto.getJop());
			
			//업데이트
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//select
	public ArrayList<MemberDto> getAllDatas()
	{
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from member order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				MemberDto dto=new MemberDto();
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setHp(rs.getString("hp"));
				dto.setDriver(rs.getString("driver"));
				dto.setJop(rs.getString("jop"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
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
	public void deleteMember(String num)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from member where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
	//one-select
	public MemberDto getOneData(String num)
	{
		MemberDto dto=new MemberDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from member where num="+num;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setHp(rs.getString("hp"));
				dto.setDriver(rs.getString("driver"));
				dto.setJop(rs.getString("jop"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;
	}
	
	//update
	public void updateMember(MemberDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update member set name=?, hp=?, driver=?, jop=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHp());
			pstmt.setString(3, dto.getDriver());
			pstmt.setString(4, dto.getJop());
			pstmt.setString(5, dto.getNum());
			
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
