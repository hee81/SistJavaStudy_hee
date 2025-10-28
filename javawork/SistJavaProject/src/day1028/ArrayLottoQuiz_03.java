package day1028;

import java.util.Scanner;

public class ArrayLottoQuiz_03 {

	public static void main(String[] args) {
		/*
		 몇 장을 구입할지 입력 후 로또를 출력할것!!-중복체크, 오름차순
		 몇 장 구입을 원하세요?
		 2
		 1회: 3 10 17 39 40 45
		 2회: 2 24 31 36 41 44
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int [] lotto=new int[6];
		int num;
		
		System.out.println("몇 장 구입을 원하세요?");
		num=sc.nextInt();
		
		if(num<1)
		{
			System.out.println("구매하려는 갯수보다 작네요_프로그램 종료");
			return; //메인메서드 종료
		}
		
		//num만큼 로또갯수 반복
		for(int b=0;b<num;b++)
		{
			System.out.printf("%d회: ",b+1);
			
			//임의의 수를 로또변수에 발생시켜서 넣어준다
			for(int i=0;i<lotto.length;i++)
			{
				lotto[i]=(int)(Math.random()*45+1);
				//중복처리
				for(int j=0;j<i;j++)
				{
					if(lotto[i]==lotto[j])
					{
						i--; //같은번지에 다른 값을 구하기 위해서, i수가 잘못되면 그 값을 빼고 반복시킴
						break; //i++로 이동
					}
				}
			}
			
			//오름차순 정렬
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
				System.out.printf("%5d", lotto[i]);

			}
			System.out.println();

		}
		

		

	}

}
