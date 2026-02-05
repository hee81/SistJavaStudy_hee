package db.sts.sist;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myshop")
public class MyshopController {
	//db만든거 자동 주입받아야 sql문 연관지어서 forward에 출력가능하다
	@Autowired
	MyshopDao dao;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/myshop/list"; //@GetMapping({"/","myshop/list"}) 보다 안정적임
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MyshopDto> list=dao.getAllSangpums();
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "myshop/list";
	}
	
	//입력폼으로 이동
	@GetMapping("/addform")
	public String form() {
		return "myshop/addform";
	}
	
	//입력폼처리
	@PostMapping("/add")
	//이미지 없으면 아래와 같음, 지금은 db에 photo빼고 입력됨.
	public String insert(@ModelAttribute MyshopDto dto,
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
		
		dao.insertMyshop(dto);
		return "redirect:list"; //myshop/list또 적어주면 오류남!
	}
	
	//디테일로 이동
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam String num) {
		ModelAndView mv=new ModelAndView();
		
		MyshopDto dto=dao.getOneData(num);
		mv.addObject("dto", dto);
		
		mv.setViewName("/myshop/detailview");
		return mv;
	}
	
	//삭제 후 디테일로 이동
	@GetMapping("/del")
	public ModelAndView delete(@RequestParam String num) {
		ModelAndView mv=new ModelAndView();
		
		dao.deleteMyshop(num);
		
		mv.setViewName("redirect:list");
		return mv;
	}
	
	
}
