package db.data.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carmember")
public class CarMemberController {
	
	@Autowired
	CarMemberDao dao;
	
	//list로 이동
	@GetMapping("/list")
	public String mlist(Model model) {
		int totalCount=dao.getTotalCount();
		List<MemberDto> list=dao.getAllDatas();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		
		return "carmember/memberlist";
	}
	
	//writeform 이동
	@GetMapping("/writeform")
	public String wform() {
		return "carmember/writeform";
	}
	
	//insert
	@PostMapping("/write")
	public String insert(MemberDto dto) {
		dao.insertCarMember(dto);
		return "redirect:list";
	}
	
	//updateform이동
	@GetMapping("/updateform")
	public String uform(String num,Model model) {
		MemberDto dto=dao.getOneData(num);
		model.addAttribute("dto", dto);
		return "carmember/updateform";
	}
}
