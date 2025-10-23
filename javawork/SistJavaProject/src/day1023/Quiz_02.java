package day1023;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		// 여기서 호출해서 결과보면 됩니다
//		quiz01 ();

	}
	public static void quiz01 () {
		/* 
		 팩토리얼 구할 숫자를 입력
		 5
		 5!=6
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int x;
		
		System.out.println("팩토리얼 구할 숫자를 입력하시오");
		x=sc.nextInt();
		
		for(int i=1;i<=x;i++)
		{
			if (x>=5)
				break;
			
			x+=i;
			System.out.println(x);
			

		}
		
		
		 
	}
	public static void quiz02 () {
		//1~100까지 중에서 5의 배수의 합을 구하시오
		//1~100까지 중 5의 배수의 합은 ****입니다
		

	}
	public static void quiz03 () {
		/*
		 점수(1~100)를 입력받다가 0을 입력하면 반복문 빠져나온 후에
		 총갯수, 총점, 평균 출력하기
		 78
		 90
		 120
		    다시입력해주세요
		 88
		 77
		 0
		 
		 총갯수:
		 총점:
		 평균: 소숫점1자리
		 */
	}

}
