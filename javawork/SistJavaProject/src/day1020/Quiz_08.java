package day1020;

public class Quiz_08 {

	public static void main(String[] args) {
		// args라는 매개변수 이용할 것!!
		// 변수는 마음대로 하되 이름에 걸맞게 만들것
		
		/*
		 오늘의 퀴즈
		 ============
		 수량: 2개
		 가격: 1500000원
		 총금액: 3000000원*/
		
		//1.변수선언
		int amount = Integer.parseInt(args[0]);
		int price = Integer.parseInt(args[1]);
		//2.계산
		int sum =(amount * price);
		//3.출력
		System.out.println("오늘의 퀴즈");
		System.out.println("============");
		System.out.println("수량: "+amount+"개");
		System.out.println("가격: "+price+"원");
		System.out.println("총금액: "+sum+"원");

	}

}
