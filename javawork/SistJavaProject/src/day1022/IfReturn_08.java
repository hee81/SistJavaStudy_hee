package day1022;

import java.util.Scanner;

public class IfReturn_08 {

	public static void main(String[] args) {
		// 점수를 입력하는데 범위1~100만 입력하고
		// 잘못 입력되면 매서드 종료하기...
		
		Scanner sc=new Scanner(System.in);
		
		int score;
		
		System.out.println("점수를 입력하시오(1~100)");
		score=sc.nextInt();
		
		//잘못 입력한 경우 종료
		if (score<1 || score>100) {
			System.out.println("잘못입력했습니다");
			return; //현재 함수(main) 종료
		}
		else 
			System.out.println("점수: "+score);

	}

}
