package data.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ShopDto;

@Controller
public class HelloController {
	
	
	List<ShopDto> list=new ArrayList<>();

	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/hello1")
	public String hello1(Model model)
	{
		System.out.println("hello1 controller");
		
		model.addAttribute("message", "Have a Nice Day!!!");
		model.addAttribute("today", new Date());
		
		ShopDto dto=ShopDto.builder()
				.num(100)
				.sangpum("노트북")
				.su(5)
				.dan(2500000)
				.color("pink")
				.build();
		
		model.addAttribute("dto", dto);
		return "hello1";
	}
	
	@GetMapping("/hello2")
	public String hello2(@RequestParam("name") String name,
			@RequestParam("age") int age,
			Model model)
	{
		
		model.addAttribute("msg", name+"님의 나이는 "+age+"세 입니다");
		return "hello2";
	}
	
	@GetMapping("/list")
	public String list(Model model)
	{
		list.add(new ShopDto(1, "텀블러", 10, 28000, "pink"));
		list.add(new ShopDto(2, "에스프레소컵", 8, 32000, "black"));
		list.add(new ShopDto(3, "우산", 20, 15000, "green"));
		list.add(new ShopDto(4, "쿠키세트", 33, 12000, "white"));
		ShopDto dto5=ShopDto.builder()
				 .num(10)
				 .sangpum("티슈")
				 .su(55)
				 .dan(1200)
				 .color("blue")
				.build();
		
		list.add(dto5);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("index") int index,Model model)
	{
		model.addAttribute("dto", list.get(index));
		return "detailpage";
	}
	
	
}
