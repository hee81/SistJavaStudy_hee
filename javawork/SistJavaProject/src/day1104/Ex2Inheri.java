package day1104;

//super
class Work{
	public void process() {
		System.out.println("아무일도 안함");
	}
}

//sub1
class Food extends Work{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("**요리를 담당합니다**");
	}
}

//sub2
class Clean extends Work{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("**청소를 담당합니다**");
	}
}

public class Ex2Inheri {

	public static void main(String[] args) {
		System.out.println("1.자식클래스로 선언과 생성");
		Food food=new Food();
		food.process();
		
		Clean clean=new Clean();
		clean.process();
		
		System.out.println("===============================");
		System.out.println("2.부모클래스 선언, 자식클래스로 생성");
		Work work=new Food();
		work.process();
		
		work=new Clean();
		work.process();

	}

}
