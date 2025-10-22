package day1022;

public class IfTest_02 {

	public static void main(String[] args) {
		// 조건5(A,B,C,D,F)
		// If~else if~else
		int score=91;
		char grade;

		//이항연산자
		if (score>=90)
			grade='A';
		else if (score>=80)
			grade='B';
		else if (score>=70)
			grade='C';
		else if (score>=60)
			grade='D';
		else
			grade='F';

		System.out.println("if_학점은 " + grade + "입니다.");

				
		//삼항연산자 이용하여 학점구하기
		//조건?true?false
		grade=score>=90?'A':
			  score>=80?'B':
			  score>=70?'C':
			  score>=60?'D':'F';
			  
		System.out.println("삼항_학점은 " + grade + "입니다.");






	}

}
