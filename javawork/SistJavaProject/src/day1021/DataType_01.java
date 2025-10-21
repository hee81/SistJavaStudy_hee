package day1021;

public class DataType_01 {

	public static void main(String[] args) {
		// 기본적인 자료형..
		// 1.논리형
		boolean flag=false; //true, false
		
		// 2.문자형
		// 반드시 하나의 문자 2바이트, ' '로 표현
		// 기본적으로 정수형,아스키코드로 변경가능
		char ch='가';
		
		// 3. 정수형
		byte a=-127; //1바이트 -128~127까지 가능 
		byte b=(byte)-129; // 더 작은 자료형으로의 형변환(디모션)값손실
		short c=3000;
		int d=23456700;
		long e=105231L; //L을 붙여야 long, 아니면 기본형인 int로 봄.
		
		// 4. 실수형
		double dou=142687.213876; //기본
		float f=3.25224f; //f을 안붙히면 long으로 읽음. 
		
		// 같은 크기일경우 실수형이 정수형보다 큰타입으로 처리된다.
		
		//출력
		System.out.println("flag="+flag);
		System.out.println("ch="+ch);
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("e="+e);
		System.out.println("dou="+dou);
		System.out.println("f="+f);
		
		//소수점자리수까지 표기하고 싶을땐 printf 사용
		//전체자리수 10자리 소수점2자리
		System.out.printf("dou=%10.2f\n",dou);
		//dou소수점1자리
		System.out.printf("dou=%.1f",dou);  
		

	}

}
