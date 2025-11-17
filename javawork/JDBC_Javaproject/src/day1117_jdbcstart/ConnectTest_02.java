package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_02 {
	
	//url
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";


	public void getConnectFoodShop() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			
			String sql="select * from foodshop order by fno";
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**음식점 정보 출력***");
			System.out.println("=================================");
			System.out.println("번호\t음식명\t음식가격\t음식점이름\t위치");
			
			while(rs.next())
			{
				String shopname=rs.getString("shopname");
				String shoploc=rs.getString("shoploc");
				
				System.out.println(rs.getInt("fno")+"\t"
						+rs.getString("foodname")+"\t"
						+rs.getInt("foodprice")+"\t"
						+shopname+"\t"+shoploc);
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
	
	
	//Q.성별 인원수와 평균 나이를 출력하시오
	//성별	인원수	평균나이
	//여자	6		33세
	//남자	4		26세
	public void getConnectPerson() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
				
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			
//			String sql="select gender,count(*),avg(age) from person group by gender";
			//별칭 가능
			String sql="select gender,count(*) count,avg(age) aavg from person group by gender";
			
			stmt=conn.createStatement(); //insert는 여기서 끝!!
			
			rs=stmt.executeQuery(sql);
			
			System.out.println("성별\t인원수\t평균나이");
			System.out.println("========================");
			
			while(rs.next())
			{
//				String gender = rs.getString("gender");
//				int count = rs.getInt("count(*)");
//				int avgage = rs.getInt("avg(age)");
				
				//별칭도 출력가능
				String gender = rs.getString("gender");
				int count = rs.getInt("count");
				int avgage = rs.getInt("aavg");
				
				System.out.println(gender+"\t"+count+"명\t"+avgage+"세");
				
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
	
	
	//Q.lsh계정의 교수테이블
	//직급별 최고급여, 최소급여
	public void getConnectProfessor() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select position,count(position) count,max(pay) 최대급여,"
				+ "min(pay) minpay from professor group by position";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "lsh", "a1234");
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			System.out.println("***lsh 계정의 교수테이블***");
			System.out.println("직급\t직급별인원\t최고급여\t최소급여");
			System.out.println("================================");
			
			while(rs.next()) 
			{
				String position=rs.getString("position");
				String count=rs.getString("count");
				int maxpay=rs.getInt("최대급여");
				int minpay=rs.getInt("minpay");
				
				System.out.println(position+"\t"+count+"명\t"+maxpay+"만원\t"+minpay+"만원");
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
		ConnectTest_02 test2=new ConnectTest_02();
//		test2.getConnectFoodShop();
//		test2.getConnectPerson();
		test2.getConnectProfessor();

	}

}
