package day1031;

//super
public class Ex2Emp {
	
	String empName;
	int salery;
	
//	public Ex2Emp() {
//		// TODO Auto-generated constructor stub
//	}

	//생성자
	public Ex2Emp(String name, int sal) {
		this.empName=name;
		this.salery=sal;
	}
	
	//출력메서드
	public String getEmp() {
		String s=empName+","+salery;
		return s; 
	}
	
//	public String getEmp();  //추상메서드? 나중에 배움
	
	
}
