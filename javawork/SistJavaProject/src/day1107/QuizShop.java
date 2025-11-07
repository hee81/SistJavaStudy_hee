package day1107;

public class QuizShop {
	
	private String sangpumName;
	private String color;
	private String madeCompany;
	private int su; //입고수량
	private int price; //입고가격
	
	//setter&getter
	public String getSangpumName() {
		return sangpumName;
	}
	public void setSagnpumName(String sangpumName) {
		this.sangpumName = sangpumName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMadeCompany() {
		return madeCompany;
	}
	public void setMadeCompany(String madeCompany) {
		this.madeCompany = madeCompany;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
