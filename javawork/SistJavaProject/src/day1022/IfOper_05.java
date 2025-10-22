package day1022;

import java.util.Scanner;

public class IfOper_05 {

	public static void main(String[] args) {
		// 점수를 입력하여 학점을 알아보고 평가 구하기
		// 학점: if
		// 평가: 삼항연산자(90점이상:장학생  80점이상:잘함  80점미만:재수강)
		
		/*
		 점수를 입력하시오
		 78
		 학점: C학점
		 평가: 재수강
		 */
		  
		//import
		Scanner sca = new Scanner(System.in);
		
		//변수
		String grade;
		int score;
		String pmsg; //평가 함수
				
		//입력
		System.out.println("점수를 입력하시오");
		score=sca.nextInt();
		
		//조건
		if (score>=90)
			grade="A";
		else if (score>=80)
			grade="B";
		else if (score>=70)
			grade="C";
		else if (score>=60)
			grade="D";
		else
			grade="F";
		
		//출력
		System.out.println(score);
		System.out.println("학점: "+grade+"학점");
		
		//평가 구하기_삼항연산자
		pmsg=(score>=90)?"장학생":(score>=80)?"잘함":"재수강";
		System.out.println("평가: "+pmsg);

	}

}
