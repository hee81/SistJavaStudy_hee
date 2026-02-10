package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("name", "쌍용교육센터");
		mv.addObject("addr", "서울시");
		
		mv.setViewName("list"); //board/list
		
		return mv;
	}
}
