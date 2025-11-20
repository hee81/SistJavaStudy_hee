package day1120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day1119.DbConnect;

public class ConnectMymallipgo {

	Scanner sc=new Scanner(System.in);
	
	//Connect,dbClose 메서드가 있는 클래스 생성
	DbConnect db=new DbConnect();
	
	//insert
	public void insertMymallipgo() {
		System.out.println("입고된 상품의 카데고리는?(음료,과자류)");
		String cate=sc.nextLine();
		System.out.println("입고된 상품명은?");
		String sangName=sc.nextLine();
		System.out.println("입고된 상품의 갯수는?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("입고된 상품의 가격은?");
		int price=Integer.parseInt(sc.nextLine());
		
		//완성문 sql
//		String sql="insert into mymallipgo values(seq4.nextval,'"+cate+"','"+sangName+"',"+su+","+price+",sysdate)";
		
		//prepareStatement 객체는 미완성된 sql문을 작성할 수 있다.
		//변수를 ?로 표시 후 나중에 바인딩 시켜준다
		String sql="insert into mymallipgo values(seq4.nextval,?,?,?,?,sysdate)";
		
		//db연결
		Connection conn=db.getDbConnect();
		
		//sql전달
		//prepare 가 가독성이 더 좋음!->유지보수가 더 좋음
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql); //먼저 sql문을 전달한다...왜 ?바인딩 하기 위해서
			
			//?순서대로 바인딩
			pstmt.setString(1, cate); //parameter->넘겨줄 번호를 말한다
			pstmt.setString(2, sangName);
			pstmt.setInt(3, su);
			pstmt.setInt(4, price);
			
			//업데이트
			int a=pstmt.executeUpdate();
			
			if(a==1)
				System.out.println("인서트 성공!!");
			else
				System.out.println("인서트 실패!!!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

		
	}
	//select
	public void seleteMymallipgo() {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from mymallipgo order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("상품번호\t카테고리\t상품명\t수량\t가격\t입고일");
			System.out.println("================================================");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("num")+"\t"+rs.getString("category")+"\t"+
			rs.getString("sangpum")+"\t"+rs.getInt("su")+"개\t"+rs.getInt("price")+"원\t"+rs.getDate("ipgo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	//delete
	public void deleteMymallipgo() {
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		//상품번호를 선택 후 삭제할 것!!!-오후에!!!!
		System.out.println("**삭제를 원하는 상품번호를 입력하시오**");
		int delnum=Integer.parseInt(sc.nextLine());
		
		//String sql="delete from mymallipgo where num="+delnum;
		String sql="delete from mymallipgo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setInt(1, delnum);
			
			//업데이트
			int n=pstmt.executeUpdate();
			if(n==0)
				System.out.println(delnum+"번은 존재하지 않는 상품번호 입니다");
			else
				System.out.println(delnum+"번은 삭제되었습니다");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}
	
	//update
	//수정할 시퀀스 입력 후 수정할 컬럼 수정하기
	public void updateMymallipgo() {
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		System.out.println("---수정할 상품번호를 입력하시오----");
		int num=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 상품의 카데고리는?(음료,과자류)");
		String cate=sc.nextLine();
		System.out.println("수정할 상품명은?");
		String sangName=sc.nextLine();
		System.out.println("수정할 상품의 갯수는?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 상품의 가격은?");
		int price=Integer.parseInt(sc.nextLine());
		
		String sql="update mymallipgo set category=?,sangpum=?,su=?,price=? where num=?"; //where 빼먹지 말기
//		String sql="update mymallipgo set category=? where num=?"; //일부만 수정 가능!
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?순서대로 바인딩
			pstmt.setString(1, cate);
			pstmt.setString(2, sangName);
			pstmt.setInt(3, su);
			pstmt.setInt(4, price);
			pstmt.setInt(5, num);
			
			//업데이트
			pstmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}
	
	//상품명의 일부의 입력 후 검색
	public void searchSangpum() {
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("상품을 검색하시오(일부 가능)");
		String sang=sc.nextLine();
		
		String sql="select * from mymallipgo where sangpum like ?";
		System.out.println(sql);
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+sang+"%");
			rs=pstmt.executeQuery();
			
			System.out.println("상품번호\t카테고리\t상품명\t수량\t가격\t입고일");
			System.out.println("================================================");
			
			//2개이상 가능하기에 while
			while(rs.next())
			{
				System.out.println(rs.getInt("num")+"\t"+rs.getString("category")+"\t"+
			rs.getString("sangpum")+"\t"+rs.getInt("su")+"개\t"+rs.getInt("price")+"원\t"+rs.getDate("ipgo"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}
	
	
	//write_process(출력문도 메서드로 작성)
	public void processMymallipgo() {
		
		ConnectMymallipgo mymall=new ConnectMymallipgo();

		while(true)
		{
			System.out.println("\t***MyMall 입고 상품 현황***");
			System.out.println("1.상품입고     2.상품재고현황     3.상품삭제     4.상품정보수정     5.상품검색     9.종료");
			int selnum=Integer.parseInt(sc.nextLine());
			
			if(selnum==1)
				mymall.insertMymallipgo();
			else if(selnum==2)
				mymall.seleteMymallipgo();
			else if(selnum==3)
				mymall.deleteMymallipgo();
			else if(selnum==4)
				mymall.updateMymallipgo();
			else if(selnum==5)
				mymall.searchSangpum();
			else if(selnum==9)
			{
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		ConnectMymallipgo mymall=new ConnectMymallipgo();
		mymall.processMymallipgo();

	}

}
