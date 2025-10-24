package day1024;

import java.util.Scanner;

public class Quiz1024_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		quiz1();
//		quiz2();
//		quiz3();
//		quiz4();
		quiz5();

	}
	public static void quiz1( ) {
		//1~10까지 중에서 짝수만 출력해주세요 (for,if)
		//2 4 6 8 10
		for(int i=1;i<=10;i++)
		{
			if(i%2==1)
				continue;
			System.out.print(i+" ");
		}
	}
	public static void quiz2( ) {
		//1~100까지의 숫자 중 3의 배수의 합과 갯수를 구하시오
		//3의 배수의 합=**
		//3의 배수의 갯수=**개
		
		int sum=0;
		int cnt=0;
		
		for(int i=3;i<=100;i+=3)
		{
			sum+=i;
			cnt++;
		}
		System.out.println("3의 배수의 합= "+sum);
		System.out.println("3의 배수의 갯수= "+cnt+"개");
			
	}
	public static void quiz3( ) {
		/*
		 1~5까지의 팩토리얼 구하기
		 1!=1
		 2!=2
		 3!=6
		 4!=24
		 5!=120
		 */
		int sum=1;
		
		for(int i=1;i<=5;i++)
		{
			sum*=i;
			System.out.println(i+"!="+sum);
		}
		
	}
	public static void quiz4( ) {
		/*
		 숫자를 입력하다가 0을 입력하면 반복문을 빠져나온 후(while-break)
		 양수의 갯수: 3개
		 음수의 갯수: 2개
		 */
		Scanner sc=new Scanner(System.in);
		int num;
		int plus=0;
		int mius=0;
		
		while(true)
		{
			System.out.println("숫자를 입력하시오");
			num=sc.nextInt();
			
			if (num>0)
				plus++;
			else if(num<0)
				mius--;
			else
				break;
				
		}
		
		System.out.println("양수의 갯수: "+plus+"개");
		System.err.println("음수의 갯수 : "+mius+"개");
		
		sc.close();
		
		
	}
	public static void quiz5( ) {
		//구구단을 세로로 출력하는데 2~9단까지의 반복이 3까지만 나오도록 해주세요
		/*
		 [2단]
		2x1=2
		2x2=4
		2x3=6
		.
		.
		.
		[9단]
		9x1=9
		9x2=18	
		9x3=27
		 */
		for(int i=2;i<=9;i++) //단
		{
			System.out.println("["+i+"단]");
			for(int j=1;j<=9;j++)
			{
				System.out.println(i+"X"+j+"="+(i*j));
				if(j==3)
					break;
			}
		}
		
	}


}
