package day1117_jdbcstart;

import java.sql.Connection; //java.sql 확인 필수!!
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_01 {
	
	//변수로 드라이버,url
	//dirver 연결은 자동으로 생성자 안에 들어가 있어서 필수 아님!
	static final String dirver="oracle.jdbc.driver.OracleDriver"; 
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE"; //orcl도 가능
	
	//필수 아님 오라클은 생략가능!
	public ConnectTest_01() {
		try {
			Class.forName(dirver);
			System.out.println("오라클 드라이버 연결 성공!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//메서드..오라클과 자바를 연결해줌(본인의 계정과 비번도 작성해야함)
	public void getconnectEmp() {
		Connection conn=null; //전역으로 절대 불가능!! multi스레드?상황이 발생할 수 있음(보안관련이기때문에)
		Statement stmt=null;
		ResultSet rs=null; //3개의 객체가 오라클-자바를 연결해줌 
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "lsh", "a1234");
			
			System.out.println("클라우드의 오라클 서버에 연결 성공!!!!!");
			
			String sql="select empno,ename,job,sal from emp order by ename"; //사원명 오름차순 정렬
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***Emp 데이터 가져오기");
			System.out.println("사원번호\t사원명\t직무\t급여");
			
			//여러줄의 데이터를 읽어올 경우는 while문으로 가져온다
			//rs.next():다음 데이터 읽어오면서 true로 반환하고,더이상 데이터가 없으면 false로 반환한다.
			while(rs.next())
			{
				//db로부터 데이터 가져오기 //숫자-getInt(), 문자- getString()
				int empno=rs.getInt("empno");
				String name=rs.getString("ename"); //테이블에서 ename을 읽어온다
//				String job=rs.getString(2);
				String job=rs.getString("job"); //배열로도 가능하다
				int sal=rs.getInt("sal");
				
				System.out.println(empno+"\t"+name+"\t"+job+"\t"+sal);
								
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("클라우드의 오라클 연결 실패!!!"+e.getMessage());
			
		}finally {
			//자원의 역순으로 반환한다
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
	
	
	public void getconnectSawon() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//모든 컬럼 num의 내림차순으로 조회
		String sql="select * from sawon order by num desc";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			
			System.out.println("서버 연결 성공");
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			System.out.println("**사원 정보 출력**");
			System.out.println("===================================");
			System.out.println("사원번호\t이름\t성별\t부서명\t급여\t입사일");
			
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				int pay=rs.getInt("pay");
//				String ipsa=String.valueOf(rs.getDate("ipsa"));//그냥 출력문에 뽑아도 됨
				
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+
				pay+"\t"+rs.getDate("ipsa"));
							
				
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
		
		ConnectTest_01 test1=new ConnectTest_01();
//		test1.getconnectEmp();
		test1.getconnectSawon();

	}

}
