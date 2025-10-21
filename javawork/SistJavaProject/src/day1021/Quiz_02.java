package day1021;

import java.util.Calendar;
import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		/*
		 당신의 이름은?
		 김효신
		 당신이 태어난 연도는?
		 1997
		 당신이 사는 지역은?
		 대전
		 ====================
		 [김효신 님의 개인정보]
		 지역: 대전
		 나이: 28세
		 */
		
		//import
		Scanner sc=new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		//변수
		String name, region;
		int myyear,nowyear,age;
				
		//입력
		System.out.println("당신의 이름은");
		name=sc.nextLine();
		System.out.println("당신이 태어난 연도는?");
		myyear=Integer.parseInt(sc.nextLine());
		System.out.println("당신이 사는 지역은?");
		region=sc.nextLine();
		
		//계산
		nowyear=cal.get(cal.YEAR);
		age = nowyear-myyear;
		
		//출력
		System.out.println("====================");
		System.out.println("["+name+" 님의 개인정보]");
		System.out.println("지역: "+region);
		System.out.println("나이: "+age);


	}

}
