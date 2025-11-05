package day1105;

import java.util.Scanner;

interface Command{
	public void write();
}

//insert
class Insert implements Command{
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 글을 작성합니다");
	}
	
}
//select
class Select implements Command{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 글을 조회합니다");
	}
	
	
}
//update
class Update implements Command{
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 글을 수정합니다");
	}
	
}
//delete
class Delete implements Command{
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 글을 삭제합니다");
	}
	
}


public class Ex2InterCRUD {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		//인터페이스로 선언
		Command comm=null;
		int num;
		
		while(true)
		{
			System.out.println("[메뉴]  1.추가  2.조회  3.수정  4.삭제  5.종료");
			System.out.println("====================================");
			num=sc.nextInt();
			if(num==1)
				comm=new Insert();
			else if(num==2)
				comm=new Select();
			else if(num==3)
				comm=new Update();
			else if(num==4)
				comm=new Delete();
			else if(num==5) {
				System.out.println("메뉴를 종료합니다");
				break;
			}
			
			if(num<=4)
				comm.write();
			else
				break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Command comm=null; //인터페이스로 선언
//		int num;
//
//		while(true)
//		{
//			System.out.println("[메뉴]  1.추가  2.조회  3.수정  4.삭제  5.종료");
//			System.out.println("==========================================");
//			num=sc.nextInt();
//			if(num==1)
//				comm=new Insert(); //구현한 클래스로 생성
//			else if(num==2)
//				comm=new Select();
//			else if(num==3)
//				comm=new Update();
//			else if(num==4)
//				comm=new Delete();
//			else if(num==5) {
//				System.out.println("메뉴를 종료합니다");
//				break;
//			}
//			
//			if(num<=4)
//				comm.write();
//			else
//				break;
//				
//
//		}
		
	}

}
