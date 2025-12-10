package myinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	
}
