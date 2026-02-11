package boot.mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@Controller
public class MyCarController {
	
	@Autowired
	MyCarDao dao;

	//list
	@GetMapping("/mycar/list")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		List<MyCarDto> list=dao.getAllDatas();
		mv.addObject("list", list);
		mv.addObject("count", list.size());
		mv.setViewName("carlist");
		return mv;
	}
	
	//addform 생성
	@GetMapping("/mycar/addform")
	public String form() {
		return "addform";
	}
	
	//insert
	@PostMapping("/mycar/insert")
	public String add(@ModelAttribute MyCarDto dto)
	{
		dao.InsertMycar(dto);
		return "redirect:list";
	}
	
	//updateform 생성
	@GetMapping("/mycar/updateform")
	public ModelAndView upform(@RequestParam long num) {
		ModelAndView mv=new ModelAndView();
		MyCarDto dto=dao.getOneData(num);
		mv.addObject("dto", dto);
		mv.setViewName("updateform");
		return mv;
	}
	
	//update
	@PostMapping("/mycar/update")
	public String update(@ModelAttribute MyCarDto dto)
	{
		dao.updateMycar(dto);
		return "redirect:list";
	}
	
	//delete
	@GetMapping("/mycar/delete")
	public String delete(@RequestParam long num) {
		dao.deleteMyCar(num);
		return "redirect:list";
	}

}
