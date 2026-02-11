package boot.jpa.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JpashopController {
	
	@Autowired
	JpashopDao dao;
	
	//초기화면(home)
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//addform 으로
	@GetMapping("/myjpa/shop")
	public String addform() {
		return "addform";
	}
}

