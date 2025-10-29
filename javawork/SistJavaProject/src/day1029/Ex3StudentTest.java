package day1029;

public class Ex3StudentTest {

	public static void main(String[] args) {

		Ex3Student.schoolname="쌍용교육센터";
		
		//객체생성은 여러개 가능~~실제로는 계속 만들지 않는다.(주소값은 다름=reference값이 다름)
		Ex3Student s1=new Ex3Student();
		Ex3Student s2=new Ex3Student();
		
		//학생1
		s1.name="홍길동";
		s1.age=24;
		//학생2
		s2.name="김영희";
		s2.age=28;
		
		//출력
		System.out.println("**클래스 맴버값 출력**");
		System.out.println("[학교명:"+Ex3Student.schoolname+"]");
		System.out.println("학생1:");
		System.out.println("이름:"+s1.name+",나이:"+s1.age);
		System.out.println("학생2:");
		System.out.println("이름:"+s2.name+",나이:"+s2.age);
		

	}

}
