package board.answer.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AnswerController {
	@Autowired
	AnswerDao adao;
	
	//¥Ò±€√ﬂ∞°
	@PostMapping("/board/ainsert")
	public String insertA(@ModelAttribute AnswerDto adto,
			@RequestParam String currentPage) {
		
		adao.insertAnswer(adto);
		
		
		return "redirect:detail?num="+adto.getNum()+"&currentPage="+currentPage;
	}
}
