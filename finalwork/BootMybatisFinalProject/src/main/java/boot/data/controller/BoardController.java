package boot.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@GetMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("board/list");
		return mv;
	}
}
