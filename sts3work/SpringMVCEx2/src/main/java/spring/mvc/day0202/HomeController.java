package spring.mvc.day0202;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//bean에 등록안하면 안됨
@Controller
public class HomeController {
	
	//home으로 첫 화면 나오게 바꾸기!
	@GetMapping("/")  //원하는 파일명으로 매핑 가능! but 서버 다시 켜야 인식함!
	public String home() {
		return "home"; //web-inf/day0202/home.jsp
	}
	
	
	//@RequestMapping(value = "/",method=RequestMethod.GET) //3버전
	@GetMapping("/dragon/sist") //5버전 이후에 사용가능(pom.xml에서 3.1.1.RELEASE > 5.2.9.RELEASE 로 변경하기)
	public String hello1(Model model) {
		/*
		 model1
		 :request에 데이터를 저장하는 클래스
		 :서블릿에서 request.setAttribute와 같다
		 */	
		model.addAttribute("name", "손흥민");
		model.addAttribute("addr", "서울시 강남구");
		
		return "result1"; //web-inf/day0202/result1.jsp
	}
	
	
	@GetMapping("/naver/shop")
	public String hello2(Model m2) {
		m2.addAttribute("sname", "요가매트");
		m2.addAttribute("color", "그레이");
		m2.addAttribute("price", "25000");
		
		return "result2";
	}
}
