package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectMoim {

	//url
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//조회
	public void getConnectMoim() {
		
		System.out.println("회원번호\t회원명\t회원주소\t연락처\t직업\t가입일");
		System.out.println("------------------------------------------------------------");
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from moim order by name"; //이름의 오름차순
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("no")+"\t"+rs.getString("name")+"\t"+rs.getString("addr")+
						"\t"+rs.getString("hp")+"\t"+rs.getString("job")+"\t"+rs.getString("gaipday"));
				
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
	
	//삭제
	//서버에서 삭제되므로 rollback 안됨!
	//조회를 안하기 때문에 별칭은 필요없음.
	public void getDeleteMoim() {
		//삭제할 번호를 입력 후 삭제할것
		Scanner sc=new Scanner(System.in);
		int num; //삭제할 땐 int,string 상관없음!!
		System.out.println("삭제할 번호를 입력하시오");
		num=Integer.parseInt(sc.nextLine());
		
		////sql문은 스캐너 이후에!
		String sql="delete from moim where no="+num;
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			//db연결
			conn=DriverManager.getConnection(ORACLE_URL,"test","a1234");
			//sql문 전달
			stmt=conn.createStatement();
			////서버에 업데이트
			stmt.execute(sql); //boolean 있다,없다 //이때 sql문이 전달이 된다....있는거 넣어야지 삭제가 됨
			System.out.println("**선택한 회원 삭제됨***");
			
//			stmt.executeUpdate(sql) //반환값 int! 1,0-->if문 사용할 수 있음.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	
	public static void main(String[] args) {
		// 조회,삭제를 선택할 수 있도록 만들기
		
		ConnectMoim moim=new ConnectMoim();
		
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("***Oracle db 연습문제_test계정의 moim테이블***");
			System.out.println("1.조회   2.삭제   9.종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				moim.getConnectMoim();
			else if(n==2)
				moim.getDeleteMoim();
			else if(n==9) {
				System.out.println("프로그램 종료");
				break;
			}
				
		}

	}

}
