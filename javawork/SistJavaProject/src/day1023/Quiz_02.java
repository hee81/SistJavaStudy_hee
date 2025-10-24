package day1023;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		// 여기서 호출해서 결과보면 됩니다
//		quiz01 ();
//		quiz02 ();
		quiz03();

	}
	public static void quiz01 () {
		/* 
		 팩토리얼 구할 숫자를 입력
		 3
		 3!=6
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int num;
		int result=1;
		
		System.out.println("숫자입력");
		num=sc.nextInt();
		
		for (int i=1;i<=num;i++)
		{
			result*=i;
		}
		
		System.out.println(num+"!="+result);
		
		sc.close();

		 
	}
	public static void quiz02 () {
		//1~100까지 중에서 5의 배수의 합을 구하시오
		//1~100까지 중 5의 배수의 합은 ****입니다
		
		int sum=0;
		for (int i=1;i<=100;i++)
		{
			if (i%5==0)
			
			sum+=i;
		}
		/*
		for(int i=5;i<=100;i+=5) //초기값5도 가능!
		{
			sum+=i;
		}
		*/
		System.out.println("5의 배수의 합은 "+sum+"입니다");
		

		

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
		
		Scanner sc=new Scanner(System.in);
		int num; //입력할 점수
		int cnt=0, tot=0;
		double avg; // =0 생략가능
		
		while(true)
		{
			System.out.println("점수를 입력하시오.");
			num=sc.nextInt();
			
			//break문
			if (num==0)
				break;
			//continue문
			if (num<0||num>100)
			{
				System.out.println("\t다시입력해주세요");
				continue;
			}
				
			cnt++;
			tot+=num;
	
		}
			
		avg=(double)tot/cnt;
		
		System.out.println("총갯수: "+cnt);
		System.out.println("총점: "+tot);
		System.out.printf("평균: %.1f",avg);
		
		sc.close();
		
		
		
		
		
		
		
	}

}
