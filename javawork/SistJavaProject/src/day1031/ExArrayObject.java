package day1031;

/*
 [메뉴1]
 메뉴명: 피자
 가격: 25000
----------------- 
 [메뉴2]
 메뉴명: 알리오올리오
 가격: 15000
----------------- 
 [메뉴3]
 메뉴명: 아보카도샌드위치
 가격: 17000
-----------------
 */
//클래스따로주는 이유=맴버변수를 만들고 다른 class에서 부르는게 보편적.
class Food{
	private String menu;
	private int price;
	static int menu_no;
	
	//명시적생성자(set)
	public void setFood(String menu,int price) {
		this.menu=menu;
		this.price=price;
	}
	//출력용메서드
	public void getWriteMenu() {
		menu_no++;
		
		System.out.println("[메뉴"+menu_no+"]");
		System.out.println("메뉴명: "+menu);
		System.out.println("가격: "+price);
		System.out.println("-----------------------");
		
	}
	
	
	
}

public class ExArrayObject {

	public static void main(String[] args) {
		//디폴트로 Food클래스 생성
		
		Food food1=new Food();
		food1.setFood("피자", 25000);
		food1.getWriteMenu();
		
		Food food2=new Food();
		food2.setFood("알리오올리오", 15000);
		food2.getWriteMenu();
		
		Food food3=new Food();
		food3.setFood("아보카도샌드위치", 17000);
		food3.getWriteMenu();

	}

}
