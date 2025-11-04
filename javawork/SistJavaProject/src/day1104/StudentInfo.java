package day1104;

public class StudentInfo {

	private String name;
	private int java;
	private int html;
	
	public static void SchoolName() {
		System.out.println("학교명 : 청담고등학교");
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
		String pungga=" ";
		
		if (getAverage()>=90)
			pungga="장학생";
		else if (getAverage()>=80)
			pungga="합격";
		else
			pungga="불합격";
		
		return pungga;
	}

	

}
