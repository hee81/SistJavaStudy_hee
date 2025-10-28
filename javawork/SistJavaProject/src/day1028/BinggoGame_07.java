package day1028;

import java.util.Scanner;

public class BinggoGame_07 {

	public static void main(String[] args) {
		// 3행3열의 테이블안에 1~3까지의 랜덤수를 발생시켜서 빙고게임 진행
		// 8개의 빙고가 나오면 최고확률
		Scanner sc=new Scanner(System.in);
		
		int [][] puzzle= new int[3][3]; //3행3열
		int binggo;
//		int binggo=0; //바깥에 넣으면 초기화가 안됨 //누적됨
		
		//3행 3열 안에 1~3까지의 난수를 발생시키기
		while(true)
		{
			System.out.println("**같은 숫자가 가로,세로,대각선에 나오면 빙고!");
						
			//랜덤수
			for(int i=0;i<puzzle.length;i++) //행
			{
				for(int j=0;j<puzzle[i].length;j++) //열
				{
					puzzle[i][j]=(int)(Math.random()*3)+1; //1~3사이의 랜덤수 발생
				}
			}
			
			//출력
			for(int i=0;i<puzzle.length;i++) //행
			{
				for(int j=0;j<puzzle[i].length;j++) //열
				{
					System.out.printf("%4d",puzzle[i][j]);
				}
				System.out.println();
			}
			
			//빙고 초기화!
			binggo=0;
			
			//**빙고조건** 
			//가로선(가로:0,0 0,1 0,2====>[i][0~2])
			for(int i=0;i<3;i++)
			{
				if(puzzle[i][0]==puzzle[i][1] && puzzle[i][1]==puzzle[i][2])
					binggo++;
			}
			//세로선(세로:0,0 1,0 2,0====>[0~2][i]
			for(int i=0;i<3;i++)
			{
				if(puzzle[0][i]==puzzle[1][i] && puzzle[1][i]==puzzle[2][i])
					binggo++;
			}
			//대각선(\ 0,0 1,1 2,2 )
			if(puzzle[0][0]==puzzle[1][1] && puzzle[1][1]==puzzle[2][2])
				binggo++;
			//대각선(/ 0,2 1,1 2,0 )
			if(puzzle[0][2]==puzzle[1][1] && puzzle[1][1]==puzzle[2][0])
				binggo++;
			//**빙고출력**
			System.out.println("빙고: "+binggo+"개");
			
			
			//종료조건(꼭 위에 둘 필요없음!)
			System.out.println("엔터를 누르면 다음 난수가 나온다 종료시:q");
			String ent=sc.nextLine();
			if(ent.equalsIgnoreCase("q"))
			{
				System.out.println("게임을 종료합니다");
				break;
			}
			
			
		}
		
		

	}

}
