package day1021;

public class ArgsQuiz_06 {

	public static void main(String[] args) {
		// 변수는 알아서..국어,영어,수학 점수를 매개변수(args)로 입력 후
		// 총점과 평균을 구하시오.
		// 단 평균은 소수점 2자리로 구할 것/
		
		/*
		 이름: 홍길동
		 국어점수: **점
		 수학점수: **점
		 영어점수: **점
		 총점: **점
		 평균: **,**점
		 */
		
		//변수
		String name=args[0];
		//System.out.println(args[1]+args[2]+args[3]); 출력:607080
		int korScore=Integer.parseInt(args[1]);
		int mathScore=Integer.parseInt(args[2]);
		int engScore=Integer.parseInt(args[3]);
		//계산
		int total=korScore+mathScore+engScore;
		double average=(total/3.0);
		//결과
		System.out.println("이름: "+name);
		System.out.println("국어점수: "+korScore+"점");
		System.out.println("수학점수: "+mathScore+"점");
		System.out.println("영어점수: "+engScore+"점");
		System.out.println("총점: "+total+"점");
		System.out.printf("평균: %.2f",average);

	}

}
