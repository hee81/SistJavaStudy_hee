package day1110;

abstract class AstEx1{
	abstract public void display();
	abstract public void show();
}

public class Ex4Annony {

	//익명내부클래스로 추상메서드2개 오버라이딩
	AstEx1 as1=new AstEx1() {
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("show메서드호출");
		}
		
		@Override
		public void display() {
			// TODO Auto-generated method stub
			System.out.println("display메서드 호출");
		}
	};
	
	
	public static void main(String[] args) {
		// 메인에서 익명내부클래스 메소드 호출
		Ex4Annony ex=new Ex4Annony();
		ex.as1.display();
		ex.as1.show();
		
	}

}