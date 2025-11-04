package day1104_1;

import java.util.Scanner;

class StudentInfo{
	//맴버변수
	private static String schoolName;
	private String name;
	private int java;
	private int html;
	
	//setter(수정용), getter(출력용)
	public static String getSchoolName() {
		return schoolName;
	}
	public static void setSchoolName(String schoolName) {
		StudentInfo.schoolName = schoolName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	
	public int getTotal() {
		int tot=this.java+this.html;
		return tot;
	}
	
	public double getAverage() {
		double avg=getTotal()/2.0;
		return avg;
	}
	
	public String getPungga() {

		if(getAverage()>=90)
			return "장학생";
		else if(getAverage()>=80)
			return "합격";
		else
			return "불합격";

		
	}
	
	
	
	
}

public class StudentInfoMain {
	
	//출력
	public static void getStudentInfo(StudentInfo stuI){
		System.out.println(stuI.getName()+"\t"+stuI.getJava()+"\t"+stuI.getHtml()
		+"\t"+stuI.getTotal()+"\t"+stuI.getAverage()+"\t"+stuI.getPungga());
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		int inwon;
		StudentInfo [] stu;
		
		System.out.println("인원수를 입력하시오");
		inwon=Integer.parseInt(sc.nextLine());
		
		System.out.println("학교명");
		String schoolname=sc.nextLine();
		StudentInfo.setSchoolName(schoolname); //입력한 학교명으로 초기값
		
		stu=new StudentInfo[inwon];
		for(int i=0;i<inwon;i++)
		{
			System.out.println(i+"번 학생 이름");
			String name=sc.nextLine();
			System.out.println("자바점수와 HTML 점수입력");
			int java=Integer.parseInt(sc.nextLine());
			int html=Integer.parseInt(sc.nextLine());
			
			//i번째 StudentInfo 생성하기
			stu[i]=new StudentInfo();
			
			//setter매서드에 입력한 값으로 초기화
			stu[i].setName(name);
			stu[i].setJava(java);
			stu[i].setHtml(html);
			
		}
		
		System.out.println("**결과 출력**");
		
		System.out.println("학교명: "+StudentInfo.getSchoolName());

		System.out.println("학생명\tJava\tHTML\t총점\t평균\t평가");
		
		System.out.println("----------------------------------------------");
		
		//배열
		for(StudentInfo s:stu)
		{
			getStudentInfo(s);
		}
		
		

		
		

	}

}
