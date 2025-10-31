package day1031;

public class Emp {

	private String name; /////초기화값 없음>
	private int pay;
	private int sudang;
	private static String empName; //회사명
	
	//setter(수정용-초기화용)
	//getter(조회용)
	//->명시적생성자 따로 작성해야함->아니면 어제처럼 default생성하면됨?
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getSudang() {
		return sudang;
	}
	public void setSudang(int sudang) {
		this.sudang = sudang;
	}
	public static String getEmpName() {
		return empName;
	}
	public static void setEmpName(String empName) {
		Emp.empName = empName;
	}
	
	//실수령액
	public int getNetPay() {
		int money=(int)((pay+sudang)*0.9); //왼쪽에 맞춰주면 됨!
		return money;
	}
	
	//

	
	
	
}
