<%@page import="login.LoginDao"%>
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
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String save=request.getParameter("save");
	
	//아이디와 비번 일치 확인
	LoginDao dao=new LoginDao();
	boolean flag=dao.isLogIn(id, pass);
	
	if(flag){
		
		//☆제일중요☆로그인 여부를 세션에 저장
		session.setAttribute("loginok", "yes");
		//아이디와 체크값 세션에 저장
		session.setAttribute("idok", id);
		//아이디 체크값 : 체크하면 on, 체크안하면 null_여기서 삼항연산자 가능(받는곳에서 해도됨)
		session.setAttribute("save", save);
		
		//세션유지시간
		session.setMaxInactiveInterval(60*60*8); //8시간
	
		//로그인 메인으로 이동(원래는 로그아웃폼)
		response.sendRedirect("loginMain.jsp");
		
	}else{%>
		<script type="text/javascript">
			alert("아이디와 비밀번호가 맞지 않습니다.");
			history.back();
		</script>	
	<%}
%>
</body>
</html>