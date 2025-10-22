package day1021;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test_1022 {

	public static void main(String[] args) {
		// 강제 형변환(cast연산자)
		
//		int x=7;
//		int y=4;
//		System.out.println(x/y);
//		System.out.println((double)x/y);
//		System.out.println(x/(double)y);
//		
//		double d = 100.0;
//		int i = 10;
//		int result = ((int)d/i);
//		double result2 = (d/i);
//		
//		char a = 'A';
//		System.out.println(a+2);
//		
//		
//		//import
//		Date date = new Date(); //잘 안씀
//		System.out.println(date.getYear()+1900);
//		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println(cal.get(cal.YEAR));
//				
//		//변수
//		String name;
//		int myYear, culYear;
//				
//		//입력
//		System.out.print("본인 성명을 입력하시오");;
//		name = sc.nextLine();
//		
//		System.out.println("태어난 연도를 입력하시오.");
//		myYear = sc.nextInt();
//		
//		//계산
//		culYear = cal.get(cal.YEAR);
//		
//		//출력
//		System.out.println("당신의 이름은: "+name);
//		System.out.println("당신의 나이는: "+(culYear-myYear));
		
		//06
		//변수
		String name2 ;
		int kor, mat, eng, total;
		//입력
		System.out.println("이름?");
		name2=sc.nextLine();
		System.out.println("국어");
		kor=Integer.parseInt(sc.nextLine());
		System.out.println("수학");
		mat=Integer.parseInt(sc.nextLine());
		System.out.println("영어");
		eng=Integer.parseInt(sc.nextLine());
		//계산
		total = kor+mat+eng;
		double avg = total/3;
		//출력
		System.out.println("이름: "+name2);
		System.out.println("국어: "+kor);
		System.out.println("수학: "+mat);
		System.out.println("영어: "+eng);
		System.out.println("총점: "+total);
		System.out.printf("평균: %.2f",avg);

	}

}
