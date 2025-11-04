package day1104;

//super_interface
interface InterA{
	public void work();
	public void play();
}
interface InterB{
public void write();
}

//1. 2개의 인터페이스를 구현하는 클래스
class InterImpl implements InterA, InterB{ //다중구현가능
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("글을 작성한다");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("작업을 한다");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("축구를 한다");
	}
}

//2. 2개의 인터페이스를 구현하는 클래스
//interface InterA{ //interface끼리 상속가능
//	public void work();
//	public void play();
//}
//interface InterB extends InterA{
//	public void write();
//}
//class InterImpl implements InterB{
//	@Override
//	public void work() {
//		
//	}
//	@Override
//	public void play() {
//		
//	}
//	@Override
//	public void write() {
//		
//	}	
//}


public class Ex6Interface {

	public static void main(String[] args) {
		//자식으로 생성
		InterImpl inter=new InterImpl();
		inter.write();
		inter.work();
		inter.play();
		
		System.out.println();
		
		//다형성
		InterB interb=new InterImpl();
		interb.write();
		
		InterA intera=new InterImpl();
		intera.work();
		intera.play();


	}

}
