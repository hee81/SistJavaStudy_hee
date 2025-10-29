package day1029;

public class Ex4ConstTest {
	
	//iv변수 static변수 비교테스트
	int count=0;
	
	//생성자
	public Ex4ConstTest() {
		
		count++;
		System.out.println(count);

	}

	public static void main(String[] args) {

		Ex4ConstTest con=new Ex4ConstTest(); //iv-1, cv-1 //생성자 숨어있기에 실행됨.
		Ex4ConstTest con2=new Ex4ConstTest(); //iv-1, cv-2
		
		//iv는 서로 다른 메모리를 가지고 있으므로 생성을 각각 하더라도
		//카운트가 증가하지 않는다
		//static은 서로 메모리를 공유하므로 계속 생성하면 1,2...증가한다

	}

}
