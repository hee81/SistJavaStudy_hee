package day1031;

//sub
public class Ex2Manager extends Ex2Emp{
	
	String dept; //부서

	//디폴트생성자//오류남! why? 부모class에 없어서..
//	public Ex2Manager() {
//		// TODO Auto-generated constructor stub
//	}
	
	
	
	public Ex2Manager(String name, int sal, String dept) {
		super(name, sal); //부모생성자 호출
		this.dept=dept; //초기화
	}
	
	@Override //getEmp() 입력하면됨
	public String getEmp() {
		// TODO Auto-generated method stub
		return super.getEmp()+","+dept;  //출력은 부모-자식 순서 상관없음
	}
	
	
	

}
