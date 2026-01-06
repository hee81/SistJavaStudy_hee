<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

	<jsp:useBean id="dto" class="memanswer.AnswerDto"/>
	<jsp:useBean id="dao" class="memanswer.AnswerDao"/>
	<jsp:setProperty property="*" name="dto"/>
	
<%
	dao.insertAnswer(dto);
%>
