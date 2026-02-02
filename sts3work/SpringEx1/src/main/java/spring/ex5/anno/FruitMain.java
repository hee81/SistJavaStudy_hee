package spring.ex5.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FruitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app5=new ClassPathXmlApplicationContext("annoContext4.xml");
		MyFruit mf=(MyFruit)app5.getBean("myFruit");
		mf.writeFruit();
		
		Apple ap=(Apple)app5.getBean("apple");
		ap.writeFruitName();

	}

}
