<%@page import="member.MemberDao"%>
<%@page import="member.MemberDto"%>
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

	//입력값 읽기
	String name=request.getParameter("name");
	String hp=request.getParameter("hp");
	String driver=(request.getParameter("driver")==null?"없음":"있음");
	String jop=request.getParameter("jop");
	
	//dto
	MemberDto dto=new MemberDto();
	dto.setName(name);
	dto.setHp(hp);
	dto.setDriver(driver);
	dto.setJop(jop);
	//입력값 읽어서 dto에 바로 담기 가능
	dto.setNum(request.getParameter("num"));
	
	//dao
	MemberDao dao=new MemberDao();
	dao.updateMember(dto);
	
	//목록으로 이동
	response.sendRedirect("memberlist.jsp");
%>



<%-- 
<!-- 자바빈즈로 변경해보기 -->

<%
	request.setCharacterEncoding("utf-8");
%>

<!--  MemberDao dao=new MemberDao()와 같음 -->
	<jsp:useBean id="dao" class="member.MemberDao"/>
	<jsp:useBean id="dto" class="member.MemberDto"/>
<!-- request로 받아서 set하는 것과 같음 -->
	<jsp:setProperty property="*" name="dto"/>

<%
	response.sendRedirect("memberlist.jsp");
%>

--%>


<body>

</body>
</html>