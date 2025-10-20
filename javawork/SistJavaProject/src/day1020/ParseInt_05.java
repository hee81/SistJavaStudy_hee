package day1020;

public class ParseInt_05 {

	public static void main(String[] args) {
		String su1="10";
		String su2="4";
		
		System.out.println("두수의 합은: "+(su1+su2));
		
		//정수타입int num1, num2로 형변환 후 두수를 더해보기
		int num1 = Integer.parseInt(su1);
		int num2 = Integer.parseInt(su2);
		int sum = num1 + num2;
		
		System.out.println("형변환 후 두수 더하기: "+(num1+num2));
		System.out.println("형변환 후 두수 빼기: "+(num1-num2));
		System.out.println("형변환 후 두수 곱하기: "+(num1*num2));
		System.out.println("형변환 후 두수 나누기: "+(num1/num2));
		System.out.println("형변환 후 두수 나누어 나머지값: "+(num1%num2));
		System.out.println("두수의 합은 "+sum+"입니다.");

	}

}
