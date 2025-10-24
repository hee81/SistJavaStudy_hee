package day1024;

import java.util.Scanner;

public class WhileQuiz_06 {

	public static void main(String[] args) {
		// 점수를 입력하다가 Q or q를 입력하면 while문을 빠져나온 후
		// 총갯수 총점 평균 구해서 출력하시오
		
		Scanner sc=new Scanner(System.in);
		String score;
		int cnt=0,tot=0;
		double avg=0;
		
		while(true)
		{
			System.out.println("점수를 입력하시오");
			score=sc.nextLine();
			
			//break
//			if(score.charAt(0)=='Q'|| score.charAt(0)=='q')
			if(score.equalsIgnoreCase("Q"))
//			if (score.equals("Q")||score.equals("q"))
				break;

			cnt++;
			tot+=Integer.parseInt(score); //정수로 변환 후 합계 변수에 누적하기
					
		}
		
		//평균은 총점을 갯수로 한번만 나누면 되므로 반복문 밖에서 계산한다.
		avg=(double)(tot/cnt); //둘 다 정수형이므로 정확히 실수로 나오게 하려면 double 사
		
		System.out.println("총갯수: "+cnt);
		System.out.println("총점: "+tot);
		System.out.printf("평균: %.1f",avg);

	}

}
