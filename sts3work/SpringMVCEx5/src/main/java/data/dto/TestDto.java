package data.dto;

public class TestDto {
	
	private String sangname; //form-name 이랑 변수 같아야한다!!!
	private int price;
	
	public String getSangname() {
		return sangname;
	}
	public void setSangname(String sangname) {
		this.sangname = sangname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
