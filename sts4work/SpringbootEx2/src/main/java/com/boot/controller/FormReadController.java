package com.boot.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.dto.InfoDto;

@Controller
@RequestMapping("/my")
public class FormReadController {
	//폼 안의 컬럼을 각각 읽어서 resul1,2,3로 보낸다
	
	//폼1-->result1
	@PostMapping("/read1")
	public ModelAndView r1(@RequestParam String name,
			@RequestParam int java,
			@RequestParam int spring) {
		ModelAndView mv=new ModelAndView();
		//request에 저장
		mv.addObject("name", name);
		mv.addObject("java", java);
		mv.addObject("spring", spring);
		mv.addObject("tot", java+spring);
		mv.addObject("avg", (java+spring)/2.0);
		//forward
		mv.setViewName("result/result1");
		return mv;
	}
	
	//폼2-->result2 (Dto)
	@PostMapping("/read2")
	public ModelAndView r2(@ModelAttribute("dto") InfoDto dto) {
		ModelAndView mv=new ModelAndView();
		//mv.addObject("dto", dto);
		mv.setViewName("result/result2");
		return mv;
	}
	
	//폼3-->result3 (Map)
	//map으로 읽을경우 폼의 name이 key값으로, 입력값이 value값으로 들어간다
	@PostMapping("/read3")
	public ModelAndView r3(@RequestParam HashMap<String, String> map){
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("irum3", map.get("irum"));
		mv.addObject("blood3", map.get("blood"));
		mv.addObject("hp3", map.get("hp"));
		
		mv.setViewName("result/result3");
		
		return mv;
	}
	
}
