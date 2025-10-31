package day1031_2;

import day1031.Ex1SuperObj;

//이와 같은 경우는 잘 사용안함 보통 부모-private사용 why?->보안
public class Ex1SubObj extends Ex1SuperObj{
	
	private String addr;
	
	public Ex1SubObj(String name, int age, String addr) {
		super(name, age); //반드시 첫줄에 부모 생성자 호출하기
		this.addr=addr;
//		super(name, age); //부모가 자식밑에 있으면 오류남
		
	}
	
	//메서드
	public void writeData()
	{
		System.out.println("이름: "+this.name); //super안씀
		System.out.println("나이: "+this.age);
		System.out.println("주소: "+this.addr);
	}

	

}
