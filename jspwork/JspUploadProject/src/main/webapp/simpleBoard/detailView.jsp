<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleBoard.BoardDto"%>
<%@page import="simpleBoard.BoardDao"%>
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
<style type="text/css">

</style>
</head>
<%
	//num읽기
	String num=request.getParameter("num");
	//dao선언
	BoardDao dao=new BoardDao();
	//num으로 얻어온 하나의 dto
	BoardDto dto=dao.getOneData(num);
	//조회수 증가
	dao.updateReadcount(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm");

%> 
<body>
<div style="margin: 50px 50px;">
	<table style="width: 800px;" class="table table-condensed">
		<tr>
			<td>
				<h4><%=dto.getSubject() %></h4><br>
				<b><%=dto.getWriter() %></b><br>
				<span><%=sdf.format(dto.getWriteday()) %></span>
				<span>조회 <%=dto.getReadcount() %></span>
			</td>
		</tr>
		<tr>
			<td>
				<!-- 클릭하면 큰 화면으로 보이도록-a -->
				<a href="../save/<%=dto.getImgname()%>" target="_blank">
				<img src="../save/<%=dto.getImgname()%>" style="max-width: 200px;"></a>
				<br><br>
				<%=dto.getContent().replace("\n", "<br>") %>
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" class="btn btn-outline-primary" onclick="location.href='addForm.jsp'">글쓰기</button>
				<button type="button" class="btn btn-outline-success" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
				<button type="button" class="btn btn-outline-warning" onclick="location.href='deletePassForm.jsp?num=<%=dto.getNum()%>'">삭제</button>
				<button type="button" class="btn btn-outline-info" onclick="location.href='boardlist.jsp'">목록</button>
			</td>
		</tr>
	</table>
</div>

</body>
</html>