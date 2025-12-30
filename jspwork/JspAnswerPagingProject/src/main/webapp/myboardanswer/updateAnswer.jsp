<%@page import="myboard.BoardAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

	<jsp:useBean id="dto" class="myboard.BoardAnswerDto"></jsp:useBean>
	<jsp:useBean id="dao" class="myboard.BoardAnswerDao"></jsp:useBean>
	
	<jsp:setProperty property="*" name="dto"/>
	
<%
	dao.updateAnswer(dto);
%>