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
<title>shoplist</title>
<style type="text/css">
	.img{
	width: 50px;
	}
</style>
</head>
<body>
<div>
	<button type="button" class="btn btn-outline-info" onclick="location.href='shop'">상품등록</button>
	<h4>총 ${count }개의 상품이 있습니다</h4>
	<table class="table table-bordered" style="width: 600px;">
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>이미지</th>
			<th>구입일</th>
			<th>편집</th>
		</tr>
		<c:forEach items="${list }" var="dto" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${dto.sangpum }</td>
				<td><fmt:formatNumber value="${dto.price }" type="currency"/></td>
				<td><img src="../image/logoImg/${dto.photo }" class="img"></td>
				<td>${dto.ipgoday }</td>
				<td>
					<button type="button" class="btn btn-outline-success" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</div>
</body>
</html>