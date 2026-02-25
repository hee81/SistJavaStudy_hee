package boot.data.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import jakarta.servlet.http.HttpSession;

@RestController
public class AjaxLoginController {

	@Autowired
	MemberService service;
	
	@GetMapping("/member/login") //loginform 하면 동기가 뜸!
	public Map<String, String> loginproc(@RequestParam String id,@RequestParam String pass,HttpSession session){
		
		//json형태로 return받기 위해서 map 사용!!!!!
		Map<String, String> map=new HashMap<>();
		map.put("id", id);
		map.put("pass", pass);
		
		//로그인상태인지 아닌지
		int check=service.loginCheck(id, pass);
		if(check==1) {
			session.setMaxInactiveInterval(60*60*8);
			session.setAttribute("myid", id);
			session.setAttribute("loginok", "yes");
			//session에 dto 맴버값 저장하면 편함
			MemberDto mdto=service.getDataById(id);
			session.setAttribute("loginphoto", mdto.getPhoto());
			session.setAttribute("loginname", mdto.getName());	
		}
		map.put("result", check==1?"success":"fail");
		return map;		
	}
	
	@GetMapping("/member/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
	}
}
