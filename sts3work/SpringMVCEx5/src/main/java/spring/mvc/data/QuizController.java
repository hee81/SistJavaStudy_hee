package spring.mvc.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import data.dto.SawonDto;

@Controller
public class QuizController {
	
	//form 출력
	@GetMapping("/quiz/form")
	public String qform() {
		return "quiz/myform";
	}
	
	//사원 데이터 출력
	@PostMapping("/quiz/info")
	public ModelAndView qdata(@ModelAttribute SawonDto dto) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("quiz/sawoninfo");
		return mv;
	}
}
