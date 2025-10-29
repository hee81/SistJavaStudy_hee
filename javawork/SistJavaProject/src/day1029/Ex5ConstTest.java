package day1029;

public class Ex5ConstTest {
	
	int num; //0
	
	//default 생성자 
	public Ex5ConstTest() {
		num=10;
		System.out.println("나는 디폴트 생성자"+num);
	}
	
	//명시적 생성자
	public Ex5ConstTest(int num) {  //overloading..같은인자 사용~
		//public Ex5ComstTest() {}...오류남..
		this.num=num; //reference num에 this붙이기
		System.out.println("나는 명시적 생성자");
	}
	
	//매서드(함수)
	public int getNumber()//매서드에 반환타입이 있으면 return필수!
	{
		num=50;
		return num; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//default 출력
		Ex5ConstTest ex1=new Ex5ConstTest(); //생성자가 존재한다~~
		System.out.println(ex1.num);//생성자num출력됨
		
		//명시적생성자 생성
		Ex5ConstTest ex2=new Ex5ConstTest(30); //생성과 동시에 초기화
		System.out.println(ex2.num);
		
		//매서드
		Ex5ConstTest ex3=new Ex5ConstTest();
		System.out.println(ex3.num);
		System.out.println(ex3.getNumber());
		

	}

}
