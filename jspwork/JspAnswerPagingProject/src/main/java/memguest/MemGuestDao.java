package memguest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.db.DbConnect;

public class MemGuestDao {
	
	DbConnect db=new DbConnect();
	
	//insert
	public void insertGuest(MemGuestDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into memguest values(null,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMyid());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getContent());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//페이징1 List num 내림차순
	public List<MemGuestDto> getPagingList(int startNum,int perPage)
	{
		List<MemGuestDto> list=new ArrayList<MemGuestDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from memguest order by num desc limit ?,?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, perPage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				MemGuestDto dto=new MemGuestDto();
				dto.setNum(rs.getString("num"));
				dto.setMyid(rs.getString("myid"));
				dto.setPhoto(rs.getString("photo"));
				dto.setContent(rs.getString("content"));
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
	
	//페이징2 totalCount
	public int getTotalCount()
	{
		int total=0;
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from memguest";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				total=rs.getInt(1); //1번열-가장안전함
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return total;
	}
	
	//삭제
	public void deleteGuest(String num)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from memguest where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//num에 dto리턴
	//파일삭제-getData
	public MemGuestDto getOneData(String num)
	{
		MemGuestDto dto=new MemGuestDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from memguest where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setMyid(rs.getString("myid"));
				dto.setPhoto(rs.getString("photo"));
				dto.setContent(rs.getString("content"));
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
	
	
	
}
