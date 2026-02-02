package spring.ex4.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogicMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app4=new ClassPathXmlApplicationContext("annoContext4.xml");
		LogicController lg1=(LogicController)app4.getBean("logic");
		lg1.insert("점심메뉴");
		lg1.delete("3");
	}

}
