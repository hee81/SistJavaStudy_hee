package spring.ex4.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogicMain {

	public static void main(String[] args) {
		ApplicationContext app4=new ClassPathXmlApplicationContext("annoContext4.xml");
		LogicController lg1=(LogicController)app4.getBean("logicController"); //이름 지정 안하면 소문자로 등록됨
		//LogicController lg1=(LogicController)app4.getBean("logic"); //LogicController에서 @Component("logic")로 적어야 가능
		lg1.insert("점심메뉴");
		lg1.delete("3");

	}

}
