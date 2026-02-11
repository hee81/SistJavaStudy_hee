<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>carlist</title>
</head>
<body>
<div style="margin: 100px 100px;">
	<img alt="" src="../image/flower_ani/s6.JPG" width="100">


	<button type="button" class="btn btn-info" onclick="location.href='addform'">정보입력</button>
	<br><br>
	<b>총 ${count }개의 자동차정보가 있습니다</b>
	
	<table class="table table-bordered" style="width: 600px;">
		<tr class="table-secondary">
			<th>번호</th>
			<th>자동차명</th>
			<th>차량색상</th>
			<th>가격</th>
			<th>구입일자</th>
			<th>편집</th>
		</tr>
		<c:forEach items="${list }" var="dto" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${dto.carname }</td>
				<td>
					<div style="background-color: ${dto.carcolor }; border-radius: 10px; color:${dto.carcolor }">색상</div>
				</td>
				<td>${dto.carprice }</td>
				<td>${dto.guipday }</td>
				<td>
					<button type="button" class="btn btn-secondary btn-sm" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-danger btn-sm" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>