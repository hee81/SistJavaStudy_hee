package day1119;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectHello {
	
	DbConnect db=new DbConnect();
		
	//insert_rs 안함.
	public void insertHello()
	{
		Scanner sc=new Scanner(System.in);

		//hello 테이블에 입력할 데이터
		System.out.println("당신의 이름은?");
		String name=sc.nextLine();
		System.out.println("당신의 나이는?");
		int age=Integer.parseInt(sc.nextLine()); //String 가능
		
		//입력된 이름과 나이가 sql문의 변수로 들어가야 하므로 입력(sc)이후 sql문 작성
		//insert into hello values(seq4.nextval,'홍길동',33,sysdate); 에 변수를 넣어준다.
		String sql="insert into hello values(seq4.nextval,'"+name+"',"+age+",sysdate)";
		System.out.println(sql); //sql 누락된 표현을 콘솔에서 확인을 위해 작성함.
		
		//db연결
		Connection conn=db.getDbConnect();
		
		//statement_null 입력안하면 try-catch 접근 어려움
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("***db에 추가성공!!***");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//select
	public void selectHello() 
	{
		System.out.println("번호\t이름\t나이\t등록일자");
		System.out.println("===============================");
		
		//db 연결
		Connection conn=db.getDbConnect();
		//Statement
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from hello order by num";
		
		try {
			stmt=conn.createStatement();
			//executeQuery메서드 이용해서 결과는 ResultSet으로 얻는다
			rs=stmt.executeQuery(sql);
			
			//2개 이상일 땐 while
			while(rs.next())
			{
				System.out.println(rs.getInt("num")+"\t"+rs.getString("name")+"\t"+rs.getInt("age")+
						"\t"+rs.getString("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		

	}
	
	public void deleteHello()
	{
		//삭제할 번호 입력 후 그 번호를 변수로 받아서 삭제한다
		Scanner sc=new Scanner(System.in);		
		System.out.println("삭제할 번호를 입력하세요");
		int delnum=Integer.parseInt(sc.nextLine());
		
		String sql="delete from hello where num="+delnum;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			
			//없는 번호 삭제해도 실행이 된다! 있다 없다만 반환 boolean은 조건 안줌
//			stmt.execute(sql); 
//			System.out.println("***삭제되었습니다***");
			
			int a=stmt.executeUpdate(sql); //성공한 레코드의 갯수 반환
			
			if(a==0)
				System.out.println("***없는 데이터 번호입니다***");
			else //삭제되면 1이 반환
				System.out.println("***삭제되었습니다***");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			db.dbClose(stmt, conn);
		}
	}

	//1.수정_수정하려는 하나의 데이터를 조회해야함 //웹에서 1개 이상의 데이터가 있으면 불가능, 완전한 데이터인 경우에만 가능하다??
	//num을 일자로 받아 데이터가 있으면 true,데이터가 없으면 false로 반환해주는 메서드
	public boolean isOneData(int num) //둘의 데이터형을 맞춰줘야함
	{
		//초기값
		boolean flag=false;
		
		String sql="select * from hello where num="+num;
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			//데이터가 1개일 땐-if
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
	
	
	//2.수정_Update
	public void updateHello()
	{
		//시퀀스를 입력하여 해당 시퀀스의 이름과 나이를 수정한다
		Scanner sc=new Scanner(System.in);
		System.out.println("수정할 번호를 입력하세요");
		int updateNum=Integer.parseInt(sc.nextLine()); //둘의 데이터형을 맞춰줘야함
		
		//위의 boolean을 반환하는 매서드를 만든 후 수정하려는 번호가 존재하는지 미리 체크해본다..
		if(!isOneData(updateNum)) //1.수정에서 조회된 번호와 updateNum에서 입력된 번호가 서로 다르면 메서드가 종료된다.
		{
			System.out.println("해당 번호는 존재하지 않습니다");
			return; //메서드 종료
		}
		
		
		System.out.println("수정할 이름을 입력하세요");
		String updateName=sc.nextLine();
		System.out.println("수정할 나이를 입력하세요");
		int updateAge=Integer.parseInt(sc.nextLine());
		
		//update hello set name='김흥민',age=42 where num=4;
		String sql="update hello set name= '"+updateName+"',age="+updateAge+" where num="+updateNum;
		System.out.println(sql);
		
		Connection conn=db.getDbConnect();
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
			
//			stmt.execute(sql); 
			int a=stmt.executeUpdate(sql);
			
			if(a==0)
				System.out.println("수정할 데이터가 존재하지 않음");
			else
				System.out.println("**수정됨**");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}

	public static void main(String[] args) {
		ConnectHello hello=new ConnectHello();
		
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("1.insert    2.select    3.delete    4.update    9.exit");
			System.out.println("=============================================================");
			n=Integer.parseInt(sc.nextLine());
			
			System.out.println();
			
			if(n==1)
				hello.insertHello();
			else if(n==2)
				hello.selectHello();
			else if(n==3)
				hello.deleteHello();
			else if(n==4)
				hello.updateHello();
			else if(n==9)
			{
				System.out.println("***프로그램 종료***");
				break;
			}
			
		}
			


	}

}
