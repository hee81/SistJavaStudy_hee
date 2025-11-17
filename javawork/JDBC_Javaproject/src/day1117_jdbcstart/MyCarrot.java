package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyCarrot {

	/*
	  3.자바에 가셔서 클래스 만든다
		클래스명:  MyCarrot
		메서드1: getSelectMyCarrot()
		메서드2:  getDeleteMyCarrot()

		메인에서 getSelectMyCarrot()호출시 리스트 모두 나오게 할것!!!
		삭제시 몇번의 시퀀스를 삭제하실건가요? 질문후 번호쓰면 그번호 삭제할것!!!
		삭제되었느지 조회해서 확인해볼것!!!
		9번누르면 종료!!!!!
	 */
	
	//url
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void getSelectMyCarrot() {
		
		System.out.println("등록번호\t상품명\t상품가격\t매너점수\t상대방주소");
		System.out.println("=================================================================");
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from MyCarrot";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("cnum")+"\t"+rs.getString("csangpum")+"\t"+
			rs.getInt("cprice")+"\t"+rs.getInt("cscore")+"\t"+rs.getString("caddr"));
				
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
	
	
	public void getDeleteMyCarrot() {
		
		Scanner sc=new Scanner(System.in);
		int num;

		System.out.println("등록번호 몇번을 삭제하실건가요?");
		num=Integer.parseInt(sc.nextLine());
		
		Connection conn=null;
		Statement stmt=null;
		
		String sql="delete from MyCarrot where cnum="+num;
		
		try {
			//db연결
			conn=DriverManager.getConnection(ORACLE_URL, "test", "a1234");
			//sql연결
			stmt=conn.createStatement();
			//서버업데이트
			stmt.execute(sql);
			System.out.println("**선택한 번호가 삭제되었습니다**");
			
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
		MyCarrot mc=new MyCarrot();
		
		Scanner sc=new Scanner(System.in);
		int n;

		while(true)
		{
			System.out.println("****1.조회    2.삭제    9.종료****");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				mc.getSelectMyCarrot();
			else if(n==2)
				mc.getDeleteMyCarrot();
			else if(n==9)
			{
				System.out.println("**종료되었습니다**");
				break;
			}
		}

	}

}
