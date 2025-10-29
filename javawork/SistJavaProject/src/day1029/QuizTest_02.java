package day1029;

class Quiz2{
	private String stuName;
	private String gender; //성별
	private String addr; //주소
	
	static String ban;
	static int cnt=0;
	
	//어떤 방법으로 해도 좋다
	//default생성자_setter,getter(기본)
	////명시적생성자에 3개의 인자를 넣고 해도 좋다
	//출력문을 메서드로 만들어서 출력해도 좋다
	//시간 남으면 cnt도 증가시켜서 1,2에 추가해보세요
	
	public Quiz2(String name,String gender,String addr) {
		stuName=name;
		this.gender=gender;
		this.addr=addr;
	}
	
	public String getStuName()
	{
		return stuName;
	}
	public String getGender()
	{
		return gender;
	}
	public String getAddr()
	{
		return addr;
	}
}

public class QuizTest_02 {

	public static void main(String[] args) {
		/*
		 **학생1정보**
		 이름: 이병헌
		 소속반: JAVA 4class
		 성별: 남자
		 주소: 서울시 강서구
		 =================
		 **학생2정보**
		 이름: 신민아
		 소속반: JAVA 4class
		 성별: 여자
		 주소: 서울시 강동구
		 
		 */

		System.out.println("**학생1정보**");
		Quiz2 test2=new Quiz2("이병헌", "남자", "서울시 강서구");
		String sname=test2.getStuName();
		Quiz.ban="JAVA 4class";
		String sgender=test2.getGender();
		String saddr=test2.getAddr();
		
		System.out.println("이름: "+sname);
		System.out.println("소속반: "+Quiz.ban);
		System.out.println("성별: "+sgender);
		System.out.println("주소: "+saddr);

		System.out.println("======================");
		System.out.println("**학생2정보**");
		Quiz2 test3=new Quiz2("신민아", "여자", "서울시 강동구");
		String sname2=test3.getStuName();
		Quiz.ban="JAVA 4class";
		String sgender2=test3.getGender();
		String saddr2=test3.getAddr();
		
		System.out.println("이름: "+sname2);
		System.out.println("소속반: "+Quiz.ban);
		System.out.println("성별: "+sgender2);
		System.out.println("주소: "+saddr2);
	}

}
