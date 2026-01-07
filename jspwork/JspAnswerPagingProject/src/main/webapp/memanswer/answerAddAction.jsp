<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//한글엔코딩
	request.setCharacterEncoding("utf-8");
	//현재페이지
	String currentPage=request.getParameter("currentPage");
%>

	<jsp:useBean id="dto" class="memanswer.AnswerDto"/>
	<jsp:useBean id="dao" class="memanswer.AnswerDao"/>
	<jsp:setProperty property="*" name="dto"/>
	
<%
	//insert
	dao.insertAnswer(dto);

	//guestList로 이동하는데 보던 페이지로 이동
	response.sendRedirect("../memguest/guestList.jsp?currentPage="+currentPage);
%>
