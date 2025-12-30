<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	//세션 존재 확인
	//형변환 필요!!(object>string)
	String study=(String)session.getAttribute("dragon");
	String lang=request.getParameter("lang");
	
	//!study.equals("sist") 필수 아님, null이 무조건 앞에?
	if(study==null || !study.equals("sist"))
	{%>
		<h3 style="color: red;">시간이 초과되었습니다</h3>
	<%}else{%>
		<h3 style="color: blue;;">수강신청이 <%=lang%>과목으로 완료됨!!</h3>
	<%}
%>

<a href="sessionMain.jsp">다시 수강신청하기</a>
</body>
</html>