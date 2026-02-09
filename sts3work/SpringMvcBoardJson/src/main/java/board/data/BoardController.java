package board.data;

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
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardDao dao;
	
	//board목록으로
	@GetMapping("/list")
	public ModelAndView list(
			@RequestParam(value="currentPage",defaultValue = "1") int currentPage //현재페이지 읽기
			) {
		ModelAndView mv=new ModelAndView();
		
		//페이징에 필요한 변수들
		  int totalCount=dao.getTotalCount(); //전체갯수
		  int perPage=5; //한페이지에 보여질 글갯수
		  int perBlock=5; //한블럭에 보여질 페이지갯수
		  int startNum; //db에서 가져올 글의 시작번호(mysql이므로 첫글이 0,오라클은 1)
		  int startPage; //각블럭당 보여질 시작페이지
		  int endPage; ////각블럭당 보여질 끝페이지
		  int totalPage; //총페이지
		  
		  int no; //각페이지당 출력할 시작번호
		   
		  //총페이지구하기
		  //총페이지갯수/한페이지에 보여질 갯수로 나눔(7/5=1)
		  //나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지 필요)
		 	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1); 
		  
		  //각블럭당 보여질 시작페이지
		  //perBlock=5일경우 현재페이지 1~5일경우는 시작페이지1,끝5
		  //만약 현재페이지가 13 시작:11  끝:15
		  startPage=(currentPage-1)/perBlock*perBlock+1;
		  endPage=startPage+perBlock-1; 
		  
		  //총페이지갯수가 23일경우 마지막 25가 아니라 23
		  if(endPage>totalPage)
			  endPage=totalPage;
		  
		  //각페이지에서 보여질 시작번호(5개의 글을 한페이지)
		  //예: 1페이지->0  2페이지: 5  3페이지:10.. 
		  startNum=(currentPage-1)*perPage;
		  
		  no=totalCount-(currentPage-1)*perPage;
		  
		  //페이지에서 보여질 글만 가져오기
		  //List<BoardDto> list=dao.getPagingList(startNum, perPage);
		  List<BoardDto> list=dao.getPagingList(startNum, perPage);

		//request
		mv.addObject("list", list);
		mv.addObject("totalCount", totalCount);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		mv.addObject("totalPage", totalPage);
		mv.addObject("no", no);
		mv.addObject("currentPage", currentPage);
		
		//forward
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
	
	//제목 누르면 content로
	@GetMapping("/detail")
	public String content(Model model,int num,int currentPage) {
		//조회수증가
		dao.updateReadCount(num);
		//dto리턴
		BoardDto dto=dao.getOneData(num);
		//값 넘기기
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		return "board/content";
	}
	
	//삭제pass폼으로
	@GetMapping("/dpassform")
	public String delete(Model model,String num,String currentPage) {
		model.addAttribute("num", num);
		model.addAttribute("currentPage", currentPage);
		return "board/deletepassform";
	}
	
	//삭제-비밀번호 check
	@PostMapping("/deletepass")
	public ModelAndView delete(@RequestParam int num,
			@RequestParam int pass,
			@RequestParam int currentPage,
			HttpSession session) {
		ModelAndView mv=new ModelAndView();
		
		int pcheck=dao.getCheckPass(num, pass);
		
		if(pcheck==0) {
			mv.setViewName("board/passfail");
		}else {
			
			//photo폴더 사진삭제
			String oldphoto=dao.getOneData(num).getPhoto();
			if(!oldphoto.equals("no")) {
				//,로 분리해서 배열에 담기
				String [] fName=oldphoto.split(",");
				//실제업로드
				String path=session.getServletContext().getRealPath("/WEB-INF/photo");
				
				for(String f:fName) {
					File file=new File(path+"\\"+f);
					file.delete();
				}
			}
			
			dao.deleteBoard(num);
			mv.setViewName("redirect:list");
		}
		return mv;
	}
	

	
	//수정pass폼으로
	@GetMapping("/upassform")
	public String uppassform(Model model,String num,String currentPage) {
		model.addAttribute("num", num);
		model.addAttribute("currentPage", currentPage);
		return "board/updatepassform";
	}
	
	//비밀번호check
	@PostMapping("/updatepass")
	public ModelAndView updatapass(@RequestParam int num, @RequestParam int pass, @RequestParam int currentPage) {
		ModelAndView mv=new ModelAndView();
		
		int check=dao.getCheckPass(num, pass);
		//비번 맞을경우 수정폼으로 포워드
		if(check==1) {
			//dto얻어서 포워드
			BoardDto dto=dao.getOneData(num);
			mv.addObject("dto", dto);
			mv.addObject("currentPage", currentPage);
			mv.setViewName("board/updateform");
		}else{ //틀리면 passfail
			mv.setViewName("board/passfail");
		}

		return mv;
	}
	
	//수정
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session,
			@RequestParam String currentPage) {
		
		//업로드 실제 경로
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		
		//파일명에 현재날짜사용(필수아님)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(path);
		
		String photo="";
		if(upload.get(0).getOriginalFilename().equals(""))//사진 선택 안했으면
		{
			photo=null;
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
		
		dao.updateBoard(dto);
		//수정 후 디테일로
		return "redirect:detail?num="+dto.getNum()+"&currentPage="+currentPage;
	}
	

	

	
}
