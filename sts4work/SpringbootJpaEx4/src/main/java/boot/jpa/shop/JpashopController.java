package boot.jpa.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JpashopController {
	
	@Autowired
	JpashopDao dao;
	
	//초기화면(home)
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//addform 으로
	@GetMapping("/myjpa/shop")
	public String addform() {
		return "addform";
	}
	
	//shoplist로
	@GetMapping("/myjpa/list")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		List<ShopDto> list=dao.getAllDatas();
		mv.addObject("list", list);
		mv.addObject("count", list.size());
		mv.setViewName("shoplist");
		return mv;
	}
	
	//insert
	@PostMapping("/myjpa/add")
	public ModelAndView insert(@ModelAttribute ShopDto dto) {
		ModelAndView mv=new ModelAndView();
		dao.insertShop(dto);
		mv.setViewName("redirect:list");
		return mv;
	}
	
	//updateform으로
	@GetMapping("/myjpa/updateform")
	public ModelAndView upform(@RequestParam int num) {
		ModelAndView mv=new ModelAndView();
		ShopDto dto=dao.getOneData(num);
		mv.addObject("dto", dto);
		mv.setViewName("updateform");
		return mv;
	}
	
	//update
	@PostMapping("/myjpa/update")
	public ModelAndView update(@ModelAttribute ShopDto dto) {
		ModelAndView mv=new ModelAndView();
		dao.updateShop(dto);
		mv.setViewName("redirect:list");
		return mv;
	}
	
	//delete
	@GetMapping("/myjpa/delete")
	public String delete(@RequestParam int num) {
		dao.deleteShop(num);
		return "redirect:list";
	}
	
}

