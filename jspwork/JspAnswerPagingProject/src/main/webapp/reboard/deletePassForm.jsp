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
%>
<body>
<div style="margin: 200px 200px; width: 300px;">
	<form action="deletePassAction.jsp" method="post">
	
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="currentPage" value="<%=currentPage%>">
		
		<table class="table table-boardered">
			<tr>
				<td class="input-group">
					<input type="password" name="pass" class="form-control" 
					style="width: 120px;" placeholder="비밀번호 입력">&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-danger">삭제</button>
				</td>
			</tr>
		</table>
	</form>
</div>
	
</body>
</html>