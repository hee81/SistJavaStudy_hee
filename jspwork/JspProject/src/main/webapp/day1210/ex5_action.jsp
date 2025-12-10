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
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("s_name");
	String area=request.getParameter("cbarea");
	String date=request.getParameter("ipsaday");
	String lunch=request.getParameter("lunch");
	String [] lang=request.getParameterValues("lang");
	String gift=request.getParameter("gift");
	String bgColor=request.getParameter("bgColor");
%>
<body>
<div style="background-color: <%=bgColor%>">
	<h3><b><%=name %></b>사원의 선택결과</h3><br>
	<h3>해외근무여부: <%=area==null?"불가능":"가능" %></h3><br>
	<h3>입사일자: <%=date %></h3><br>
	<h3>가장 좋았던 점심메뉴: <img src="../image/Food/<%=lunch %>.jpg" width="100"></h3><br>
	<h3>가능한 언어: <%
		if(lang==null)
		{%>
			없습니다<br>
		<%}
		else
		{
			for(String lg:lang)
			{%>
				[<%=lg %>]&nbsp;
			<%}%>
			<br>
		<%}
	%></h3>
	<h3>받고싶은 명절선물: <img src="<%=gift %>" width="100"></h3><br>
</div>
	
</body>
</html>