package day1021;

import java.util.Scanner;

public class ScanTest_09 {

	public static void main(String[] args) {
		/* "점수는 int자료형으로 하시오"
		 이름입력: 홍길동(String)
		 점수: 88(int)
		 학년: 4(String)
		 [결과출력]
		 홍길동님은 4학년이며 평점은 88점입니다*/
		
		//import
		Scanner sc=new Scanner(System.in);
		//변수
		String name, grade; //대입연산자
		int score;
		//입력
		System.out.print("이름을 입력하세요");
		name=sc.nextLine();
		System.out.print("점수를 입력하세요");
		score=Integer.parseInt(sc.nextLine()); //Integer.parseInt("88")=88 (문자->숫자)
		System.out.print("학년을 입력하세요");
		grade=sc.nextLine();
		//출력
		System.out.println("=================");
		System.out.println("\t[결과출력]");
		System.out.println(name+"님은 "+grade+"학년이며 평점은 "+score+"점입니다.");

	}

}
