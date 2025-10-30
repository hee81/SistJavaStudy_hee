package day1030;

class TestMethod{
	private String sangpum;
	private String made; //한국,중국
	private int price;
	
	//디폴트 생성자
	public TestMethod() {
		// TODO Auto-generated constructor stub
	}
	
	//3개의 맴버변수를 한꺼번에 변경하는 생성자
	public TestMethod(String sangpum,String made,int price) {
		this.sangpum=sangpum;
		this.made=made;
		this.price=price;
	}
	
	//3개의 맴버변수를 한꺼번에 변경하는 메소드 _set
	public void setMethod(String sangpum,String made,int price) {
		this.sangpum=sangpum;
		this.made=made;
		this.price=price;
	}
	
	//출력용메서드
	public void getMethod() {
		System.out.println("**입고상품**");
		System.out.println("상품명: "+this.sangpum);
		System.out.println("생산지: "+this.made);
		System.out.println("가격: "+this.price+"원");
		System.out.println("========================");
	}
	
	//3개를 동시에 리턴받는 get메서드 방식으로 만들어보자
	public String getIpgoSangpum()//숫자+" "빈칸만 있어도 문자로 인식
	{
		String s="**입고상품**\n상품명: "+this.sangpum+"\n원산지: "+made+"\n가격: "+price+"원";
		return s;
	}
}

 
public class Ex1Object {

	public static void main(String[] args) {
		/*
		 아이폰	중국	    1200000
		 갤럭시	베트남	1500000
		 */
		
		
		TestMethod test1=new TestMethod();
		test1.setMethod("아이폰", "중국", 1200000);
		test1.getMethod();
		
		TestMethod test2=new TestMethod();
		test2.setMethod("갤럭시", "베트남", 1500000);
		test2.getMethod();
		
		TestMethod test3=new TestMethod();
		test3.setMethod("바나나", "태국", 5000);
		System.out.println(test3.getIpgoSangpum());
		
		//네번째생성은 명시적생성자로
		TestMethod test4=new TestMethod("파스타", "이탈리아", 12000); //생성과 동시에 초기화가 됨!!
//		TestMethod test4=new TestMethod();
		test4.getMethod();

	}

}
