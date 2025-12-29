<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myboard.BoardAnswerDto"%>
<%@page import="java.util.List"%>
<%@page import="myboard.BoardAnswerDao"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");
	
	BoardAnswerDao dao=new BoardAnswerDao();
	List<BoardAnswerDto> list=dao.getAllAnswers(num);
	
	JSONArray arr=new JSONArray();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	/* for(int i=0;i<list.size();i++) */
	for(BoardAnswerDto dto:list)
	{
		/* BoardAnswerDto dto=list.get(i); */
		
		JSONObject ob=new JSONObject();
		ob.put("idx", dto.getIdx());
		ob.put("num", dto.getNum());
		ob.put("nickname", dto.getNickname());
		ob.put("comment", dto.getComment());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr.toString()%>