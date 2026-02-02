package spring.ex3.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		// writeData() 출력하기
		ApplicationContext app3=new ClassPathXmlApplicationContext("sawonConfig.xml");
		// sawonData
		Sawon s1=app3.getBean("sawon", Sawon.class);
		s1.writeData();
		
		Sawon s2=(Sawon)app3.getBean("sawon2");
		s2.writeData();
		

	}

}
