package day1023;

import java.util.Scanner;

public class WhileTrue_12 {

	public static void main(String[] args) {
		
//		test1();
		test2();
		
		


	} //main매서드 끝
	
	public static void test1() {
		// 점수를 입력 후 합계를 구하는데
		// 1~100이 아닌 경우는 제외
		// 0을 입력할 때까지 반복해서 점수를 입력한다(range 모름)
		// ~~whileTrue 사용~~
		
		Scanner sc=new Scanner(System.in);
		int sum=0; int score;
		
		while(true)
		{
			System.out.println("점수를 입력하시오");
			score=sc.nextInt();
			
			//break문
			if(score==0)
				break; //무한루프 방지
			
			//제외
			if(score<0||score>=100)
				continue; //다시 점수 입력 가능
			
			//합계
			sum+=score;
		}
		System.out.println("총 합계: "+sum);
		
		sc.close();
	}
	
	public static void test2() {
		// 임의수를 입력하여 합계와 평균, 갯수를 구한다
		// 단 0을 입력하면 반복문(while) 빠져나간다.
		
		Scanner sc=new Scanner(System.in);
		
		int su; //입력할 수
		int sum=0; //합계
		double avg=0; //평균
		int cnt=0;  //갯수
		
		while(true)
		{
			System.out.println("숫자를 입력하세요(종료:0)");
			su=sc.nextInt();
			
			if(su==0)
				break;
			
			sum+=su;
			cnt++;
		}
		
		avg=(double)sum/cnt;
		
		System.out.println("총 입력한 갯수: "+cnt);
		System.out.println("입력한 수의 합: "+sum);
		System.out.println("평균: "+avg);
		
		sc.close();
		
		
		
		
	}

}
