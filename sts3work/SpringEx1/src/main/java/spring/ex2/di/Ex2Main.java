package spring.ex2.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app2=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//MyInfo
		MyInfo my=(MyInfo)app2.getBean("my");
		//°ª È®ÀÎ
		System.out.println(my.toString());
		System.out.println(my);
		
		//Person
		Person per=(Person)app2.getBean("person");
		per.writeData();
		Person per2=app2.getBean("person", Person.class);
		per2.writeData();
	}

}
