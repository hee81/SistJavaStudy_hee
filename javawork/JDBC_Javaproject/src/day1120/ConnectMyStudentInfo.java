package day1120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day1119.DbConnect;

public class ConnectMyStudentInfo {
	
	Scanner sc=new Scanner(System.in);
	DbConnect db=new DbConnect();

	//insert
	public void insertMyStudentInfo() {
		System.out.println("***학생정보입력***");
		System.out.println("이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("주소를 입력하세요");
		String addr=sc.nextLine();
		System.out.println("학년을 입력하세요");
		int grade=Integer.parseInt(sc.nextLine());
		System.out.println("혈액형을 입력하세요");
		String blood=sc.nextLine();
		System.out.println("생일을 입력하세요");
		String birth=sc.nextLine();
		
		String sql="insert into MyStudentInfo values(seq4.nextval,?,?,?,?,?,sysdate)";
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//?바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, grade);
			pstmt.setString(4, blood);
			pstmt.setString(5, birth);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//select
	public void selectMyStudentInfo() {
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from MyStudentInfo order by stu_no";
		
		System.out.println("***전체학생정보***");
		System.out.println("학생번호\t학생명\t주소\t학년\t혈액형\t생년월일\t등록일자");
		
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("stu_no")+"\t"+rs.getString("stu_name")+"\t"+
			rs.getString("stu_addr")+"\t"+rs.getInt("stu_grade")+"학년\t"+rs.getString("stu_blood")+"형\t"+
						rs.getString("stu_birth")+"\t"+rs.getDate("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	//delete
	public void deleteMyStudentInfo() {
		System.out.println("***회원정보삭제***");
		System.out.println("삭제하려는 학생번호를 입력하세요");
		int delnum=Integer.parseInt(sc.nextLine());
		
		String sql="delete from MyStudentInfo where stu_no=?";
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, delnum);
			
			int a=pstmt.executeUpdate();
			
			if(a==0)
				System.out.println("------"+delnum+"번은 존재하지 않는 번호입니다------");
			else
				System.out.println("------"+delnum+"번 학생정보는 삭제되었습니다------");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}
	
	//update 1.조회용
	public boolean isOneDate(int num)
	{
		boolean flag=false;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from MyStudentInfo where stu_no="+num;
		
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
	
	//update 2.수정용
	public void updateMyStudentInfo() {
		System.out.println("***학생정보수정***");
		System.out.println("수정하려는 학생 번호를 입력하세요");
		int upnum=Integer.parseInt(sc.nextLine());
		
		if(!isOneDate(upnum))
		{
			System.out.println("------"+upnum+"번은 존재하지 않는 번호입니다------");
			return;
		}
		
		System.out.println("수정할 이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("수정할 주소를 입력하세요");
		String addr=sc.nextLine();
		System.out.println("수정할 학년을 입력하세요");
		int grade=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 혈액형을 입력하세요");
		String blood=sc.nextLine();
		System.out.println("수정할 생일을 입력하세요");
		String birth=sc.nextLine();
		
		String sql="update MyStudentInfo set stu_name=?,stu_addr=?,stu_grade=?,stu_blood=?,stu_birth=?";
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, grade);
			pstmt.setString(4, blood);
			pstmt.setString(5, birth);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//Search_성으로 검색
	public void SearchMyStudentInfo() {
		System.out.println("***검색할 학생의 성을 입력하세요***");
		String searchname = sc.nextLine();
		
		String sql="select * from MyStudentInfo where stu_name like ?";
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,searchname+"%");
			
			pstmt.execute();
			
			rs=pstmt.executeQuery();
			
			System.out.println("***검색한 학생정보***");
			System.out.println("학생번호\t학생명\t주소\t학년\t혈액형\t생년월일\t등록일자");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("stu_no")+"\t"+rs.getString("stu_name")+"\t"+
			rs.getString("stu_addr")+"\t"+rs.getInt("stu_grade")+"학년\t"+rs.getString("stu_blood")+"형\t"+
						rs.getString("stu_birth")+"\t"+rs.getDate("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	//출력
	public void processMyStudentInfo() {

		ConnectMyStudentInfo mystu=new ConnectMyStudentInfo();
		
		while(true)
		{
			System.out.println("============================번호를 입력하세요==============================");
			System.out.println("1.학생정보입력   2.학생정보조회  3.학생정보삭제    4.학생정보수정   5.학생검색(성)  9.종료");
			int num=Integer.parseInt(sc.nextLine());
			
			if(num==1)
				mystu.insertMyStudentInfo();
			else if(num==2)
				mystu.selectMyStudentInfo();
			else if(num==3)
				mystu.deleteMyStudentInfo();
			else if(num==4)
				mystu.updateMyStudentInfo();
			else if(num==5)
				mystu.SearchMyStudentInfo();
			else if(num==9)
			{
				System.out.println("****프로그램 종료****");
				break;
			}

		}

	}
	
	
	public static void main(String[] args) {
		ConnectMyStudentInfo mystu=new ConnectMyStudentInfo();
		mystu.processMyStudentInfo();

	}

}
