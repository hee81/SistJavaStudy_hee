package day1023;

public class ForWhile_07 {

	public static void main(String[] args) {
		// 1~10까지 반복출력_For문
		for(int i=1;i<11;i++) 
		{
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// 1~10까지 반복출력_While문
		int n=1; 
		while(n<=10)
		{
			System.out.printf("%4d",n); //1~10
			n++;
			
//			System.out.printf("%4d",n++);
		}	
		
//		int n=0; //i값은 계속 사용가능...!?왜
//		while(n<10)
//		{
//			n++;
//			System.out.print(n); //1~10
//		}
		
		System.out.println();
		
		//for문으로 10~1
		for(int i=10;i>=1;i--)
		{
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		//while(true)..반드시 break문으로 빠져나와야 한다
		int a=1;
		while (true)
		{
			System.out.printf("%4d",a++); //무한루프
			
			if(a>10)
				break;
		}
		
		System.out.println();
		
		//for문으로 1 4 7 10 출력
		for(int i=1;i<=10;i+=3)
		{
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		//5 4 3 2 1_for
		for(int i=5;i>=1;i--)
		{
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		//5 4 3 2 1_for
		int s=5;
		while(s>=1)
		{
			System.out.printf("%4d",s--);
		}
		
		System.out.println();
		
		//Hello를 가로방향으로 5번 출력하시오_for
		for(int b=1;b<=5;b++)
		{
			System.out.print("Hello  ");
		}
		
		
		
		
		
		
		
		

	}

}
