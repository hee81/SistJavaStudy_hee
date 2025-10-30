package day1030;

public class Ex8Method {
	
	public static void main(String[] args) {
		// main메서드에서 호출하는 순서대로 출력이된다!
		//(nice메서드가 위에 있다고 먼저 출력되는 것이 아님!)
		System.out.println("프로그램 시작");
		nice(12);
		nice(33);
//		hello(157,"이수현"); //인자의 순서는 지켜야함!
		hello("임소희",157.2);
	}
	
	public static void hello(String name,double height) {
		System.out.println("저의 이름은 "+name+"입니다");
		System.out.println("저의 키는 "+height+"cm 입니다");
		System.out.println("감사합니다");
	}

	public static void nice(int age) { 
		System.out.println("안녕하세요");
		System.out.println("제나이는 "+age+"세 입니다");
	}
	
}
