package db.sts.sist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyshopController {
	//db만든거 자동 주입받아야 sql문 연관지어서 forward에 출력가능하다
	@Autowired
	MyshopDao dao;
	
	@GetMapping("/")
	public String list(Model model) {
		List<MyshopDto> list=dao.getAllSangpums();
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "myshop/list";
	}
}
