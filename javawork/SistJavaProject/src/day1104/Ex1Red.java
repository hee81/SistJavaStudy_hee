package day1104;

//sub
public class Ex1Red extends Ex1Color{

	// 부모한테는 없고 자식만 가지고 있는 메서드는 호출이 안됨
//	public void process() {
//		System.out.println("나는 레드를 좋아한다_subclass");
//	}
	
	//메서드가 오버라이딩이라면 가능
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("나는 레드를 좋아한다_subclass");
	}

}
