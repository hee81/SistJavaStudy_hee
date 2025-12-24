<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ajaxboard.AjaxDto"%>
<%@page import="ajaxboard.AjaxDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//num읽기
	String num=request.getParameter("num");
	//dao생성
	AjaxDao dao=new AjaxDao();
	//getData메서드 받기
	AjaxDto dto=dao.getOneData(num);
	//날짜타입 문자열지정
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//dto를 json으로 변환
	JSONObject ob=new JSONObject();
	//json에 데이터 추가하기
	ob.put("num", dto.getNum());
	ob.put("writer", dto.getWriter());
	ob.put("subject", dto.getSubject());
	ob.put("content", dto.getContent());
	ob.put("avata", dto.getAvata());
	ob.put("writeday", sdf.format(dto.getWriteday()));
	
%>
<%=ob.toString()%>