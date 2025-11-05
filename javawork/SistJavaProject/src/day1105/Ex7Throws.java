package day1105;

import java.util.Scanner;

//throws:호출한 영역으로 예외처리를 던짐
//throw:강제로 예외를 발생시킬 때


public class Ex7Throws {
	
	//메서드
	public static void scoreinput() throws Exception{
		Scanner sc=new Scanner(System.in);
		int score=0;
		
		//점수가 1~100점 사이가 아니면 익셉션 발생
		System.out.println("점수를 입력하세요");
		score=sc.nextInt();
		
		if(score<1 || score>100)
		{
			throw new Exception("점수가 잘못 입력되었어요"); //throws Exception때문에 throw 입력가능
		}else
		{
			System.out.println("나의 점수는 "+score+"점 입니다");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			scoreinput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("오류메세지: "+e.getMessage());
		}
		System.out.println("**정상종료**");
	}

}
