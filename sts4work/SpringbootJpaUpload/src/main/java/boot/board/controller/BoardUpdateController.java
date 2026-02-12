package boot.board.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.board.data.BoardDao;
import boot.board.data.BoardDto;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardUpdateController {

	@Autowired
	BoardDao dao;
	
	//updateform
	@GetMapping("/board/updateform")
	public ModelAndView upform(@RequestParam long num) {
		ModelAndView mv=new ModelAndView();
		BoardDto dto=dao.getOneData(num);
		mv.addObject("udto", dto);
		mv.setViewName("updateform");
		return mv;
	}
	
	//update
	@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		//기존 사진 불러오기
		String oldphoto=dao.getOneData(dto.getNum()).getPhoto();
		//새로운 사진 업로드 확인
		if(!upload.isEmpty()) {
			//사진이 변경되면 기존 사진 삭제처리하기
			if(oldphoto != null && !oldphoto.equals("no")) {
				String path=session.getServletContext().getRealPath("/boardsave");
				File file=new File(path+"\\"+oldphoto);
				if(file.exists())
					file.delete();
			}
			//새 사진 파일 저장
			String path=session.getServletContext().getRealPath("/boardsave");
			String newphoto=upload.getOriginalFilename();
			dto.setPhoto(newphoto);
			try {
				upload.transferTo(new File(path+"\\"+newphoto));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			//업데이트X 기존사진 유지
			dto.setPhoto(oldphoto);
		}
		
		dao.updateBoard(dto);
		return "redirect:detail?num="+dto.getNum();
	}
}	
