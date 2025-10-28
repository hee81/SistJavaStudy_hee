package day1028;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.Scanner;

public class test_10_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
//		test6();
		test7();
//		test8();
//		test9();

	}
	
	public static void test1() {
		//1.순서바꾸기 연습
//		int a=10,b=20;
//		System.out.println("a="+a+", b="+b);
//		
//		int temp1=a;
//		a=b;
//		b=temp1;
//		System.out.println("a="+a+", b="+b);
		
		
		//2.배열순서(오름->내림으로 바꾸기)
//		int[] arrNums= {4,6,8};
//		for(int i=0;i<arrNums.length;i++)
//			System.out.print(arrNums[i]+" ");
//		
//		int temp2=arrNums[0];
//		arrNums[0]=arrNums[2];
//		arrNums[2]=temp2;
//		
//		for(int i=0;i<arrNums.length;i++)
//			System.out.print(arrNums[i]+" ");
		
		// 3.배열변수 순서바꾸기(원데이터 출력, 순서바꾸기, 바뀐 데이터 출력하시오)
		int [] arr3= {98,23,15,62,31,1,14};
		
		for (int i=0;i<arr3.length/2;i++)
		{
			int temp=arr3[i];
			arr3[i]=arr3[arr3.length-1-i];
			arr3[arr3.length-1-i]=temp;
		}
		
		for(int i=0;i<arr3.length;i++)
		{
			System.out.println(arr3[i]);
		}
		
		
		// 4.오름차순 정렬로직(선택정렬-비교하는 데이터를 앞으로 보내는 정렬!)
		
//		int[] arr4= {1,41,26,83,15,37};
//		
//		for(int i=0;i<arr4.length-1;i++)
//		{
//			for(int j=i+1;j<arr4.length;j++)
//			{
//				if(arr4[i]==arr4[j])
//				{
//					int temp3=arr4[i];
//					arr4[i]=arr4[j];
//					arr4[j]=temp3;
//				}
//			}
//		}
//		
//		for(int i=0;i<arr4.length;i++)
//		{
//			System.out.println(arr4[i]);
//		}
		
		
		
	}
	public static void test2() {
		//로또6개를 출력(1~45까지의 랜덤수) 단 같은수가 나오면 다시 추첨진행.
		int [] lotto = new int[6];
		
		for(int i=0;i<lotto.length;i++)
		{
			lotto[i]=(int)(Math.random()*45+1); //1~45 사이의 랜덤수
			
			//중복값 제거
			for(int j=0;j<i;j++)
			{
				if(lotto[i]==lotto[j])
				{
					i--;
					break;
				}
			}

		}
		//오름차순
		for(int i=0;i<lotto.length-1;i++)
		{
			for(int j=i+1;j<lotto.length;j++)
			{
				if(lotto[i]>lotto[j])
				{
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}

			}
		}
		
		//출력
		for(int i=0;i<lotto.length;i++)
		{
			System.out.println(lotto[i]);
		}
		

		
	}
	public static void test3() {
		/*
		 몇 장을 구입할지 입력 후 로또를 출력할것!!-중복체크, 오름차순
		 몇 장 구입을 원하세요?
		 2
		 1회: 3 10 17 39 40 45
		 2회: 2 24 31 36 41 44
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int[] lotto=new int[6];
		int buysu;
		
		System.out.println("몇 장 구입을 원하세요?");
		buysu=sc.nextInt();
		
		for(int b=0;b<buysu;b++)
		{
			//출력 횟수 제한(6)
			System.out.printf("%d회: ",b+1);
			
			//랜덤수_중복없이
			for(int i=0;i<lotto.length;i++)
			{
				lotto[i]=(int)(Math.random()*45+1);
				for(int j=0;j<i;j++)
				{
					if(lotto[i]==lotto[j])
					{
						i--;
						break;
					}
				}
			}
			
			//오름차순
			for(int i=0;i<lotto.length-1;i++)
			{
				for(int j=i+1;j<lotto.length;j++)
				{
					if(lotto[i]>lotto[j])
					{
						int temp=lotto[i];
						lotto[i]=lotto[j];
						lotto[j]=lotto[i];
					}
				}
			}
			
			//출력
			for(int i=0;i<lotto.length;i++)
			{
				System.out.printf("%5d",lotto[i]);
			}
			System.out.println();
		}

		
		
		
		
		
		
	}
	public static void test4() {
		/*2차원배열 출력
		 10 20 30
		 40 50 60		
		 
		 위 배열 변경 후 출력!
		 10 100 30
		 200 50 300
		 */
		
		int [][] arr;
		arr=new int[2][3];
		arr[0][0]=10;
		arr[0][1]=20;
		arr[0][2]=30;
		arr[1][0]=40;
		arr[1][1]=50;
		arr[1][2]=60;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}

	}
	public static void test5() {
		// 2차원 배열도 배열선언과 동시에 초기값 주기를 더 많이 사용한다
//		int [][] arr =
	}
	public static void test6() {
		
	}
	public static void test7() {
		// 3행3열의 테이블안에 1~3까지의 랜덤수를 발생시켜서 빙고게임 진행
		// 8개의 빙고가 나오면 최고확률
		Scanner sc=new Scanner(System.in);
		
		int [][] puzzle = new int[3][3];
		
		while(true)
		{
			System.out.println("같은 숫자가 가로,세로,대각선에 나오면 빙고!");
			//랜덤수 출력
			for(int i=0;i<puzzle.length;i++)
			{
				for(int j=0;j<puzzle[i].length;j++)
				{
					puzzle[i][j]=(int)(Math.random()*3+1);
				}
			}
			//출력
			for(int i=0;i<puzzle.length;i++)
			{
				for(int j=0;j<puzzle[i].length;j++)
				{
					System.out.printf("%4d",puzzle[i][j]);
				}
				System.out.println();
			}
			
			//break문
			System.out.println("엔터를 누르면 다음 난수가 나온다 종료시:q");
			String ent=sc.nextLine();
			if(ent.equalsIgnoreCase("q"))
			{
				System.out.println("프로그램 종료");
				break;
			}

		}
		
		
		
	}
	public static void test8() {
		
	}
	public static void test9() {
		
	}	

}
