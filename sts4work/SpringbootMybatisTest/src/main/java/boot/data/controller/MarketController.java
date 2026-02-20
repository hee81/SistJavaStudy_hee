package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MarketDto;
import boot.data.mapper.MarketMapperInter;
import jakarta.servlet.http.HttpSession;

@Controller
public class MarketController {

	@Autowired
	MarketMapperInter mapper;
	
	@GetMapping("/")
	public String start()
	{
		return "redirect:market/list";
	}
	
	@GetMapping("/market/list")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		
		//db로부터 총갯수얻기
		int count=mapper.getTotalCount();
		
		//전체목록얻기
		List<MarketDto> list=mapper.getAllSangpums();
		
		//request에저장
		model.addObject("totalcount", count);
		model.addObject("list", list);
		
		
		//forward
		model.setViewName("marketlist");
		return model;
	}
	
	//입력폼
	@GetMapping("/market/form")
	public String form()
	{
		return "addform";
	}
	
	//insert
	@PostMapping("/market/add")
	public String insert(@ModelAttribute MarketDto dto,
			@RequestParam MultipartFile photo,
			HttpSession session)
	{
		//업로드경로
		String path=session.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals(""))
			dto.setPhotoname(null);
		else {
			
			//사진명앞에 현재날짜 시분초
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setPhotoname(photoname);
			
			//실제업로드
			try {
				photo.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//db에저장
		mapper.insertMarket(dto);
		
		return "redirect:list";
	}
	
	//수정폼
	@GetMapping("/market/updateform")
	public String uform(@RequestParam String num,Model model)
	{
		//num을 넘겨 하나의 dto얻기
		MarketDto dto=mapper.getData(num);
		
		//request에저장
		model.addAttribute("dto", dto);
		//forward
		return "updateform";
	}
	
	//수정
	@PostMapping("/market/update")
	public String update(@ModelAttribute MarketDto dto,
			@RequestParam MultipartFile photo,
			HttpSession session)
	{
		//업로드경로
		String path=session.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals(""))
			dto.setPhotoname("no");
		else {
			
			//수정전에 이전사진지우기
			String pre_photo=mapper.getData(dto.getNum()).getPhotoname();
			
			File file=new File(path+"\\"+pre_photo);
			file.delete(); //파일삭제
			
			
			//사진명앞에 현재날짜 시분초
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setPhotoname(photoname);
			
			//실제업로드
			try {
				photo.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//db에저장
		mapper.updateMarket(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/market/delete")
	public String delete(@RequestParam String num,
			HttpSession session)
	{
		String delphoto=mapper.getData(num).getPhotoname();
		String path=session.getServletContext().getRealPath("/photo");
		
		File file=new File(path+"\\"+delphoto);
		file.delete();//파일삭제
		
		//db삭제
		mapper.deleteMarket(num);
		return "redirect:list";
	}
	
	
}
