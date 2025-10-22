package day1022;

import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		/*
		 오늘 입고된 상품명은?
		 갤럭시 폴드
		 입고된 수량은?
		 5
		 단가는?
		 1200000
		 
		 갤럭시폴드 5개는 총 6000000원 입니다
		 5개 이상은 10프로 DC됨
		 할인된 총금액: 5400000원
		 */
		
		//import
		Scanner sc=new Scanner(System.in);
		//변수
		String pName;
		int quan, danga; //quan:수량, danga:단가
		//입력
		System.out.println("오늘 입고된 상품명은?");
		pName=sc.nextLine();
		System.out.println("입고된 수량은?");
		quan=sc.nextInt();
		System.out.println("단가는?");
		danga=sc.nextInt();
		
		//계산
		int sum=quan*danga;
		double disC=sum*0.1;
				
		//출력
		System.out.println(pName+" "+quan+"개는 총 "+sum+"원 입니다");
		System.out.println("5개 이상은 10프로 DC됨");
		
		//조건
		if (quan>=5)
			System.out.println("할인된 총금액: "+(int)(sum-disC)+"원");
		
		//t
//		{ 
//			int dc=sum*9/10;
//			System.out.println("5개 이상은 10프로 DC됨");
//			System.out.println("할인된 총금액: "+dc+"원");
//		}
		
		else
			System.out.println("총금액: "+sum+"원 입니다.");
		
		
		
		
	}

}
