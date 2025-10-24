package day1024;

public class RandomTest_07 {

	public static void main(String[] args) {
		/*
		 자바에서 난수를 구하는 방법 2가지
		 1.Math.random()메서드 활용(강사님선호)
		 2.		 
		 */ 

		System.out.println("10개의 난수발생");
		for(int i=1;i<=10;i++)
		{
			double n=Math.random(); //0.0~1.0미만 임의의 수 발생
			System.out.println(n);
		}
		 System.out.println("==================================");
		 
		 System.out.println("0~9까지의 난수발생");
		 for(int i=1;i<=10;i++)
		 {
			 int n=(int)(Math.random()*10); //*10해서 0~9까지만 출력가능
			 System.out.println(n);
		 }
		 
		 System.out.println("==================================");
		 System.out.println("0~99까지의 난수발생");
		 for(int i=1;i<=99;i++)
		 {
			 int n= (int)(Math.random()*100);
			 System.out.println(n);
		 }
		 
		 System.out.println("==================================");
		 System.out.println("1~10까지의 난수발생");
		 for(int i=1;i<=10;i++)
		 {
			 int n=(int)(Math.random()*10+1); //*10+1해서 1~10까지만 출력가능
			 System.out.println(n);
		 }
		 
		 System.out.println("==================================");
		 System.out.println("1~100까지의 난수발생");
		 for(int i=1;i<=99;i++)
		 {
			 int n= (int)(Math.random()*100+1);
			 System.out.println(n);
		 }
		 
		 System.out.println("==================================");
		 System.out.println("1~45까지의 난수발생");
		 for(int i=1;i<=99;i++)
		 {
			 int n= (int)(Math.random()*45+1);
			 System.out.println(n);
		 }
		 
		 


		

	}

}
