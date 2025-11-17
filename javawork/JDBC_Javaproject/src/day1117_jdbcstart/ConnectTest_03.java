package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_03 {

	//url
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//부서별 인원수와 평균급여 최고급여 최저급여(화폐단위,천단위)
	public void getGroupSawon() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select buseo,count(*) count,to_char(avg(pay),'L999,999,999') avgpay,"
				+ "to_char(max(pay),'L999,999,999') maxpay,"
				+ "to_char(min(pay),'L999,999,999') minpay from sawon group by buseo";
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			System.out.println("오라클 계정 연결 성공~!!");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***부서별 사원 리스트***");
			System.out.println("부서명\t인원수\t평균급여\t최고급여\t최저급여");
			System.out.println("---------------------------------------------------------");
			
			while(rs.next())
			{
				String buseo=rs.getString("buseo");
				int count=rs.getInt("count");
				String avgpay=rs.getString("avgpay");
				String maxpay=rs.getString("maxpay");
				String minpay=rs.getString("minpay");
				
				System.out.println(buseo+"\t"+count+"\t"+avgpay+"\t"+maxpay+"\t"+minpay);
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
	
	//join-foodshop,orderapp 
	//주문번호  주문자명	 주문음식명  가격  음식점이름  음식점위치  배달자주소
	public void getMyBaedal() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//select와 from 사이에 공백 무조건 있어야함!!(파싱 오류 남!)
		String sql="select onum,clientname,foodname,foodprice,shopname,shoploc,clientaddr "
				+ "from foodshop f,orderapp o where f.fno=o.fno";

		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			System.out.println("오라클연결");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***배달의 민족 주문 리스트****");
			System.out.println("주문번호\t주문자명\t주문음식명\t가격\t음식점이름\t음식점위치\t배달자주소");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t" //자바의 rs는 컬럼이 1부터 시작!!
			+rs.getString("clientname")+"\t"
			+rs.getString("foodname")+"\t"
			+rs.getInt("foodprice")+"\t"
			+rs.getString("shopname")+"\t"
			+rs.getString("shoploc")+"\t"
			+rs.getString("clientaddr"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("오라클 연결 실패"+e.getMessage());
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
		ConnectTest_03 test3=new ConnectTest_03();
//		test3.getGroupSawon();
		test3.getMyBaedal();

	}

}
