package sts.mvc.json;

public class FoodDto {
	private String foodname;
	private String foodphoto;
	
	//생성자
	public FoodDto(String name,String photo) {
		this.foodname=name;
		this.foodphoto=photo;
	}
	
	//메서드 set,get
	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodphoto() {
		return foodphoto;
	}

	public void setFoodphoto(String foodphoto) {
		this.foodphoto = foodphoto;
	}
	
}
