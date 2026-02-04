package sts.mvc.day0204;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board") //매번 /board 매핑 안해도됨
public class BoardController {
	
	//폼 누르면 writeform으로
	@GetMapping("/form1")
	public String form() {
		return "board/writeform";
	}
	
	//데이터 result에서 출력
	@PostMapping("/process")
	//required는 기본이 true, 항목이 없는데 에러가 안나게 하려면 true
	//int는 오류남 > defaultValue 사용하기
	public ModelAndView p(@RequestParam("name") String pname, @RequestParam String date, @RequestParam String gender, 
			@RequestParam(defaultValue = "1") int currentPage //@RequestParam(required = false) String currentPage
			,@RequestParam(defaultValue = "초기메세지") String msg //@RequestParam(required = "false") String msg
			) {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("pname", pname);
		mv.addObject("pdate", date);
		mv.addObject("pgender", gender);
		mv.addObject("currentPage", currentPage);
		mv.addObject("msg", msg);
		
		mv.setViewName("board/result");
		return mv;
	}
	
	//css테스트 누르면 result2로 이동
	@GetMapping("/result2")
	public String r2(Model model) {
		model.addAttribute("myimg1", "../image/Food/1.jpg");
		model.addAttribute("likefood", "내가 좋아하는 음식");
		return "board/result2";
	}
	
	
}
