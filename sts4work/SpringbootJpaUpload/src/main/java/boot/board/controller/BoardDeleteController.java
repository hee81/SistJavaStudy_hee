package boot.board.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.board.data.BoardDao;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardDeleteController {
	@Autowired
	BoardDao dao;
	
	//delete
	@GetMapping("/board/delete")
	public String delete(@RequestParam long num,
			HttpSession session) {
		//boardsave폴더 사진삭제
		String oldphoto=dao.getOneData(num).getPhoto();
		if(!oldphoto.equals("no")) {
			String path=session.getServletContext().getRealPath("/boardsave");
			File file=new File(path+"\\"+oldphoto);
			file.delete();
		}
		dao.deleteBoard(num);
		return "redirect:list";
	}
}
