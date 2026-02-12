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

import boot.board.data.BoardDao;
import boot.board.data.BoardDaoInter;
import boot.board.data.BoardDto;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardInsertController {

    private final BoardDaoInter boardDaoInter;
	
	@Autowired
	BoardDao dao;

    BoardInsertController(BoardDaoInter boardDaoInter) {
        this.boardDaoInter = boardDaoInter;
    }
	
	//writeform으로
	@GetMapping("/board/addform")
	public String form() {
		return "writeform";
	}
	
	//insert
	@PostMapping("/board/write")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		
		//실제경로
		String realPath=session.getServletContext().getRealPath("/boardsave");
		System.out.println(realPath);
		
		//파일을 실제경로에 업로드 시키고 그 파일명을 dto의 photo에 저장
		//사진 안 넣으면 'no' or null
		String uploadName=upload.getOriginalFilename();
		if(upload.isEmpty())
			dto.setPhoto("no");
		else {
			dto.setPhoto(uploadName);
			//실제 사진 업로드!
			try {
				upload.transferTo(new File(realPath+"\\"+uploadName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//db에 저장
		dao.insertBoard(dto);
		
		return "redirect:list";
	}
}
