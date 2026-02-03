package spring.mvc.day0202;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//사원명(sawonName),부서명(buseo),급여(pay)를 result3에서 출력하도록 한다
	//메서드명 company
	@GetMapping("apple/list")
	public String Company(Model m3) {
		
		m3.addAttribute("sawonName", "고길동");
		m3.addAttribute("buseo", "인사부");
		m3.addAttribute("pay", "2500000");
		
		return "result3";
	}
	
	@GetMapping("kakao/list")
	//ModelAndView는 request에 저장하기 위한 Model과 forward하기 위한 view를 합친 클래스
	public ModelAndView klist(HttpSession session) {
		
		ModelAndView mv=new ModelAndView(); 
		//request에 저장
		mv.addObject("java", 88);
		mv.addObject("spring", 99);
		//session에 저장
		session.setAttribute("myid", "admin");
		//forward할 jsp파일 지정
		mv.setViewName("result4");
		return mv;
	}
	
}
