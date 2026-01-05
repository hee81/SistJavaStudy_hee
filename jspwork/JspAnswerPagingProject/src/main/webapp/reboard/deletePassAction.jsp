<%@page import="reboard.ReboardDao"%>
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
	//수정폼에서 넘긴 3개받아서
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	String currentPage=request.getParameter("currentPage");
	
	//num,pass로는 비번이 맞는지 체크
	//맞으면 수정폼이동(num,currentPage) 틀리면 경고창
	ReboardDao dao=new ReboardDao();
	
	boolean Password=dao.isEqualPass(num, pass);
	
	if(Password)
	{
		dao.deleteReboard(num);
		response.sendRedirect("boardList.jsp?num="+num+"&currentPage="+currentPage);
	}
	else
	{%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.")
			history.back();
		</script>
	<%}

%>
</body>
</html>