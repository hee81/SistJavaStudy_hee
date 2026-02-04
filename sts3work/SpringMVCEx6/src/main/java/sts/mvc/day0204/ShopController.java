package sts.mvc.day0204;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import data.dto.ShopDto;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	//js테스트 누르면 list로
	@GetMapping("/list")
	public String js() {
		return "shop/list";
	}
	
	//4번링크 누르면 shopform으로 이동
	@GetMapping("/form2")
	public String form2() {
		return "shop/shopform";
	}
	
	//shopresult에서 출력
	@PostMapping("/process2")
	public ModelAndView sresult(@ModelAttribute ShopDto dto) {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("dto", dto);
		mv.setViewName("shop/shopresult");
		
		return mv;
	}
}
