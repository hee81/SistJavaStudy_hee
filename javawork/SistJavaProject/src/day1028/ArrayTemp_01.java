package day1028;

import java.util.Arrays;

public class ArrayTemp_01 {

	public static void main(String[] args) {
		//1.순서바꾸기 연습
		int a=10,b=20;
		System.out.println("a="+a+", b="+b);
		
		int temp1=a;
		a=b;
		b=temp1;
		System.out.println("a="+a+", b="+b);
		
		System.out.println("------------");
		
		
		//2.배열순서
		int[] arrNums= {4,6,8};
		
		for(int an:arrNums)
			System.out.print(an+" ");
		
		System.out.println();
		System.out.println("0번과 2번을 교환 후 출력!");
		int temp2=arrNums[0];
		arrNums[0]=arrNums[2];
		arrNums[2]=temp2;
		
		for(int an:arrNums)
			System.out.print(an+" ");
		System.out.println();
		
		
		// 3.배열변수 순서바꾸기
		int[] arr= {5,7,65,43,46,88,95,21,11};
		
			//원데이터출력
		System.out.println("원데이터 출력");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		System.out.println("------------");

			//배열의 순서바꾸기로직
		for(int i=0;i<arr.length/2;i++)
		{
			int temp3=arr[i];
			arr[i]=arr[arr.length-1-i]; //10개일 때 0<->9변경 필요
			arr[arr.length-1-i]=temp3;
		}
		
			//출력
		System.out.println("데이터 거꾸로 출력");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		System.out.println("------------");
		
		//4.오름차순 정렬로직(가장 작은 숫자를 앞으로 보내자) **선택정렬:비교하는 데이터를 앞으로 보내는 정렬**
		//기준 데이타는 0번~끝에서 두번째
//		System.out.println("선택정렬-오름차순");
//		for(int i=0;i<arr.length-1;i++)
//		{
//			//비교하는 데이타는 기준 다음값부터 끝까지
//			for(int j=i+1;j<arr.length;j++)
//			{
//				if(arr[i]>arr[j]) //기준값이 비교값보다 클 때 순서를 변경하는게 오름차순!!
//				{
//					int temp4=arr[i];
//					arr[i]=arr[j];
//					arr[j]=temp4;
//				}
//			}
//		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}


		
	}

}
