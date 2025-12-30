<%@page import="myboard.BoardAnswerDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myboard.BoardAnswerDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String idx=request.getParameter("idx");
	
	BoardAnswerDao dao=new BoardAnswerDao();
	BoardAnswerDto dto=dao.getOneAnswer(idx);
	
	JSONObject ob=new JSONObject();
	ob.put("idx", dto.getIdx());
	ob.put("nickname", dto.getNickname());
	ob.put("comment", dto.getComment());
	
%>
<%=ob.toString()%>