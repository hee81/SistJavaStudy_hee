package boot.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.board.data.BoardDao;
import boot.board.data.BoardDto;

@Controller
public class BoardListController {
	@Autowired
	BoardDao dao;
	
	//home
	@GetMapping("/")
	public String home() {
		return "redirect:board/list";
	}
	
	//list
	@GetMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		List<BoardDto> list=dao.getAllDatas();
		mv.addObject("list", list);
		mv.addObject("count", list.size());
		mv.setViewName("boardlist");
		return mv;
	}
	
	//detailpage
	@GetMapping("/board/detail")
	public ModelAndView detailpage(@RequestParam long num) {
		ModelAndView mv=new ModelAndView();
		BoardDto dto=dao.getOneData(num);
		mv.addObject("dto", dto);
		mv.setViewName("detailpage");
		return mv;
	}

}
