package day1024;

import java.util.Scanner;

public class GuguScan_05 {

	public static void main(String[] args) {
		// 원하는 단을 입력해서 해당 단만 출력해보자
		/*
		 단을 입력하시오: 5
		 
		 [5단]
		 5X1=5
		 5X2=10
		 .
		 .
		 5X9=45
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int num;
		
//		System.out.print("단을 입력하시오: ");
//		num=sc.nextInt();
//		System.out.println("["+num+"단]");
//		
//		for (int j=1;j<=9;j++)
//		{
//			System.out.println(num+"X"+j+"="+(num*j));
//		}
//		System.out.println();
		
		//while(true)
		
		while(true)
		{
			System.out.print("원하는 단 입력_0이면 종료 :");
			num=sc.nextInt();
			
			//종료
			if(num==0)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
							 
			//continue
			if(num<2||num>9)
			{
				System.out.println("2~9사이의 숫자만 넣어주세요");
				continue;
			}
			
			System.out.println("["+num+"단]");
			
			for (int j=1;j<=9;j++)
			{
				System.out.println(num+"X"+j+"="+(num*j));
			}
			System.out.println();
		}
	
	}

}
