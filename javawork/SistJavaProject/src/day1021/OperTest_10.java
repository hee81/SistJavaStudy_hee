package day1021;

public class OperTest_10 {

	public static void main(String[] args) {
		// 증감연산자 ++ --
		
		int a,b;
		a=b=5;
		
		// 단항일경우 증감값을 앞에 붙히나 뒤에 붙히나 같음.
		++a; //원래 a값에서 1증가
		b++; //b=b+1
		
		System.out.println("a="+a+",b="+b);
		
		//수식에서 사용할 때는 전치.후치 결과값이 다름.
		int m, n;
		n=m=0;
		a=b=5;
		
		m=a++; //후치일 경우 먼저 대입 후 증가 //주로 사용
		System.out.println("m="+m+",a"+a); //m=5,a6
		n=++b; //전치일 경우 먼저 증가 후 대입
		System.out.println("n="+n+",b"+b); //n=6,b6

	}

}
