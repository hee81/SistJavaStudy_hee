package day1024;

import java.util.Random;

public class RandomTest_08 {

	public static void main(String[] args) {
		/*
		 자바에서 난수를 구하는 방법 2가지
		 1.
		 2.Random 클래스를 생성해서 구하는 방법		 
		 */ 
		
		Random r=new Random();
		
		System.out.println("0~9사이의 난수 5개발생");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(10); //0~9
			System.out.println(n);
		}
		
		System.out.println("==================================");
		System.out.println("0~99사이의 난수 5개발생");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(100); //0~99
			System.out.println(n);
		}
		
		System.out.println("==================================");
		System.out.println("1~10까지의 난수 5개발생");
		
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(10)+1; //1~10
			System.out.println(n);
		}
		
		System.out.println("==================================");
		System.out.println("A~Z까지의 난수 5개발생");
		
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(26)+65; //A:65~Z:90
			System.out.println((char)n);
		}
		
		System.out.println("==================================");
		System.out.println("20~30까지의 난수 5개발생");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(11)+20;
			System.out.println(n);
		}

	}

}
