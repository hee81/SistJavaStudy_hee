package myinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle_db.DbConnect;

public class SawonInfoDao {
	
	DbConnect db=new DbConnect();
		
	public void insertSawoninfo(SawonInfoDto dto)
	{
		//db연결
		Connection conn=db.getDbConnect();
		
		//sql연결?
		PreparedStatement pstmt=null;
		
		String sql="insert into values(seq1.nextval,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
}
