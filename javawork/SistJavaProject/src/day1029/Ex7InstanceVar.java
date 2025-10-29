package day1029;

class MyInfo{
	
	String name; //null
//	private String name; //null 
	//private이 붙으면 생성해도 접근이 안됨!-->method 만들어서 가져가야함!(캡슐화)
	int age; //0
	String city; //null	
}

///////////////////////////
public class Ex7InstanceVar {

	public static void main(String[] args) {
		// MyInfo 생성해서 초기화 후 출력
		// 디폴트 인스턴스 변수는 생성 후 참조변수를 통해서 변수명을 불러올 수 있다.
		// 참조변수명(int1).변수명(name)
		/*
		 이름: 홍길동
		 나이:26
		 지역: 서울시 
		 */
		MyInfo ex1=new MyInfo();
		ex1.name="홍길동";
		ex1.age=26;
		ex1.city="서울시";
		
		System.out.println("이름: "+ex1.name);
		System.out.println("나이: "+ex1.age+"세");
		System.out.println("지역: "+ex1.city);
	}

}
