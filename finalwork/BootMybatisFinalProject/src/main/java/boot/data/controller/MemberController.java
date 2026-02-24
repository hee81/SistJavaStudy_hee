package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

    private final BoardController boardController;
	
	@Autowired
	MemberService service;

    MemberController(BoardController boardController) {
        this.boardController = boardController;
    }

	@GetMapping("/member/list")
	public String memberlist(Model model) {
		List<MemberDto> list=service.getAllMemebers();
		model.addAttribute("list", list);
		model.addAttribute("totalcount", list.size());
		return "member/memberlist";
	}
	
	@GetMapping("/member/form")
	public String memberform() {
		return "member/memberform";
	}
	
	//id체크
	//value값을 key값으로 넘겨야함!! Map사용!!!
	//http://localhost:9001/member/idcheck?id=yeon 로 확인하기!! db에 값이 있어야 확인 가능
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idCheckProcess(@RequestParam String id){
		Map<String, Integer> map=new HashMap<>();
		
		int n=service.getSearchId(id);
		map.put("checkcount", n); //출력값 0 아니면 1
		
		return map;
	}
	
	//insert 후 list로
	@PostMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto,MultipartFile myphoto,HttpSession session) {
		
		service.insertMember(dto, myphoto, session);
		
		//return "rediect:list";
		return "member/gaipsuccess";
	}
	
	//내 정보로 가기
	@GetMapping("/member/myinfo")
	public String myinfo(Model model) {
		List<MemberDto> list=service.getAllMemebers();
		model.addAttribute("list", list);
		return "member/myinfo";
	}
	
	//delete(ajax) 후 list로
	@GetMapping("/member/delete")
	@ResponseBody
	public void delete(@RequestParam String num) {
		service.deleteMember(num);
	}
	
	//myinfo에서 사진만 변경하기 ajax
	@PostMapping("/member/updatephoto")
	@ResponseBody
	public void updatephotoupload(@RequestParam String num,MultipartFile photo,HttpSession session) {
		String path=session.getServletContext().getRealPath("/membersave");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=sdf.format(new Date())+"_"+photo.getOriginalFilename();
		try {
			photo.transferTo(new File(path+"\\"+fileName));
			service.updatePhoto(num, fileName); //db사진 수정~
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
