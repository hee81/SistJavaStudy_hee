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
	String name=request.getParameter("name");
	String lunch=request.getParameter("lunch");
	String [] itlan=request.getParameterValues("itlan");
%>
<body>

	이름: <%=name %><br>
	오늘 점심메뉴: <img src="<%=lunch %>" width="100"><br>
	가능한 IT언어는 
	<%
		if(itlan==null)
		{%>
			없습니다.
		<%}
		else
		{
			for(String lg:itlan)
			{%>
				[<%=lg %>]&nbsp; &nbsp;
			<%}
		}
	%>
	<br>

</body>
</html>