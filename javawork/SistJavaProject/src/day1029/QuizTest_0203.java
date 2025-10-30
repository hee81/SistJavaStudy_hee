package day1029;

class Quiz23{
	private String stuName;
	private String gender; //성별
	private String addr; //주소
	
	static String ban;
	static int cnt=0;
	
	//어떤 방법으로 해도 좋다
	//default생성자_setter,getter(기본)
	////명시적생성자에 3개의 인자를 넣고 해도 좋다
	////출력문을 메서드로 만들어서 출력해도 좋다
	////시간 남으면 cnt도 증가시켜서 1,2에 추가해보세요
	
	public void SetStuData(String name,String gender,String addr) {
		stuName=name;
		this.gender=gender;
		this.addr=addr;
	}
	
	public void GetStuData()
	{
		cnt++;
		System.out.println("**학생"+cnt+"정보**");
		System.out.println("이름: "+stuName);
		System.out.println("소속반: "+ban);
		System.out.println("성별: "+gender);
		System.out.println("주소: "+addr);
	}
}

public class QuizTest_0203 {

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

		Quiz23 test1=new Quiz23();
		Quiz23 test2=new Quiz23();
		
		test1.SetStuData("이병헌", "남자", "서울시 강서구");
		test2.SetStuData("신민아", "여자", "서울시 강동구");
		
		Quiz23.ban="JAVA 4class";
		
		test1.GetStuData();
		System.out.println("======================");
		test2.GetStuData();

	}

}