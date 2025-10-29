package day1029;

public class Ex9Test {
	
	private String stuName; //학생명
	private int grade; //학년
	static String schoolName; //학교명
	
	//수정용_set
	public void setStuName(String Name)
	{
		stuName=Name;
	}
	public void setGrade(int grade)
	{
		this.grade=grade;
	}
	
	//조회용_get
	public String getStuName()
	{
		return stuName;
	}
	public int getGrade()
	{
		return grade;
	}

	public static void main(String[] args) {
		/*
		 학교명: 쌍용고등학교
		 학생명: 김수현
		 학년: 2학년
		 */
		
		Ex9Test.schoolName="쌍용고등학교";

		Ex9Test sc9=new Ex9Test();
		sc9.setStuName("김수현");
		sc9.setGrade(2);
		
		String sName=sc9.getStuName();
		int sgrade=sc9.getGrade();
		
		System.out.println("학교명: "+schoolName);
		System.out.println("학생명: "+sName);
		System.out.println("학년: "+sgrade+"학년");

	}

}
