package day1022;

import java.util.Scanner;

public class IfMax_04 {

	public static void main(String[] args) {
		// 3개의 숫자를 입력하여 max 값을 구해보세요
		// if문이용
		// 3개의 숫자 중 가장 큰수는 ** 입니다.
		//import
		Scanner sc = new Scanner(System.in);
		
		//변수
		int a,b,c,max,min;
		
		//입력
		System.out.println("3가지 숫자를 비교하는 조건입니다.\n숫자 3가지를 입력하시오");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		
		System.out.println(a+","+b+","+c);
		
		//조건
		if (a>b && a>c)
			max=a;
		else if (b>a && b>c)
			max=b;
		else
			max=c;
		
		//출력
		System.out.println("If_3개의 숫자 중 가장 큰 수는 " +max+"입니다.");
		
		//삼항
		max=(a>b&&a>c)?a:
			(b>a&&b>c)?b:c;
		System.out.println("삼항_3개의 숫자 중 가장 큰 수는 " +max+"입니다.");
		
		//if 또는 삼항연산자 이용하여 min값 구하기
		min=(a<b&&a<c)?a:
			(b<a&&b<c)?b:c;
		
		System.out.println("Min="+min);
		
		
			
			

	}

}
