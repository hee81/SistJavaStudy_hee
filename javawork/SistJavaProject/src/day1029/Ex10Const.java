package day1029;

class StuInfo
{
	private String stuName;
	private String major; //전공
	private int grade; //학년
	
	//명시적생성자
	public StuInfo(String sName,String mj,int grade) {
		stuName=sName;
		major=mj;
		this.grade=grade;
	}
	//getter매서드
	public String getStuName()
	{
		return stuName;
	}
	public String getMajor()
	{
		return major;
	}
	public int getGrade()
	{
		return grade;
	}
}

public class Ex10Const {

	public static void main(String[] args) {
		//생성과 동시에 초기화 해주었으므로
		//setter 메서드의 역할까지 해준 것
		StuInfo stu1=new StuInfo("홍길동", "유아교육과", 0);
		
		String sName=stu1.getStuName();
		String sMajor=stu1.getMajor();
		int sGrade=stu1.getGrade();
		
		System.out.println(sName+"님의 전공은 "+sMajor+"이며 학년은 "+sGrade+"입니다");

	}

}
