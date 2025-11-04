package day1104;

//super_interface_상수와 추상메서드만 가능함.(변수X,일반메서드X)
interface FoodShop{
	String SHOPNAME="돼지국밥"; //final 생략, 상수로 인식
	
	public void order(); //abstract 생략
	public void delivary();
}

//sub
class Food1 implements FoodShop{

	@Override
	public void order() {
		System.out.println(SHOPNAME);
//		SHOPNAME="파스타집"; // 변경 불가능
		System.out.println("음식을 주문합니다");
	}

	@Override
	public void delivary() {
		System.out.println(SHOPNAME);
		System.out.println("음식을 배달합니다");
	}
	
}


public class Ex5Interface {

	public static void main(String[] args) {
		//자식클래스로 선언 및 생성
		Food1 f1=new Food1();
		f1.order();
		f1.delivary();

		System.out.println();
		
		//부모 인터페이스로 선언 자식으로 생성
		//인터페이스는 생성못함(추상클래스도 생성못함)
		FoodShop fs=new Food1();
		fs.order();
		fs.delivary();

	}

}
