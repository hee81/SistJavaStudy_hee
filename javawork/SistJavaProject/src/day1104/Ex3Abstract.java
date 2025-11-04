package day1104;

//super...추상클래스로_추상메서드가 단 하나만 있어도 추상클래스임.
//class Fruit{ //오류남
abstract class Fruit{
	
	//상수
	public static final String MESSAGE="오늘은 추상클래스 배우는 날!!";
	
	//일반매서드
	public void showTitile() {
		System.out.println("추상클래스 제목을 출력합니다");
	}
	
	//추상매서드_오버라이딩이 목적이므로 상속받은 자식클래스에서는 반드시 오버라이딩 해주어야 한다
//	public void showMessage(); //오류남
	abstract public void showMessage();

	
}

//sub1
class Apple extends Fruit{ //오버라이딩 안하면 오류가 난다.

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("나는 사과입니다");
		
	} 
	
}

//sub2
class Banana extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("나는 바나나입니다");
	}
	
}

//sub3
class Orange extends Fruit{

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("나는 오렌지입니다");
	}
	
}

public class Ex3Abstract {

	public static void main(String[] args) {
		// 다형성으로 출력하기
		Fruit fru=new Apple();
		fru.showTitile();
		fru.showMessage();
		
		fru=new Banana();
		fru.showMessage();
		
		fru=new Orange();
		fru.showMessage();

	}

}
