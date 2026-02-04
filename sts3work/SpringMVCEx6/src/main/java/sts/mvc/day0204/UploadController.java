package sts.mvc.day0204;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	//uploadform1로 이동
	@GetMapping("/uploadform1")
	public String form1() {
		return "upload/uploadform1";
	}	
	//1번 업로드 처리
	@PostMapping("/uploadproc1")
	public ModelAndView upload1(@RequestParam String title,
			@RequestParam MultipartFile photo//form에 multi~~없으면 안뜸,폼네임 쓰면됨
			,HttpServletRequest request
			) {
		
		ModelAndView mv=new ModelAndView();
		
		//업로드 실제경로 구하기
		String realPath=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(realPath);
		
		String fileName=photo.getOriginalFilename();
		
		if(!fileName.equals("")) //파일이 있다면(=업로드 했을 경우)
		{
			try {
				photo.transferTo(new File(realPath+"\\"+fileName)); //transferTo 중요!!! 실제 업로드 시켜주는 메서드(실제경로로 들어가면 이미지 생성됨)
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else {
			fileName="no"; //업로드 안했을 경우
		}
		
		mv.addObject("fileName", fileName);
		mv.addObject("title", title);
		mv.addObject("path", realPath);
		
		mv.setViewName("upload/uploadresult1");
		
		return mv;
	}
	
	
	
	
	
	//uploadform2로 이동
	@GetMapping("/uploadform2")
	public String form2() {
		return "upload/uploadform2";
	}

}
