<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//프론트에서 보낸 데이터 읽어오기
	String image1=request.getParameter("image");
	String fname1=request.getParameter("fname2");
	String score1=request.getParameter("score2");
	
	//프론트형태로 만들어서 front로 보내기
	JSONObject ob=new JSONObject();
	ob.put("food", image1);
	ob.put("name", fname1);
	ob.put("like", score1);
%>
<%=ob.toString()%>