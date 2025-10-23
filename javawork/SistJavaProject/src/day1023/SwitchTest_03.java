package day1023;

public class SwitchTest_03 {

	public static void main(String[] args) {
		// 학점을 switch
		
		int score=75;
		char grade;
		
		switch(score/10)
		{
		case 10: case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
			default:
				grade='F';
		}
		System.out.println(score+"==>"+grade);

	}

}
