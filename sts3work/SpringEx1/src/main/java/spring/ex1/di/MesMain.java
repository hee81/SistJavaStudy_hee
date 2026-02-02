package spring.ex1.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MesMain {

	public static void main(String[] args) {

		//스프링방식 객체 생성 후 호출하기
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext1.xml");
		MessageInter m1=(Message1)context.getBean("mesBean1");
		m1.sayHello("나나");
		
		MessageInter m2=context.getBean("mesBean2", Message2.class);
		m2.sayHello("마이클");

		
	}

}
