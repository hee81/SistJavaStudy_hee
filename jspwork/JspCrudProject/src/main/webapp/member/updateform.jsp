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
	String num=request.getParameter("num");
	MemberDao dao=new MemberDao();
	MemberDto dto=dao.getOneData(num);
%>
<body>
<div style="width: 500px; margin: 50px 100px;">
	<form action="updateaction.jsp" method="post">
		<table class="table table-bordered">
			<caption align="top"><b>동아리정보 수정</b></caption>
			<tr>
				<th width="100" class="table-success">회원명</th>
				<td>
					<input type="text" name="name" class="form-control" style="width: 120px" value="<%=dto.getName()%>">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-success">연락처</th>
				<td>
					<input type="text" name="hp" class="form-control" style="width: 180px" value="<%=dto.getHp()%>">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-success">운전면허</th>
				<td>
					<input type="checkbox" name="driver" <%=dto.getDriver().equals("있음")?"checked":"" %>>있음
				</td>
			</tr>
			<tr>
				<th width="100" class="table-success">직업</th>
				<td>
					<input type="text" name="jop" class="form-control" style="width: 120px" value="<%=dto.getJop()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="num" value="<%=num%>">
					<button type="submit" class="btn btn-outline-warning">수정</button>
					<button type="button" class="btn btn-outline-success" onclick="location.href='memberlist.jsp'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>