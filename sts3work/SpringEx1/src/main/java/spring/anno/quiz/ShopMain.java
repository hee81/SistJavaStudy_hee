package spring.anno.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {

	public static void main(String[] args) {
		// OrderController에 있는 메서드 2개를 호출하여 출력하시오
		ApplicationContext quiz=new ClassPathXmlApplicationContext("quizContext.xml");
		//OrderController sd=(OrderController)quiz.getBean("oc");
		OrderController sd=quiz.getBean("oc", OrderController.class);
		sd.jumunInsert("핸드크림", 1);
		sd.jumunSelect("사탕", 5);
	}

}
