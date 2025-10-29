package day1029;

//객체의 속성은 인스턴스변수로 표현하고
//객체의 동작은 매서드로 표현하다
//Object:객체(핸드폰,텀블러,마우스)
//Class:객체를 정의해놓은것, 객체를 생성하기 위해 존재
//Instance:클래스에서 만들어진 객체가 그 클래스의 인스턴스라고 한다

//맴버변수(class 아래에서 정의하는것):instance 변수, static 변수(클래스변수)

public class Ex1Object {
	
	String name; //iv(instance 변수):객체생성 후 값 변경, 호출 가능
	static final String MESSAGE="오늘은 클래스 배우는날!!!";
	//cv(클래스 변수):주로 상수선언에 사용, 객체생성 없이 클래스명으로 접근가능(같은 클래스 내에서는 클래스명 생략가능)

	public static void main(String[] args) {
		
		System.out.println("static변수는 new로 생성없이 호출가능하다");
		System.out.println(MESSAGE);
		System.out.println(Ex1Object.MESSAGE); //같은 클래스여서 생략가능
		
		//MESSAGE="nice day"; //final이라 값변경 안됨, 상수선언시 수정 거의 안함 final은 안전장치임! 
		
		//0. name과 같은 인스턴스 변수는 객체생성을 해야만 사용가능
		Ex1Object ex1=new Ex1Object(); //ex1->instance 변수임.
		System.out.println(ex1.name); //클래스에서 초기화안하면 문자는 null로 자동인식
		
		//1. 첫번째 이름 초기화 후 출력
		ex1.name="홍길동";
		System.out.println(ex1.name);
		
		//2. 두번째 이름 초기화 후 출력
		Ex1Object ex2=new Ex1Object();
		ex2.name="김민지";
		System.out.println(ex2.name); //객체 생성할 때마다 해야함!
		
		System.out.println("다 같이 사용하는 매세지: "+MESSAGE);
		
		
		
		
		
		
		
	}

}
