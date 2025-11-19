package day1119;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectStudent {

	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectStudent() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//이름의 오름차순으로 조회하기
		String sql="select name 이름,grade,height from student order by name";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "lsh", "a1234");
			System.out.println("오라클 서버에 연결성공!!!!!");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("이름\t학생명\t신장");
			
			while(rs.next()) //값이 있으면 true반환,더 이상 데이터 없으면 false
			{
				System.out.println(rs.getString("이름")+"\t"+rs.getInt("grade")+"학년\t"+rs.getInt("height")+"cm");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectStudent stu=new ConnectStudent();
		stu.connectStudent();

	}

}
