package day1023;

import java.util.Scanner;

public class ForQuiz_01 {

	public static void main(String[] args) {

		// 1~20까지를 출력하는데 5의 배수는 제외 후 출력하시오(for)
		for (int i=1;i<=20;i++)
		{
			if (i%5==0)
				continue;
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// 1~50까지 출력하는데 3씩 증가하게 출력합니다(1 4 7 10...)
		for (int i=1;i<=50;i+=3)
		{
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// 내가 숫자를 입력하면 1부터 입력한 숫자까지의 합계를 구해서 출력해보자
		// 합계를 구할 숫자는? 5
		// 1~5까지의 합은 15
		
		//import
		Scanner sc=new Scanner(System.in);
		//변수
		int sum=0;
		int x; //입력되는 숫자
		//입력
		System.out.println("1부터 입력한 숫자까지의 합계를 구하는 로직입니다");
		System.out.println("원하시는 숫자를 입력하시오");
		x=sc.nextInt();
		//조건
		for(int i=1;i<=x;i++)
		{
			sum+=i;
			System.out.println(i);
		}
		//출력
		System.out.println("1~"+x+"까지의 합은 "+sum);
			
		
		
		//Quiz4 교제p66
		//1~100까지의 숫자중에서 짝수의 합과 홀수의 합을 나누어 출력
		//짝수의 합 even:***
		//홀수의 합 odd:***
		
		int tot4=0;
		int esum=0;
		int osum=0;
		
		for(int i=1;i<=100;i++)
		{
			//전체합
			tot4+=i;
			//짝수합
			if(i%2==0)
				esum+=i;
			//홀수합
			else
				osum+=i;
		}
		
		System.out.println("1~100까지 합: "+tot4);
		System.out.println("1~100까지 짝수의 합:"+esum);
		System.out.println("1~100까지 홀수의 합:"+osum);
		
		
		
		
		
		
		
		
		
		
		

	}

}
