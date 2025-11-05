package day1105;

//inter_super
interface GameA{
	
	public void play();
	
}

interface GameB{
	
	public void stop();
	
}

//sub
//interface를 구현할 class
class MyGame implements GameA,GameB{
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("게임을 시작합니다");
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("게임을 중단합니다");
	}
	
}






public class Ex1Interface {

	public static void main(String[] args) {
		// 인터페이스를 구현한 클래스로 생성
		MyGame mg=new MyGame();
		mg.play();
		mg.stop();
		
		System.out.println("====================");
	
		// 인터페이스로 선언 구현한 클래스로 생성(다형성)
		
		GameA ga=new MyGame();
		ga.play();
		
		GameB gb;
		gb=new MyGame();
		gb.stop();
		
		
		
		

	}

}
