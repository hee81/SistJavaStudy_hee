package day1119;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectTest {

	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	//Create
	public void insertTest() {
		
		System.out.println("이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("주소를 입력하세요");
		String addr=sc.nextLine();
		System.out.println("직업을 입력하세요");
		String job=sc.nextLine();
		System.out.println("전화번호를 입력하세요");
		String hp=sc.nextLine();
		
		String sql="insert into myclub values(seq4.nextval,'"+name+"','"+addr+"','"+job+"','"+hp+"',sysdate)";
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("===입력한 회원정보가 등록되었습니다====");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
	}
	//Read
	public void selelctTest() {
		String sql="select * from myclub order by cno";
		
		System.out.println("\t**전체 MyClub회원명단**");
		System.out.println("==================================================");
		System.out.println("등록번호\t이름\t주소\t직업\t전화번호\t가입일자");
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("cno")+"\t"+rs.getString("cname")+"\t"+rs.getString("caddr")+"\t"+
			rs.getString("cjob")+"\t"+rs.getString("chp")+"\t"+rs.getDate("gaipday"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
	}
	//Delete
	public void deleteTest() {
		System.out.println("-----삭제하려는 회원번호는 입력하세요-----");
		int delnum=Integer.parseInt(sc.nextLine());
		
		String sql="delete from myClub where cno="+delnum;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
//			stmt.execute(sql);
			int a=stmt.executeUpdate(sql);
			
			if(a==0)
				System.out.println("--"+delnum+"번은 존재하지 않는 회원정보 입니다--");
			else
				System.out.println("-----입력하신 회원정보가 삭제되었습니다-----");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	

	//Update 1.조회용
	public boolean inOneDate(int num) {
		boolean flag=false;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from myclub where cno="+num;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			if(rs.next())
				flag=true;
			else
				flag=false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
		return flag;
	}


	
	
	
	
	//Update 2.수정용
	public void updateTest() {
		System.out.println("***수정을 원하는 회원번호를 입력하세요***");
		int upnum=Integer.parseInt(sc.nextLine());
		
		if(!inOneDate(upnum))
		{
			System.out.println(upnum+"번은 존재하지 않는 회원입니다");
			return;
		}
		
		System.out.println("**수정할 이름을 입력하세요**");
		String upname=sc.nextLine();
		System.out.println("**수정할 주소를 입력하세요**");
		String upaddr=sc.nextLine();
		System.out.println("**수정할 직업을 입력하세요**");
		String upjob=sc.nextLine();
		System.out.println("**수정할 전화번호을 입력하세요**");
		String uphp=sc.nextLine();
		
		String sql="update myclub set cname='"+upname+"',caddr='"+upaddr+"',cjob='"+upjob+"',chp='"+uphp+"' where cno="+upnum;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("***회원 정보가 수정되었습니다***");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}

	}

	
	
	public static void main(String[] args) {
		// 입력한 번호를 조회하기
		Scanner sc=new Scanner(System.in);
		ConnectTest test=new ConnectTest();
		

		while(true)
		{
			System.out.println("1.회원가입    2.회원조회    3.회원삭제    4.회원정보수정    9.종료");
			System.out.println("===========================================================");
			System.out.println("원하시는 숫자를 입력하세요");
			int num=Integer.parseInt(sc.nextLine());
			
			if(num==1)
				test.insertTest();
			else if(num==2)
				test.selelctTest();
			else if(num==3)
				test.deleteTest();
			else if(num==4)
				test.updateTest();
			else if(num==9)
			{
				System.out.println("프로그램이 종료 됩니다");
				break;
			}
			
				
		}

	}

}
