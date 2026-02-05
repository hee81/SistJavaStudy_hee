<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	총 ${totalCount }개의 자동차 정보가 있습니다.
	<br>
	<button type="button" class="btn btn-secondary" onclick="location.href='writeform'">자동차정보입력</button>

	<!-- 번호		자동차명	차량색상	가격	구입일자 -->
		<table class="table table-bordered" style="width: 600px;">
			<tr>
				<th>번호</th>
				<th>자동차명</th>
				<th>차량색상</th>
				<th>가격</th>
				<th>구입일자</th>
				<th>편집</th>
			</tr>
			<c:forEach items="${list }" var="c" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${c.carname }</td>
				<td style="color: ${c.carcolor }">${c.carcolor }</td>
				<td>${c.carprice }</td>
				<td>${c.carguip }</td>
				<td>
					<button type="button" class="btn btn-outline-info btn-sm" onclick="location.href='updateform?num=${c.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='delete?num=${c.num}'">삭제</button>
				</td>
			</tr>
			</c:forEach>
		</table>
	
</body>
</html>