package day1021;

import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// Q. 2개의 숫자를 입력하여 + - * % 을 구해봅시다
		/*
		 첫번째 숫자는? 7
		 두번째 숫자는? 3
		 ==============
		 	[결과출력]
	 	두수의 합은 10 입니다
	 	두수의 차이는 4 입니다
	 	두수의 곱은 21 입니다
	 	두수를 나누면 2 입니다
	 	두수를 나누면 나머지가 1 입니다
	 	*/
		
		//import
		Scanner sc = new Scanner(System.in);
		
		//변수
		int a, b;
		
		//입력
		System.out.print("첫번째 숫자는? ");
		a=Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자는? ");
		b=Integer.parseInt(sc.nextLine());
				
		//출력
		System.out.println("==============");
		System.out.println("\t[결과출력]");
		System.out.println("두수의 합은 "+(a+b)+" 입니다");
		System.out.println("두수의 차이는 "+(a-b)+" 입니다");
		System.out.println("두수의 곱은 "+(a*b)+" 입니다");
		System.out.println("두수를 나누면 "+(a/b)+" 입니다");
		System.out.println("두수를 나누면 나머지가 "+(a%b)+" 입니다");

	}

}
