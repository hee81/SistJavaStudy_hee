<%@page import="memguest.MemGuestDao"%>
<%@page import="memguest.MemGuestDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//save폴더의 실제 서버위치 구하기
	String realPath=getServletContext().getRealPath("/save");
	System.out.println(realPath);
	
	//업로드 할 이미지 크기제한
	int uploadSize=1024*1024*3; //3mb로 제한
	
	MultipartRequest multi=null;
	
	try{
		//cos.jar 있어야한다! 왜?
		multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
		
		String myid=multi.getParameter("myid");
		String photo=multi.getFilesystemName("photo");
		System.out.println("photo="+photo); //이미지 선택안하면 null
		String content=multi.getParameter("content");
		
		//dto
		MemGuestDto dto=new MemGuestDto();
		dto.setMyid(myid);
		dto.setPhoto(photo==null?"no":photo);
		dto.setContent(content);
		
		//dao
		MemGuestDao dao=new MemGuestDao();
		dao.insertGuest(dto);
		
		response.sendRedirect("guestList.jsp");
		
	} catch(Exception e){
		
	}
%>