package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.MemberDto;
import mysql.db.DbConnect;

public class MemberDao {
	
	DbConnect db=new DbConnect();
	
	//아이디체크
	public int getIdCheck(String id)
	{
		int isid=0;
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from member where id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				isid=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return isid;
	}
	
	//insert
	public void insertMember(MemberDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into member (name,id,pass,hp,addr,email,gaipday) values (?,?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getHp());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getEmail());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

}
