<%@page import="org.json.simple.JSONObject"%>
<%@page import="guest.GuestDao"%>
<%@page import="guest.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String nickname=request.getParameter("nickname");
	String content=request.getParameter("content");
	String emot=request.getParameter("emot");

	GuestDto dto=new GuestDto();
	dto.setNickname(nickname);
	dto.setContent(content);
	dto.setEmot(emot);
	
	GuestDao dao=new GuestDao();
	dao.insertGuest(dto);
%>