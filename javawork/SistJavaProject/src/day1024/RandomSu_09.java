package day1024;

import java.util.Scanner;

public class RandomSu_09 {

	public static void main(String[] args) {
		// 1~100사이의 난수를 발생시켜 그 숫자를 맞추기
		// 반복문을 발생시켜서 1~100까지의 난수를 변수 rnd에 저장
		
		Scanner sc=new Scanner(System.in);
		
		//1~100까지의 난수발생 Math클래스의 random매서드로
		int rnd=(int)(Math.random()*100)+1;
		int su;
		
//		while(true)
//		{
//			System.out.println("1~100까지의 랜덤숫자를 맞춰주세요");
//			su=sc.nextInt();
//			
//			if(su>rnd)
//				System.out.println(su+"보다 작습니다");
//			else if(su<rnd)
//				System.out.println(su+"보다 큽니다");
//			else
//			{
//				System.out.println("맞았습니다 정답은 "+rnd+"입니다");
//				break;
//			}
//				
//		}
//		
//		System.out.println("숫자 맞추기 종료");
		
		//cnt 횟수 제한하기!(5회)
		
		int cnt=0;
		
		for(int i=1;i<=5;i++)
		{
			System.out.println("1~100까지의 랜덤숫자를 맞춰주세요");
			su=sc.nextInt();
			
			if(su>rnd)
				System.out.println(su+"보다 작습니다");
			else if(su<rnd)
				System.out.println(su+"보다 큽니다");
			else
			{
				System.out.println("맞았습니다 정답은 "+rnd+"입니다");
				break;
			}
		}
			
		System.out.println("숫자 맞추기 종료");
		
	}

}
