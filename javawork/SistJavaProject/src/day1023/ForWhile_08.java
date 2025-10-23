package day1023;

public class ForWhile_08 {

	public static void main(String[] args) {
		// 조건에 안맞으면 한번도 반복안함
		for(int i=5;i<=1;i++)
		{
			System.out.println(i);
		}
		
		//for문밖에서 i값을 출력하고 싶을 때
		for(int i=10;i<=50;i+=5)
			System.out.println(i);
		
		int i;
		for(i=10;i<=50;i+=5)
			System.out.println(i);
		System.out.println("\n빠져나온후의 i값: "+i); //오류, for문 안에서만 i값이 유효함
		
		//밖으로 초기값 지정하면 for문에서 생략가능(;주의)
		int a=10;
		for(;a<=50;a+=5)
			System.out.println(a);
		
		//1~10까지 중에서 짝수만 출력하기
		for(int n=1;n<=10;n++)
		{
			if(n%2==0)
				System.out.printf("%4d",n);
		}
		
		//1~10 뒤에 Hello붙혀서 출력
		for(int m=1;m<=10;m++)
		{
			System.out.println(m+"Hello");
		}
		System.out.println("for문을 빠져냐와 종료!!!");

	}

}
