<%@page import="reboard.ReboardDao"%>
<%@page import="reboard.ReboardDto"%>
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
	String currentPage=request.getParameter("currentPage");
	
	//num에 해당하는 dao 불러오기
	ReboardDao dao=new ReboardDao();
	ReboardDto dto=dao.getData(num);
	
%>
<body>
	<div style="margin: 100px 200px; width: 500px;">
		<form action="updateAction.jsp" method="post">
		
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="currentPage" value="<%=currentPage%>">
		
			<table class="table table-bordered">
				<!-- 삼항연산자로 테이블제목 구분 -->
				<caption align="top"><b>게시글수정</b></caption>
				<tr>
					<th class="table-success">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control" style="width: 320px;" required="required" value="<%=dto.getWriter()%>">
					</td>
				</tr>
				<tr>
					<th class="table-success">제목</th>
					<td>
						<input type="text" name="subject" class="form-control" style="width: 320px;" required="required" value="<%=dto.getSubject()%>">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<textarea style="width: 480px; height: 100px;" name="content" class="form-control" 
						placeholder="자유롭게 게시글을 남겨주세요~"><%=dto.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success">게시글수정</button>
						<input type="button" class="btn btn-success" value="목록이동" onclick="location.href='boardList.jsp?num=<%=num%>&currentPage=<%=currentPage%>'">
					</td>
				</tr>
			</table>
			
		</form>
		
	</div>
</body>
</html>