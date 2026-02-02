package spring.ex3.di;

public class SawonData {
	private String sawonName;
	private int pay;
	private String ipsaday;
	
	//사원명 생성자주입
	public SawonData(String name) {
		// TODO Auto-generated constructor stub
		this.sawonName=name;
	}
	
	//pay,ipsaday 세터주입
	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getIpsaday() {
		return ipsaday;
	}

	public void setIpsaday(String ipsaday) {
		this.ipsaday = ipsaday;
	}

}
