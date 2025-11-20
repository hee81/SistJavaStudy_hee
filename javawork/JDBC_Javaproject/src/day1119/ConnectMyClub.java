package day1119;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectMyClub {

	Scanner sc=new Scanner(System.in);
	DbConnect db=new DbConnect();
	
	//insert
	//회원가입하기 회원명? 주소? 직업? 핸드폰?
	//인서트 성공 후 항상 developer 가서 확인할 것!!!
	public void insertMyClub() {
		
		System.out.println("***회원가입하기***");
		System.out.println("회원명을 입력하시오");
		String name=sc.nextLine();
		System.out.println("주소를 입력하시오");
		String addr=sc.nextLine();
		System.out.println("직업을 입력하시오");
		String job=sc.nextLine();
		System.out.println("핸드폰 번호를 입력하시오");
		String hp=sc.nextLine();
		
		String sql="insert into myclub values(seq4.nextval,'"+name+"','"+addr+"','"+job+"','"+hp+"',sysdate)";
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
//			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//select...5명이상 조회_캡처 1장
	//developer 가서 확인 후 그 테이블을 가지고 오는 것
	public void selectMyClub() {
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from myclub order by cno";
	
		System.out.println("***회원조회***");
		System.out.println("회원번호\t회원명\t주소\t직업\t전화번호\t가입일자");
		System.out.println("===================================================================");
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("cno")+"\t"+rs.getString("cname")+"\t"+
			rs.getString("caddr")+"\t"+rs.getString("cjob")+"\t"+rs.getString("chp")+"\t"+rs.getDate("gaipday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
	}
	
	//============select 까지==================
	//delete
	public void deleteMyClub()
	{
		System.out.println("***삭제하려는 회원번호를 입력하세요***");
		int delno=Integer.parseInt(sc.nextLine());
		
		String sql="delete from myclub where cno="+delno;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
//			stmt.execute(sql);
			int a=stmt.executeUpdate(sql);
			if(a==0)
				System.out.println("----"+delno+"번 회원은 회원 명단에 없습니다----");
			else
				System.out.println("===="+delno+"번 회원정보가 삭제되었습니다====");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}

	}
	
	//update
	//1.조회용
	public boolean isOneData(int cno) {
		
		boolean flag=false;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from myclub where cno="+cno;
		
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
		}
		return flag;
	}
	
	//2.업데이트
	//,String udaddr,String udjob,String udhp
	public void updateMyClub()
	{
		System.out.println("***회원수정하기***");
		System.out.println("===수정을 원하는 회원번호를 입력하시오===");
		int udnum=Integer.parseInt(sc.nextLine());
		
		if(!isOneData(udnum))
		{
			System.out.println("----존재하지 않는 회원번호 입니다----");	
			return;
		}
			
		
		System.out.println("수정할 회원명을 입력하시오");
		String udname=sc.nextLine();
		System.out.println("수정할 주소을 입력하시오");
		String udaddr=sc.nextLine();
		System.out.println("수정할 직업을 입력하시오");
		String udjob=sc.nextLine();
		System.out.println("수정할 전화번호을 입력하시오");
		String udhp=sc.nextLine();
		
		//update myclub set cname='udname',caddr='udaddr',cjob='udjob' where cno='udnum';
		String sql="update myclub set cname='"+udname+"',caddr='"+udaddr+"',cjob='"+udjob+"' where cno="+udnum;
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}

	}
	
	//회원명의 일부를 입력시 모든 컬럼 조회되도록 만드시오
	public void searchName() {
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		System.out.println("조회하려는 회원명(일부가능)을 입력하세요");
		String searchname=sc.nextLine();
		
		String sql="select * from myclub where cname LIKE '%"+searchname+"%'";
		System.out.println(sql);
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***검색된 회원목록***");
			System.out.println("회원번호\t회원명\t주소\t직업\t전화번호\t가입일자");
			System.out.println("===================================================================");
			while(rs.next())
			{
				System.out.println(rs.getInt("cno")+"\t"+rs.getString("cname")+"\t"+
			rs.getString("caddr")+"\t"+rs.getString("cjob")+"\t"+rs.getString("chp")+"\t"+rs.getDate("gaipday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		ConnectMyClub mc=new ConnectMyClub();

		while(true)
		{
			System.out.println("1.회원가입    2.회원조회    3.회원삭제    4.회원정보수정     5.회원검색    9.종료");
			System.out.println("===================================================================");
			System.out.println("원하시는 숫자를 입력하세요");
			
			int num=Integer.parseInt(sc.nextLine());
			
			if(num==1)
				mc.insertMyClub();
			else if(num==2)
				mc.selectMyClub();
			else if(num==3)
				mc.deleteMyClub();
			else if(num==4)
				mc.updateMyClub();
			else if(num==5)
				mc.searchName();
			else if(num==9)
			{
				System.out.println("***종료되었습니다***");
				break;
			}
		}
		

		

	}

}
