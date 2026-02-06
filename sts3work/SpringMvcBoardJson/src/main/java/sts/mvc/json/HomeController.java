package sts.mvc.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//초기화면
	@GetMapping("/")
	public String home() {
		return "json/home";
	}
	
	//ex1으로
	@GetMapping("/jsonex1")
	public String ex1() {
		return "json/ex1";
	}
	
	//ex2으로
	@GetMapping("/jsonex2")
	public String ex2() {
		return "json/ex2";
	}
}
