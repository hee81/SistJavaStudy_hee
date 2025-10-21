package day1020;

public class test_00 {

	public static void main(String[] args) {
		// 1 println
		// Apple Banana Orange 를 세줄로 출력해 보세요
		System.out.println("Apple");
		System.out.println("Banana");
		System.out.println("Orange");
		
		//2 매개변수 test
		//매개변수 이용해서
		//나의 이름은 홍길동 입니다
		//나의 나이는 23세 입니다
		System.out.println("나의 이름은: "+args[0]);
		System.out.println("나의 나이는: "+args[1]);

		//3 escape 문자
		// 출력을 'Apple'
		// 출력을  c:\
		// 출력을 "blue","yellow","pink" 이렇게 출력해 보세요
		System.out.println("\'Apple\'");
		System.out.println("c:\\");
		System.out.println("\"blue\",\"yellow\",\"pink\"");
		
		//4 Var(변수) Test
		//정수 변수 선언
		int num1 = 10;
		int num2 = 100;
		int sum = num1+num2;
		System.out.println(num1+"+"+num2+"="+sum);
		//문자 변수 선언
		String su1 = "10";
		String su2 = "100";
		System.out.println(su1+"+"+su2+"="+(su1+su2));
		//문자 정수 변환
		int s1 = Integer.parseInt(su1);
		int s2 = Integer.parseInt(su2);
		System.out.println(s1+"+"+s2+"="+(s1+s2));
		
		//5 ParselInt(파라미터) 문자열->정수
		System.out.println(s2/s1);
		System.out.println("나머지값"+(s2%s1));
		
		//6 ArgsVar 매개변수활용
		/* 매개변수를 이용하여 다음과 같이 출력해보자
		 학생명: *** 
		 자바점수: **점
		 오라클점수: **점
		 두 과목의 합계는 **점 입니다.*/
		
			//변수선언
		String name = args[2];
		int java = Integer.parseInt(args[3]);
		int oracle = Integer.parseInt(args[4]);
		int sum2 = (java+oracle);
			//출력
		System.out.println("학생명: "+name);
		System.out.println("자바점수: "+java+"점");
		System.out.println("오라클점수: "+oracle+"점");
		System.out.println("두 과목의 합계는 "+sum2+"점 입니다.\n");
		
		//7 printf
		/*
		 다음과 같이 출력(printf)를 사용하시오
		 
		 안녕하세요 제이름은 *** 입니다
		 저는 **세 입니다*/
		
		String name2 = "홍길동";
		int age2 = 25;
		
		System.out.printf("안녕하세요 제 이름은 %s입니다. \n저는 %d세 입니다.", name2, age2);
		
		
		
	}

}
