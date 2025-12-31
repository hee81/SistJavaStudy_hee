<%@page import="java.text.SimpleDateFormat"%>
<%@page import="reboard.ReboardDto"%>
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
<%
	String num=request.getParameter("num");
	//dao
	ReboardDao dao=new ReboardDao();
	//선택한 데이터 dto로 가져오기
	ReboardDto dto=dao.getData(num);
	//조회수메서드
	dao.updateReadCount(num);
	//날짜출력
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
	<div style="margin: 100px 200px; width: 600px;">
		<table class="table table-bordered">
			<tr>
				<td>
					<h4><b><%=dto.getSubject() %></b></h4>
					<span><b><%=dto.getWriter() %></b></span>
					<span><%=sdf.format(dto.getWriteday()) %></span>
					<span>조회: <%=dto.getReadcount() %></span>
				</td>
			</tr>
			<tr height="200px;">
				<td>
					<pre><%=dto.getContent() %></pre>
				</td>
			</tr>
			<tr>
				<td align="right">
					<button type="button" class="btn btn-outline-info" onclick="location.href='addForm.jsp'">글쓰기</button>
					<button type="button" class="btn btn-outline-info" 
					onclick="location.href='addForm.jsp?num=<%=num%>&regroup=<%=dto.getRegroup()%>&restep=<%=dto.getRestep()%>&relevel=<%=dto.getRelevel()%>'">답글</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href=''">수정</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href=''">삭제</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href='boardList.jsp'">목록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>