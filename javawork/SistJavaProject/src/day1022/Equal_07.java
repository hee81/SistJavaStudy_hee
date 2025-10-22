package day1022;

import java.util.Scanner;

public class Equal_07 {

	public static void main(String[] args) {
		// 문자열비교는 관계연산자(==)로 하면 안됨
		// equals라는 매서드를 사용해서 비교한다(대소문자구분함)<->다른거 있음
		// 단어를 입력하면 해당 단어의 뜻을 출력한다.
		
		Scanner sc=new Scanner(System.in);
		
		String word;
		System.out.println("영어단어를 입력하시오");
		System.out.println("예: happy,rose,angel,phone");
		word=sc.nextLine();
		System.out.println("입력한 문자열:"+word);
		
		//문자열비교
		//(word=="happy")안됨!
		if(word.equals("happy")) //대소문자구분
			System.out.println("**행복하다**");
		else if(word.equalsIgnoreCase("Rose"))//대소문자 상관없다
			System.out.println("**장미**");
		else if(word.equalsIgnoreCase("angel"))
			System.out.println("**천사**");
		else if(word.equalsIgnoreCase("phone"))
			System.out.println("**핸드폰**");
		else
			System.out.println("단어 목록에 없는 단어입니다.");
	}

}
