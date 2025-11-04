package day1104;

public class Ex1Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("자식클래스로 생성");
		System.out.println("1. 자식클래스로 선언, 자식클래스로 생성(변수3개사용_red,pink,oran)");
		
		Ex1Red red=new Ex1Red();
		red.helloColor(); //부모메서드
		red.process(); //sub클래스에서 만든 메서드
		
		Ex1Pink pink=new Ex1Pink();
		pink.helloColor();
		pink.process();
		
		Ex1Orange oran=new Ex1Orange();
		oran.helloColor();
		oran.process();
		
		System.out.println("===========================");
		System.out.println("2. 부모클래스로 선언, 자식클래스로 생성(=다형성)_변수1개");
		
		
//		Ex1Color color=new Ex1Red();
//		color.process(); 
		//부모한테는 없고 자식만 가지고 있는 메서드는 호출이 안됨
		
		Ex1Color color; //선언1
		color=new Ex1Red(); //생성1
		color.helloColor(); //부모가 가진 메서드호출 OK
		color.process(); 
		//메서드가 오버라이딩이라면 가능
		
		color=new Ex1Pink(); //생성2
		color.helloColor();
		color.process();
		
		color=new Ex1Orange(); //생성2
		color.helloColor();
		color.process();
		
	}

}
