package day1110;

//클래스 선언과 객체생성을 동시에 하는 이름없는 클래스를 익명내부클래스 라고 한다(일회성)
//이벤트를 발생시켰다가 끝나면 메모리에서 제거-->메모리의 효율적관리에 좋다
abstract class AbstEx{
	
	abstract public void show();
}

class OuterEx{
	
	//익명내부클래스
	AbstEx abst=new AbstEx() {
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("익명내부 클래스");
		}
	};
	
}

/////////////////
public class Ex3Annonymous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        OuterEx ex=new OuterEx(); //생성은 외부클래스만
        ex.abst.show(); //참조변수.익명참조명.메서드  
	}

}