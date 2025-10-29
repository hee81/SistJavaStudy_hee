package day1029;

public class Ex2Card {
	
	String kind; //카드의 무늬
	int number; //카드의 숫자
	
	static int width;
	static int height;

	public static void main(String[] args) {
		// static변수는 클래스가 로딩될 때 생성 끝날때 소멸
		Ex2Card.width=10;
		height=20;
		
		System.out.println(width);
		System.out.println(Ex2Card.height);
		
		//인스턴스 변수 kind,number 생성
		Ex2Card c1=new Ex2Card();
		c1.kind="Heart";
		c1.number=5;
		
		Ex2Card c2=new Ex2Card();
		c2.kind="Diamond";
		c2.number=7;
		
		System.out.println(c1.kind+","+c1.number+","+width+","+Ex2Card.height);
		System.out.println(c2.kind+","+c2.number+","+Ex2Card.width+","+height);

	}

}
