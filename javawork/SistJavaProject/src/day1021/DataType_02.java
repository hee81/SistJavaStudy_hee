package day1021;

public class DataType_02 {

	public static void main(String[] args) {
		// 강제 형변환(cast연산자)
		
		int x=7;
		int y=4;
		
		System.out.println(x/y); //1 : 정수형끼리의 계산결과를 무조건 정수int
		System.out.println((double)x/y); //계산시 x를 double로 변환해서 계산 : 결과는 double
		System.out.println(x/(double)y); //수식 중 한개라도 double이 있으면 결과는 double
		
		double d=100.0;
		int i=100;
		int result=(int)d+i; //디모션 발생, 왼쪽에 맞춰줘야함.
		double result2=d+i; // 묵시적 형변환
		// double result2=(double)d+i; 넣어도 되지만 안넣는게 정석!
		
		System.out.println("result="+result);
		System.out.println("result2="+result2);

	}

}
