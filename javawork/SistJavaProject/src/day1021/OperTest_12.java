package day1021;

public class OperTest_12 {

	public static void main(String[] args) {
		// 비교(관계)연산자: >,<,>=,<=,=<,!=
		// 논리연산자: &&(and), ||(or), !(not)
		
		int a=5,b=3,c=5;
		//결과값이 ture나 false로 나타남
		
		System.out.println(a>b); //t
		System.out.println(a==b); //f
		System.out.println(!(a==b)); //t
		System.out.println(a!=b); //t
		System.out.println(a>b&&b>c); //f
		System.out.println(a>b||b>c); //t

	}

}
