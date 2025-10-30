package day1030;

class StuScore{
	
	private String stuName;
	private int java;
	private int oracle;
//	int sum;
//	int avg;
	
	static final String TITLE="자바오라클 중간시험";

	//각각의 setter,getter
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	
	//합계메서드로 구해보자
	public int getStuSum() {
		int t=this.java+this.oracle;
		return t;
	}
	//평균메서드
	public double getStuAvg() {
		double a=this.getStuSum()/2.0;
		return a;
	}

	
//	public int getStuSum() {
//		this.sum=java+oracle;
//		return sum;
//	}
//	public double getStuAvg() {
//		this.avg=sum/2;
//		return avg;
//	}

}


public class Ex3Object {

	public static void main(String[] args) {
		/*
		 자바오라클 중간시험
		 이름: 박호준
		 자바점수: 87
		 오라클점수: 99
		 합계: 186
		 평균: 93.0
		 */
		
		System.out.println(StuScore.TITLE);
		
		StuScore test=new StuScore();
		test.setStuName("박호준");
		test.setJava(87);
		test.setOracle(99);
		
		System.out.println("이름: "+test.getStuName());
		System.out.println("자바점수:"+test.getJava());
		System.out.println("오라클점수: "+test.getOracle());
		
		int tot=test.getStuSum();
		double avg=test.getStuAvg();
		System.out.println("합계: "+tot);
		System.out.printf("평균: %.1f",avg);
		
//		System.out.println("합계: "+test.getStuSum());
//		System.out.println("평균: "+test.getStuAvg());

	}

}
