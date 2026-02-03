package spring.mvc.day0202;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
	
	@GetMapping("/shop/detail")
	public String shoplist() {
		return "imgresult";
	}
	
	
	@GetMapping("/admin/shop/mypage")
	public String shoplist2() {
		return "imgresult2";
	}
	
	@GetMapping("myshop")
	public String shoplist3() {
		return "imgresult3";
	}
	
}
