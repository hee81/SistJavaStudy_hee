package spring.anno.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("oc")
public class OrderController {
	
	//ShopDao dao;
	@Autowired
	ShopDaoInter shopInter;
	
	int cnt=20;
	String name="김나나";
	
	public void jumunInsert(String sang,int p) {
		shopInter.insertShop(sang, p);
		System.out.println(name+"님이 "+cnt+"개 주문했습니다.");
	}
	
	public void jumunSelect(String sang,int price) {
		shopInter.selectShop(sang, price);
		System.out.println("주문자: "+name);
		System.out.println("주문갯수: "+cnt);
	}
}
