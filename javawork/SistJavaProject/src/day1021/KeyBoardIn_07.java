package day1021;

import java.util.Scanner;

public class KeyBoardIn_07 {

	public static void main(String[] args) {
		// Scanner 문자열이나 숫자를 모두 키보드로 입력받으려 할 때 생성해준다.
		
		Scanner sc=new Scanner(System.in);
		
		String name,city;
		int age;
		
		System.out.print("이름을 입력해보세요==>");
		name=sc.nextLine(); //한줄을 문자로 읽어온다(공백사용가능)
		System.out.println("내이름은 "+name+"입니다.");
		
		System.out.print("당신의 나이는?");
		//age=sc.nextInt();
		age=Integer.parseInt(sc.nextLine()); //String->int
		System.out.println("당신의 나이는 "+age+"입니다.");
		
		//숫자 입력 후 엔터를 누르면 그 엔터가 키보드버퍼로 저장되어 다음 문자열 읽을 때
		//먼저 읽어버리는 현상 발생
		//해결하려면 숫자를 문자처럼 변환해주면 가능...? 반대인듯
		System.out.print("당신이 사는 지역은?==>");
		city=sc.nextLine(); 
		System.out.println("저는 "+city+"지역에 삽니다");
	}

}
