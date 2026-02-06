package db.data.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carinfo")
public class CarController {
	
	@Autowired
	CarDaoInter dao;
	
	//carlist로 이동
	@GetMapping("/list")
	public String list(Model model) {
		
		List<CarDto> list=dao.getAllDatas();
		int totalCount=dao.getTotalCount();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		
		return "carinfo/carlist";
	}
	
	//입력폼으로 이동
	@GetMapping("/writeform")
	public String form() {
		return "carinfo/addform";
	}
	
	//db저장
	@PostMapping("/write")
	public ModelAndView insert(@ModelAttribute CarDto dto) {
		ModelAndView mv=new ModelAndView();
		dao.insertCar(dto);
		mv.setViewName("redirect:list");
		return mv;
	}

	//삭제 후 list로 이동
	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
		dao.deleteCar(num);
		return "redirect:list";
	}
	
	//수정폼으로 이동
	@GetMapping("/updateform")
	public String uform(String num,Model model) //@RequestParam 생략가능
	{	
		CarDto dto=dao.getOneData(num);
		model.addAttribute("dto", dto);
		
		return "carinfo/updateform";
	}
	
	//수정 후 list로 이동
	@PostMapping("/update")
	public String update(@ModelAttribute CarDto dto)
	{
		dao.updateCar(dto);
		return "redirect:list";
	}
	

}
