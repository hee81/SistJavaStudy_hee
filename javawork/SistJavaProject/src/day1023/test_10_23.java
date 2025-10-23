package day1023;

import java.util.Scanner;

public class test_10_23 {

	public static void main(String[] args) {
		
//		test2();
//		test3();
//		test4();
		test7();
//		test13();

	}
	public static void test2() {
		
		int n=3;
		
		switch(n)
		{
		case 1:
			System.out.println("n is 1");
			break;
		case 2:
			System.out.println("n is 2");
			break;
		case 3:
			System.out.println("n is 3");
			break;
		default:
			System.out.println("n is>3");
		}
		
	}
	public static void test3() {
		// switch
		// 학점을 switch로 구해보시오
		// 변수=score, grade
		// score/10 10단위로 묶어서
		
		int score=75;
		char grade;
		
		switch(score/10)
		{
		case 10: case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
			default:
				grade='F';
		}
		System.out.println("당신의 학점은 "+grade+"입니다");

		
	}
	public static void test4() {
		// 숫자를 입력받아 그숫자가 홀수인지 짝수인지 출력
		// if, switch 로 구해보자
		Scanner sc=new Scanner(System.in);
		int num;
		
		System.out.println("숫자입력");
		num=sc.nextInt();
		
		//if
		if (num%2==0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
		
		//switch
		switch(num%2)
		{
			case 0:
				System.out.println("짝수");
				break;
				default:
					System.out.println("홀수");
		}
		sc.close();
		
	}
	public static void test7() {
		// 1~10까지 반복출력
		//_For문
		for (int i=1;i<=10;i++)
			System.out.print(i+" ");
		
		System.out.println();
		//While문
		int i=1;
		while(i<=10)
		{
			System.out.printf("%4d",i);
			i++;
		}
		System.out.println();
		
		//1 4 7 7 10 출력
		//for문으로
		for (int c=1;c<=10;c+=3)
		{
			System.out.print(c+" ");
		}
		System.out.println();
		//While문
		int c=1;
		while(c<=10)
		{
			System.out.println(c);
			c+=3;
		}
		System.out.println();
		//Hello를 가로방향으로 5번 출력하시오
		//_for
		for (int d=1;d<=5;d++)
		{
			System.out.println("Hello ");
		}
		System.out.println();
		
		//while(true)
		int d=1;
		while(true)
		{
			System.out.println(d);
			d++;
			
			if(d>10)
				break;
		}
			
		
	}
	public static void test13() {
		// 반복해서 이름을 입력 후 김씨가 몇 명인지...(startsWith,equals사용)
		// 끝이라고 쓰면 프로그램 종료
		Scanner sc=new Scanner(System.in);
		
		String name;
		int cnt=0;
		
		while(true)
		{
			System.out.println("이름을 입력하시오(종료:끝)");
			name=sc.nextLine();
			
			if (name.equals("끝"))
				break;
			
			if (name.startsWith("김"))
				cnt++;
		}
		
		System.out.println("김씨성을 가진 사람의 총 합은 "+cnt+"입니다");
		
		sc.close();  //resource leak 경고떠서 추가했음.
	}

}
