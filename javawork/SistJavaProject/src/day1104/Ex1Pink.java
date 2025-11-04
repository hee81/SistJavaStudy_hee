package day1104;

//sub
public class Ex1Pink extends Ex1Color{
	
	// 부모한테는 없고 자식만 가지고 있는 메서드는 호출이 안됨
//	public void process() { //다른 자식과 같은 메서드명 사용가능, 자식끼리 오버로딩은 안됨
//		System.out.println("나는 핑크매니아_subclass");
//	}
	
	//메서드가 오버라이딩이라면 가능
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		
		System.out.println("나는 핑크매니아_subclass");
	}

}
