<%@page import="myinfo.MyInfoDao"%>
<%@page import="myinfo.MyInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<%
	//수정메서드 받아서 처리 후 목록으로 이동
	//엔코딩
	request.setCharacterEncoding("utf-8");
	//데이터 읽기
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	//dto로 묶기
	MyInfoDto dto=new MyInfoDto();
	dto.setNum(num);
	dto.setName(name);
	dto.setAddr(addr);
	//메서드로 호출
	MyInfoDao dao=new MyInfoDao();
	dao.updateMyinfo(dto);
	
	//목록으로 이동
	response.sendRedirect("infolist.jsp");
	
%>
</body>
</html>