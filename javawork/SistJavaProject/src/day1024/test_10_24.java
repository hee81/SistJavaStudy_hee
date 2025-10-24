package day1024;

import java.util.Random;
import java.util.Scanner;

public class test_10_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		test1();
//		test2();
//		test3();
//		test4();
//		test5_01();
//		test5_02();
//		test6();
//		test7();
//		test8();
		test9();

	}
	
	public static void test1() {
		// 총 5개의 점수를 입력받아 합계를 구하려고 한다(반복문)
		// 만약 1~100이 아니라면 다시 입력하시오(continue)
		//.."잘못 입력함" 메세지 출력 후 다시 진행 
		/*
		 *번 점수:
		 총점: ***
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int num;
		int sum=0;
		
		for (int i=1;i<=5;i++) //for문으로 break 필요없음!
		{
			System.out.println(i+"번 점수: ");
			num=sc.nextInt();
			
			if (num<1||num>100)
			{
				System.out.println("잘못 입력함");
				i--;
				continue;				
			}
			
			sum+=num;
			
		}
		
		System.out.println("총점: "+sum);
		
		sc.close();
		
		
		
		
		
	}
	public static void test2() {
		// i가 1일때 j 4번반복
		// 다시 i가 2일때 j 4번 반복...이렇게 이중으로 반복되는 구조를 다중For문 이라고함.
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=4;j++)
			{
				System.out.println(i+":"+j);
			}
			System.out.println();
		}
		
	}
	public static void test3() {    
		
		// 연습1) test02에서 j 3 까지만 출력하시오
		System.out.println("**다중 for문 연습1**");
		
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=4;j++)
			{
				System.out.println(i+":"+j);
				if (j==3)
					break;
			}
			System.out.println();
		}
		
		// 연습2) test02에서 i 2 까지만 출력하시오
		System.out.println("**다중 for문 연습2**");
		for(int i=1;i<=3;i++)
		{
			
			
			for(int j=1;j<=4;j++)
			{
				System.out.println(i+":"+j);
			}
			System.out.println();
			
			if(i==2)
				break;
		}
		
		
	}
	public static void test4() {
		// 2~9단(세로)
		for (int i=2;i<=9;i++) //단
		{
			System.out.println("["+i+"단]");
			
			for(int j=1;j<=9;j++)
			{
				System.out.println(i+"x"+j+"="+(i*j));
			}
			System.out.println();
		}
				
		/* 구구단 2~9단(가로)
		 [*단]	[*단]
		 2X1=*	3X1=*
		 *X2=*	*X2=*
		 .		.
		 .		.
		 *X9=*	*X9=*
		 */
		for(int i=2;i<=9;i++)
		{
			System.out.print("["+i+"단]\t");
		}
		System.out.println();
		for(int j=1;j<=9;j++)
		{
			for(int i=2;i<=9;i++) //단
			{
				System.out.print(i+"x"+j+"="+(i*j)+"\t");
			}
			System.out.println();
		}

		
		
	}
	public static void test5_01() {
		// 원하는 단을 입력해서 해당 단만 출력해보자
		//
		/*
		 단을 입력하시오: 5
		 
		 [5단]
		 5X1=5
		 5X2=10
		 .
		 .
		 5X9=45
		 */
		//for문
		Scanner sc=new Scanner(System.in);
		
		int num;
		
		System.out.println("단을 입력하시오: ");
		num=sc.nextInt();
		System.out.println("["+num+"단]");
		
		for(int j=1;j<=9;j++)
		{
			System.out.println(num+"X"+j+"="+(num*j));
		}
		
		sc.close();

				
	}
	public static void test5_02() {
		// 원하는 단을 입력해서 해당 단만 출력해보자
		//
		/*
		 단을 입력하시오: 5
		 
		 [5단]
		 5X1=5
		 5X2=10
		 .
		 .
		 5X9=45
		 */
		//while문
		//원하는 단 입력_0이면 종료 :
		//2~9사이의 숫자만 넣어주세요
		//프로그램을 종료합니다.
		Scanner sc=new Scanner(System.in);
		
		int num;
		
		while(true)
		{
			System.out.println("원하는 단 입력_0이면 종료: ");
			num=sc.nextInt();
			
			//break
			if(num==0)
			{
				System.out.println("프로그램을 종료합니다");
				break;
			}
			//continue
			if(num<2||num>9)
			{
				System.out.println("2~9 사이의 숫자만 넣어주세요");
				continue;
			}
			
			System.out.println("["+num+"단]");
			
			for(int j=1;j<=9;j++)
			{
				
				System.out.println(num+"X"+j+"="+(num*j));
			}		
		}
		sc.close();	
		
	}
	public static void test6() {
		// 점수를 입력하다가 Q or q를 입력하면 while문을 빠져나온 후
		// 총갯수 총점 평균 구해서 출력하시오
		
		Scanner sc=new Scanner(System.in);
		
		String score;
		int cnt=0,tot=0;
		double avg;
		
		while(true)
		{
			System.out.println("점수를 입력하시오");
			score=sc.nextLine();
			
			//break
			if(score.equalsIgnoreCase("Q"))
				break;
			
			//continue (1~100까지만)
			if(Integer.parseInt(score)<1||Integer.parseInt(score)>100)
			{
				System.out.println("1~100까지의 점수만 입력해주세요");
				continue;
			}
			
			cnt++;
			tot+=Integer.parseInt(score);

		}
		
		avg=tot/cnt;
		
		System.out.println("총갯수: "+cnt);
		System.out.println("총점: "+tot);
		System.out.println("평균: "+avg);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public static void test7() {
		/*
		 자바에서 난수를 구하는 방법 2가지
		 1.Math.random()메서드 활용(강사님선호)
		 2.	 
		 */ 
		System.out.println("10개의 난수발생");
		
		for(int i=1;i<=10;i++)
		{
			double n=Math.random();
			System.out.println(n);
		}
		 System.out.println("0~9까지의 난수 발생");
		 double m=Math.random()*10;
		 System.out.println(m);
		 System.out.println("0~99까지의 난수발생");
		 int z=(int)(Math.random()*100);
		 System.out.println(z);
		 System.out.println("1~10까지의 난수발생");
		 double c=Math.random()*10+1;
		 System.out.println(c);
		 System.out.println("1~100까지의 난수발생");
		 int b=(int)(Math.random()*100+1);
		 System.out.println(b);
		 System.out.println("1~45까지의 난수발생");
		 int e=(int)(Math.random()*45+1);
		 System.out.println(e);
		 
	}
	public static void test8() {
		
		/*
		 자바에서 난수를 구하는 방법 2가지
		 1.
		 2.Random 클래스를 생성해서 구하는 방법		 
		 */
		System.out.println("5개의 난수발생");
		Random r=new Random();
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(11)+20;
			System.out.println(n);

		}
		System.out.println("0~9사이의 난수 5개발생");
		System.out.println("0~99사이의 난수 5개발생");
		System.out.println("1~10까지의 난수 5개발생");
		System.out.println("A~Z까지의 난수 5개발생"); //A:65 Z:90
		System.out.println("20~30까지의 난수 5개발생");
	}
	
	public static void test9() {
		// 1~100사이의 난수를 발생시켜 그 숫자를 맞추기
		// 반복문을 발생시켜서 1~100까지의 난수를 변수 rnd에 저장
		// 1~100까지의 난수발생 Math클래스의 random매서드로
		
		Scanner sc=new Scanner(System.in);
		int su;
		
		int rnd=(int)(Math.random()*100+1);
		
		while(true) {
			
			System.out.println("1~100의 수를 맞춰보세요");
			su=sc.nextInt();
			
			if (su<rnd)
				System.out.println(su+"보다 큽니다");
			else if (su<rnd)
				System.out.println(su+"보다 작습니다");
			else
			{
				System.out.println("정답입니다");
				break;
			}
		}
		
		System.out.println("숫자 맞추기 끝");
	}
	
}