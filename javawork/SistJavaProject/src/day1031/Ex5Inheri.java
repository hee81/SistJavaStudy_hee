package day1031;

//super
class School{
	
	private String schoolAddr;
	private int countStu; //학생수
	private int countTeacher;//교사수
	public static final String SCHOOLNAME="쌍용고등학교";
	
	//디폴트생성자(생성만)(setter만들어서 초기화해야함)
	public School() {
		schoolAddr="강남구"; //null 안나오게 하려고
		countStu=200;
		countTeacher=15;
	}
	
	//명시적생성자(생성과 동시에 초기화)(오버로딩가능 but 인자는 다르게!)
	public School(String addr, int stu, int teacher) {
		this.schoolAddr=addr;
		this.countStu=stu;
		this.countTeacher=teacher;
	}
	
	//setter,getter(맴버 1개만 수정 or 출력할 때 편리)
	public String getSchoolAddr() {
		return schoolAddr;
	}
	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}
	public int getCountStu() {
		return countStu;
	}
	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}
	public int getCountTeacher() {
		return countTeacher;
	}
	public void setCountTeacher(int countTeacher) {
		this.countTeacher = countTeacher;
	}
	public static String getSchoolname() {
		return SCHOOLNAME;
	}
	
	//메서드
	public void getWriteDate() {
		System.out.println("학교주소: "+this.schoolAddr);
		System.out.println("학생수: "+this.countStu+",   교사수: "+this.countTeacher);
	}
	
}

//sub_School을 상속받는다.
class Student extends School{
	private String stuName; //학생명
	private int score; //점수
	
	//디폴트생성자_초기값은 마음대로...
	public Student() {
		super();
		stuName="홍길동";
		score=80;
	}

	//명시적생성자_Student의 맴버 stuName, score 추가한다
	public Student(String addr, int stu, int teacher, String stuN, int score) {
		super(addr, stu, teacher);
		this.stuName=stuN;
		this.score=score;
	}

	//setter,getter_모두 추가한다
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//부모의 getwirteDate를 오버라이딩해서 학생명과 점수를 추가한다
	//맨위에 학교명 넣어준다
	@Override
	public void getWriteDate() {
		// TODO Auto-generated method stub
		System.out.println("학교명: "+School.SCHOOLNAME);
//		System.out.println("학교명: "+SCHOOLNAME); //생략가능
		super.getWriteDate();
		System.out.println("학생명: "+this.stuName);
		System.out.println("점수: "+this.score);
		
	}

}

public class Ex5Inheri {
	public static void main(String[] args) {
		//1.디폴트 생성자로 생성 후 메서드 호출
		Student t1=new Student();
		t1.getWriteDate();
		
		System.out.println("============");
		//2.명시적 생성자로 생성 후 메서드 호출
		Student t2=new Student("서초구", 300, 20, "김영희", 50);
		t2.getWriteDate();
		
		System.out.println("============");
		//3.1번째의 학생명과 점수만 변경 후 다시 출력해보기
		//생성을 다시하면 또 하나의 주소값이 생기므로 생성하지 않고 참조변수를 이용하여 변경
		t1.setStuName("이철수");
		t1.setScore(70);
		t1.getWriteDate();
		
	}
	

}
