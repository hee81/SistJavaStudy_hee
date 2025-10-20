package day1020;

public class ArgsVar_06 {

	public static void main(String[] a) {
		/* 매개변수를 이용하여 다음과 같이 출력해보자
		 학생명: *** 
		 자바점수: **점
		 오라클점수: **점
		 두 과목의 합계는 **점 입니다.*/

		//변수선언(가장 처음에 해야한 것!)
		String stuName=a[0];
		//String java=a[1];
		int java = Integer.parseInt(a[1]);
		//String oracle=a[2];
		int oracle = Integer.parseInt(a[2]);
		
		//출력
		System.out.println("학생명: "+stuName);
		System.out.println("자바점수: "+java);
		System.out.println("오라클점수: "+oracle);
		System.out.println("두과목의 합계는 "+(java+oracle)+"점 입니다.");
		
		//더해서 숫자합계가 될 수 있도록 수정해보기!
		/* int in1 = Integer.parseInt(java);
		int in2 = Integer.parseInt(oracle);
		int sum = in1 + in2;
		System.out.println("두과목의 합계는 "+sum+"점 입니다.");
		*/
		
		
		
	}

}
