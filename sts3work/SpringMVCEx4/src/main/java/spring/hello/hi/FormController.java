package spring.hello.hi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("/login/form")
	public String form() {
		return "form";
	}
	
	@GetMapping("/login/read")
	public String process(Model model,@RequestParam("myid") String id, @RequestParam(value = "mypass") String pass) {
		
		model.addAttribute("id", id);
		
		String msg="";
		if(pass.equals("1234"))
			msg="로그인성공!!!";
		else
			msg="로그인실패!!!";
		model.addAttribute("loginmsg", msg);
		 
		return "result";
	}
	
}
