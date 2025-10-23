package day1023;

public class CharAt_05 {

	public static void main(String[] args) {
		// 주민번호 ******-*******
		
		String jumin="970801-1123456";
		char seventh=jumin.charAt(7);
		
		if(seventh=='1')
			System.out.println("남자입니다");
		else if(seventh=='2')
			System.out.println("여자입니다");
		else if(seventh=='3')
			System.out.println("2000년생 이후 남자입니다");
		else if(seventh=='4')
			System.out.println("2000년생 이후 여자입니다");
		else
			System.out.println("잘못 기입하였습니다(1~4까지만 조회 가능)");

	}

}
