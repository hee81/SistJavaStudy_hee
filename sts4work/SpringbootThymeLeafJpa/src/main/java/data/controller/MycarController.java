package data.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dao.MycarDao;
import data.dto.MycarDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //final, @NonNull 인 필드값만 파라메터로 받는 생성자를 생성
public class MycarController {

	private final MycarDao mycardao;
	
	@GetMapping("/")
	public String start() {
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MycarDto> list=mycardao.getAllCars();
		model.addAttribute("list", list);
		model.addAttribute("totalcount", list.size());
		return "mycar/mycarlist";
	}
	
	@GetMapping("/addcar")
	public String form() {
		return "mycar/addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MycarDto dto,
			@RequestParam("carupload") MultipartFile carupload,
			HttpSession session) {
		
		String realPath=session.getServletContext().getRealPath("/carsave");
		System.out.println(realPath);
		
		String uploadName=carupload.getOriginalFilename();
		dto.setCarphoto(uploadName);
		
		try {
			carupload.transferTo(new File(realPath+"\\"+uploadName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db저장
		mycardao.insertMycar(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("num") Long num, Model model) {
		MycarDto dto=mycardao.getData(num);
		model.addAttribute("dto", dto);
		return "mycar/mycardetail";
	}
	
	@GetMapping("/updateform")
	public String upform(@RequestParam("num") Long num, Model model) {
		MycarDto dto=mycardao.getData(num);
		model.addAttribute("dto", dto);
		return "mycar/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MycarDto dto,
			@RequestParam("carupload") MultipartFile carupload,
			HttpSession session) {
		
		String realPath=session.getServletContext().getRealPath("/carsave");
		System.out.println(realPath);
		
		String uploadName=carupload.getOriginalFilename();
		dto.setCarphoto(uploadName);
		
		try {
			carupload.transferTo(new File(realPath+"\\"+uploadName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db수정
		mycardao.updateMycar(dto);
		
		return "redirect:detail?num="+dto.getNum();
	}
	
	//delete
	@GetMapping("/delete")
	public String delete(@RequestParam("num") Long num) {
		return "redirect:list";
	}
}
