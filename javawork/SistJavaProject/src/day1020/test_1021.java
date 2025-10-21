package day1020;

public class test_1021 {

	public static void main(String[] args) {
		// 매개변수로 츨력하기
		
		String name = args[0];
		int java = Integer.parseInt(args[1]);
		int oracle = Integer.parseInt(args[2]);
		int sum = java + oracle;
		
		System.out.println("학생명: "+name);
		System.out.println("자바점수: "+java+"점");
		System.out.println("오라클점수: "+oracle+"점");
		System.out.println(sum);
		
		String color = "노랑";
		int math = 77;
		
		System.out.printf("색은 \t%s이고\n수학점수는 %d이다\\\'\"",color,math);
		
	}

}
