package day1104;

interface MyColor{
	String INITCOLOR="white";
	public void paintColor();
}

class Red implements MyColor{

	@Override
	public void paintColor() {
		System.out.println("현재 색상은 "+INITCOLOR);
		System.out.println("레드 컬러로 도색합니다.");
		
	}
	
}

class Blue implements MyColor{

	@Override
	public void paintColor() {
		System.out.println("현재 색상은 "+INITCOLOR);
		System.out.println("블루 컬러로 도색합니다.");
		
	}
	
}

class Green implements MyColor{
	@Override
	public void paintColor() {
		System.out.println("현재 색상은 "+INITCOLOR);
		System.out.println("그린 컬러로 도색합니다.");
		
	}
}


public class Ex7Inter {

	public static void main(String[] args) {
		// Red, Blue, Green로 MyColor를 구현하고 각 클래스마다 
		// 현재 색상은 white
		// 레드 컬러로 도색합니다
		// MyColor로 선언하고 각각의 컬러로 생성해주세요(다형성)
		
		MyColor color;
		
		color=new Red();
		color.paintColor();
		
		System.out.println();
		
		color=new Blue();
		color.paintColor();
		
		System.out.println();
		
		color=new Green();
		color.paintColor();
		

	}

}
