<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="guest.GuestDto"%>
<%@page import="guest.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String num=request.getParameter("num");

	GuestDao dao=new GuestDao();

	GuestDto dto=dao.getOneData(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	JSONObject ob=new JSONObject();
	
	ob.put("num", dto.getNum());
	ob.put("nickname", dto.getNickname());
	ob.put("content", dto.getContent());
	ob.put("emot", dto.getEmot());
	ob.put("writeday", sdf.format(dto.getWriteday()));
	
%>
<%=ob.toString()%>