<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myboard.BoardDto"%>
<%@page import="myboard.BoardDao"%>
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
<style type="text/css">
	table.detail{
		width: 400px;
		margin: 50px 50px;
	}
	caption{
		color: black;
		font-size: 1.5em;
	}
</style>
</head>
<% 
	String num=request.getParameter("num");

	BoardDao dao=new BoardDao();
	dao.updateReadCount(num);
	BoardDto dto=dao.getOneData(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
<div>
	<table class="table table-bordered detail">
		<caption align="top"><%=dto.getSubject() %></caption>
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span><%=sdf.format(dto.getWriteday()) %></span> &nbsp;&nbsp;
				<span>조회: <%=dto.getReadcount() %></span> 
			</td>
		</tr>
		<tr>
			<td><%=dto.getContent().replace("\n", "<br>")%></td>
		</tr>
		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='insertForm.jsp'">글쓰기</button>	
				<button type="button" class="btn btn-outline-success" onclick="location.href='updatePassForm.jsp?num=<%=dto.getNum()%>'">수정</button>
				<button type="button" class="btn btn-outline-danger" onclick="location.href='deletePassForm.jsp?num=<%=dto.getNum()%>'">삭제</button>
				<button type="button" class="btn btn-outline-info" onclick="location.href='boardlist.jsp'">목록</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>