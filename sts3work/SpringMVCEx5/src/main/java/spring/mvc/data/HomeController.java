package spring.mvc.data;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.dto.TestDto;

@Controller
public class HomeController {
	
	//home에서 시작하기
	@GetMapping("/")
	public String home() {
		return "data/home";
	}
	
	//입력폼으로 이동
	@GetMapping("/data/myform")
	public String myform() {
		return "data/form";
	}
	
	//1번 폼전송
	@GetMapping("/data/read1")
	//폼태그의 age와 읽을 변수가 같다면 앞의 age은 생략가능하다
	public ModelAndView r1(@RequestParam("name") String name, @RequestParam int age) {
		ModelAndView mv=new ModelAndView();
		//request에 저장
		mv.addObject("fname", name);
		mv.addObject("fage", age);
		//forward
		mv.setViewName("data/result1");
		return mv;
	}
	
	//2번 폼전송
	@PostMapping("/data/read2")
	//@ModelAttribute : 폼과 dto 변수가 같아야지만 사용함
	public ModelAndView r2(@ModelAttribute TestDto dto) {
		ModelAndView mv=new ModelAndView();
		//request에 저장
		mv.addObject("dto", dto); //없어도 되긴하지만 있으면 편함
		//forward
		mv.setViewName("data/result2");
		return mv;
	}
	
	//3번 폼전송
	@PostMapping("/data/read3")
	public ModelAndView r3(@RequestParam Map<String, String> map) {
		ModelAndView mv=new ModelAndView();
		
		String sang=map.get("sname");
		String price=map.get("sprice");
		String data=sang+"제품의 가격은 "+price+"원 입니다";
		mv.addObject("data", data);
		
		mv.setViewName("data/result3");
		return mv;
	}
	
}
