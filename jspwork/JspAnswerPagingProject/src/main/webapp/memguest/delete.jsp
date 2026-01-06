<%@page import="java.io.File"%>
<%@page import="memguest.MemGuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	String num=request.getParameter("num");
	String currentPage=request.getParameter("currentPage");
	//String photo=request.getParameter("photo");

	//dao
	MemGuestDao dao=new MemGuestDao();
	
	
	//파일삭제
	//num에 해당하는 photo값 얻기
	String photo=dao.getOneData(num).getPhoto();
	//save의 실제경로 구하기
	String realPath=getServletContext().getRealPath("/save");
	//파일생성
	File file=new File(realPath+"\\"+photo);
	//해당 폴더에서 파일삭제
	file.delete();
	//db삭제(꼭 파일삭제 후 !!)
	dao.deleteGuest(num);
	
	//삭제후 해당페이지로 이동
	response.sendRedirect("guestList.jsp?currentPage="+currentPage);
%>
</body>
</html>