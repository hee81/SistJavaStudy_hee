package day1031;
//super
class Person{
	
	String name;
	String buseo;
	
	//메서드
	public void writeSawon() {
		System.out.println("부모변수 출력");
		System.out.println("이름: "+this.name);
		System.out.println("부서: "+this.buseo);
	}
}

//sub
class MyInfo extends Person{
	
	int age;
	String position;//직급
	
	//명시적생성자
	public MyInfo(String name, String buseo, int age, String position) {
		this.name=name;
		this.buseo=buseo;
		this.age=age;
		this.position=position;
	}
	
	//단독으로 부모의 멤버로 메서드 작성가능
	public void writeMyInfo()
	{
		System.out.println("사원명: "+this.name);
		System.out.println("부서: "+this.buseo);
		System.out.println("나이: "+this.age);
		System.out.println("직급: "+this.position);
	}
	
	//오버라이딩 메서드 구현(메서드명은 같아야 한다)
	@Override
	public void writeSawon() {
		// TODO Auto-generated method stub
		super.writeSawon();
		System.out.println("나이: "+this.age);
	}
	
	
}



public class Ex3Inheri {

	public static void main(String[] args) {
		MyInfo mi=new MyInfo("홍길동", "인사과", 25, "사원");
		mi.writeMyInfo();
		
		System.out.println("=============");
		
		mi.writeSawon();

	}

}
