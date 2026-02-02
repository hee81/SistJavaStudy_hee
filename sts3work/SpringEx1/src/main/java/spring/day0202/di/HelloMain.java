package spring.day0202.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		System.out.println("자바방식의 Hello메서드 호출");
		//자바=객체 직접 생성
		Hello hello1=new Hello();
		System.out.println(hello1.getMessage());
		Hello hello2=new Hello();
		System.out.println(hello2.getMessage());
		//레퍼런스 주소비교
		System.out.println(hello1==hello2); //false
		

		System.out.println("=================================");
		
		
		System.out.println("스프링방식의 Hello메서드 호출");
		//설정 xml파일 가져오기(어플리케이션에서만 필요_웹으로 실행시 web.xml에 설정이 이미 되어 있음)
		ApplicationContext helloApp=new ClassPathXmlApplicationContext("helloContext.xml");
		//방법1
		Hello h1=(Hello)helloApp.getBean("hello");
		System.out.println(h1.getMessage());
		//방법2
		Hello h2=helloApp.getBean("hello", Hello.class);
		System.out.println(h2.getMessage());
		//레퍼런스 주소비교
		System.out.println(h1==h2); //true-스프링 빈은 싱글턴으로 생성 주소가 같음(=같은 객체임)
		
		
	}
}
