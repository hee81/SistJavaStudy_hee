package spring.mvc.coffee;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
	
	@GetMapping("/")
	public String Start() {
		return "mypage/home";
	}
	
	@GetMapping("/coffee/star")
	public String list1(Model model) {
		
		model.addAttribute("name", "김둘리");
		model.addAttribute("hp", "010-1111-2222");
		model.addAttribute("job", "작가");
		
		return "mypage/study1";
	}
	
	@GetMapping("/coffee/bean")
	public ModelAndView list2(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		
		//session
		session.setAttribute("Id", "dd0011");
		//request
		mv.addObject("pass", 1234);
		mv.addObject("email", "dd0011@naver.com");
		//forward
		mv.setViewName("mypage/study2");
		
		return mv;
	}
	
	@GetMapping("/pink/add/list")
	public ModelAndView list3() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("myimg", "이미지출력~");
		mv.setViewName("mypage/study3");
		return mv;
	}
	
	
	
	
}
