package spring.hello.hi;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodController {
	
	@GetMapping("/happy")
	public String list1(Model m) {
		m.addAttribute("m1", "이미지 2개 출력");
		return "mystudy01";
	}
	
	@GetMapping("/hello/my")
	public ModelAndView list2() {
		ModelAndView mv=new ModelAndView();
		
		//request
		mv.addObject("title", "msg");
		mv.addObject("foodMenu", "애그샌드위치");
		//forward
		mv.setViewName("mystudy02");
		
		return mv;
	}
	
	@GetMapping("/nice/hello")
	public ModelAndView list3(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		//session
		session.setAttribute("id", "lskd1213");
		//request
		mv.addObject("addr", "서울시");
		//forward
		mv.setViewName("mystudy03");
		return mv;
	}
}
