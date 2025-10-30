package day1030;

public class Ex9Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("두 수의 합: "+add(10, 20));
		System.out.println("제곱: "+square(4.6));
		System.out.println("정수+실수의 합: "+sum(1, 1.5));
		System.out.println("실수+정수의 합: "+sum(1.5, 1));

	}
	
	static int add(int num1, int num2) {
		int result=num1+num2;
		return result;
	}
	
	static double square(double num)
	{
		return num*num;
	}
	
	//이름이 sum인 메서드_1개의 정수와 1개의 실수를 입력받아 더해서 리컨해주는 함수
	static double sum(int num1, double num2) { 
		//각각의 속성?이여서 같은 변수를 사용해도 괜찮음
//		double result=num1+num2;
//		return result;
		return num1+num2;
		
	}
	
	static double sum(double num1, int num2)
	{
		return num1+num2;
	}

}
