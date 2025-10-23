package day1023;

import java.util.Scanner;

public class IfReview_01 {

	public static void main(String[] args) {
		// 이름과 자바 스프링 점수를 입력 후 총점을 구하시오.
		// 총점이 180점이상이면 "합격", 170점이상이면 "좀 더 노력할것!!", 170점미만은 "재시험"
		// 조건은 if,삼항연산자 아무거나 선택해서 하세요
		
		// import
		Scanner sc=new Scanner(System.in);
		
		// 변수
		String name, result;
		int java, spring;
		
		//입력
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		System.out.println("자바 점수를 입력하세요");
		java=sc.nextInt();
		System.out.println("스프링 점수를 입력하세요");
		spring=sc.nextInt();
		
		//계산
		int total=java+spring;
		
		//출력
		System.out.println("이름: "+name);
//		System.out.println("자바점수: "+java+"점");
//		System.out.println("스프링점수: "+spring+"점");
		System.out.println("총점: "+total);
		//t
		System.out.println("평가: "+(total>=180?"합격":total>=170?"좀 더 노력할것!!":"재시험"));
//		
//		//조건_if
//		if (total>=180)
//			System.out.println("합격");
//		else if (total>=170)
//			System.out.println("좀 더 노력할것!!");
//		else
//			System.out.println("재시험");
//		
//		result=total>=180?"합격":
//			total>=170?"좀 더 노력할것!!":"재시험";
		
//		//조건_삼항
//		System.out.println(result);
		
		

		
		

	}

}
