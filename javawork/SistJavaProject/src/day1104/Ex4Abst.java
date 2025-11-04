package day1104;

import java.util.Scanner;

//super
abstract class Board{
	public abstract void process(); //abstract=미완성 메서드를 의미한다.
}

//sub1
class Insert extends Board{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 작성합니다");
	}
}

//sub2
class Select extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 출력(조회)합니다");
	}     
	
}

//sub3
class Update extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 수정합니다");
	}
	
}

//sub4
class Delete extends Board{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시글을 삭제합니다");
	}
	
}



public class Ex4Abst {

	public static void main(String[] args) {
		// 다형성 출력_반복문-->Scanner사용
//		Board test=new Board(); //추상클래스는 new객체로 생성이 안됨
		Scanner sc=new Scanner(System.in);
		int num;
		Board board=null; //선언만 부모로..(반복할거임)
		
		while(true) {
			System.out.println("1.입력  2.출력  3.수정  4.삭제  5.종료");
			num=sc.nextInt();
			
			switch(num)
			{
			case 1:
				board=new Insert();
				break;
			case 2:
				board=new Select();
				break;
			case 3:
				board=new Update();
				break;
			case 4:
				board=new Delete();
				break;
			default:
				System.out.println("종료합니다");
				System.exit(0); //강제종료
			}
			
			board.process();
			
		}

	}

}
