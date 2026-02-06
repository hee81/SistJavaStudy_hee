package board.data;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardDao dao;
	
	//board목록으로
	@GetMapping("/list")
	public ModelAndView board() {
		ModelAndView mv=new ModelAndView();
		
		//dao
		int totalCount=dao.getTotalCount();
		mv.addObject("totalCount", totalCount);
		mv.setViewName("board/boardlist");
		
		return mv;
	}
	
	//글쓰기 버튼 누르면 writeform으로
	@GetMapping("/addform")
	public ModelAndView write() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("board/writeform");
		
		return mv;
	}
	
	//db저장 누르면 insert
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session) {
		
		//업로드 실제 경로
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		
		//파일명에 현재날짜사용(필수아님)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(path);
		
		String photo="";
		if(upload.get(0).getOriginalFilename().equals(""))//사진 선택 안했으면
		{
			photo="no";
		}else {
			for(MultipartFile f:upload) {
				String fName=sdf.format(new Date())+f.getOriginalFilename();
				photo+=fName+",";
				
				//업로드
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			//마지막컴마제거
			photo=photo.substring(0, photo.length()-1);
		}
		//dto에 photo에 넣어주기
		dto.setPhoto(photo);
		
		dao.insertBoard(dto);
		return "redirect:list";
	}

	
}
