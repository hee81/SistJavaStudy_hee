package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex5ListBoard {
	
	//List 클래스형으로 지정했으므로 데이터를 꺼내고 받을때도 클래스유형이어야 함.
	List<Ex5Board> list=new Vector<Ex5Board>();
	
	
	//입력
	public void inputData() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("작성자명");
		String name=sc.nextLine();
		System.out.println("글제목은");
		String subject=sc.nextLine();
		System.out.println("글내용은");
		String content=sc.nextLine();
		
		//생성이 되면서 생성된 값이 list로 추가가 된다.
//		Ex5Board data=new Ex5Board(name, subject, content);
//		list.add(data);	
		list.add(new Ex5Board(name, subject, content));
		
/*		list.add(new Ex5Board()); //생성은 됨, 값 못 넣음(맴버값에 접근이 안됨)
		Ex5Board data=new Ex5Board();
		data.setWriter(name);
		data.setSubject(subject);
		data.setContent(content);
		*/

		System.out.println("현재 데이터 갯수: "+list.size()+"개");

	}
	
	
	//출력
	public void writeData() {
		System.out.println("***게시판 출력***");
		System.out.println("=============================");
		for(int i=0;i<list.size();i++)
		{
			Ex5Board b=list.get(i); 
			//ㄴ리스트내에서 지정된 위치에 있는 요소값을 돌려준다//반환값이 class
			System.out.println("번호: "+(i+1)+"\t작성자: "+b.getWriter());
			System.out.println("제목: "+b.getSubject());
			System.out.println("내용: "+b.getContent());
			System.out.println("=============================");
		}
		

	}

	public static void main(String[] args) {
		Ex5ListBoard board=new Ex5ListBoard();
		
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("1.추가   2.출력   9.종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				board.inputData();
			else if(n==2)
				board.writeData();
			else if(n==9)
			{
				System.out.println("프로그램 종료");
				break;
			}

			
		}


	}

}
