<%@page import="javax.security.auth.callback.ConfirmationCallback"%>
<%@page import="intro.IntroDao"%>
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
<body>
	<!-- 비밀번호가 무조건 a1234면 삭제!!! 삭제 후 목록으로 이동하기
	틀리면 경고창!!! 다시입력하기 -->
	<%
		String num=request.getParameter("num");
		String pass=request.getParameter("pass");
		
		IntroDao dao=new IntroDao();
		
		if(pass.equals("a1234"))
		{
			dao.deleteIntro(num);
			response.sendRedirect("introlist.jsp");
		}
		else{%>
			<script type="text/javascript">
				alert("비밀번호가 맞지않습니다")
				history.back();
			</script>
		<%}
	%>
</body>
</html>