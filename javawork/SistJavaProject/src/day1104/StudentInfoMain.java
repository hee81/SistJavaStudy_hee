package day1104;

import java.util.Scanner;

public class StudentInfoMain {

	public static void StudentMain(StudentInfo[] studentI) {
		
		System.out.println("**결과 출력**");
		
		StudentInfo.SchoolName();

		System.out.println("학생명\tJava\tHTML\t총점\t평균\t평가");
		
		System.out.println("----------------------------------------------");
		
		for(StudentInfo stuI:studentI)
		{
			System.out.println(stuI.getName()+"\t"+stuI.getJava()+"\t"+stuI.getHtml()
			+"\t"+stuI.getTotal()+"\t"+stuI.getAverage()+"\t"+stuI.getPungga());
		}
		

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int inwon;
		StudentInfo [] studentI;
		
		System.out.println("인원수를 입력하시오");
		inwon=Integer.parseInt(sc.nextLine());
		
		studentI=new StudentInfo[inwon];
		
		for(int i=0;i<inwon;i++)
		{
			studentI[i]=new StudentInfo(); //디폴트가 뭐였지?
			System.out.println("이름을 입력하시오");
			String name=sc.nextLine();
			System.out.println("자바점수를 입력하시오");
			int java=Integer.parseInt(sc.nextLine());
			System.out.println("html점수를 입력하시오");
			int html=Integer.parseInt(sc.nextLine());
			
			studentI[i].setName(name);
			studentI[i].setJava(java);
			studentI[i].setHtml(html);

		}
		
		
		StudentMain(studentI);
		
		

	}

}
