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
<title>detailpage</title>
</head>
<body>
<div style="margin: 100px 100px;">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<td>
					<span style="font-size: 2em;">${dto.subject }</span><br>
					<span >${dto.writer }</span>
					<span><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/> <span>
				</td>
			</tr>
			<tr>
				<td>
					<pre>${dto.content }</pre>
					<img alt="" src="../boardsave/${dto.photo }">
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" class="btn btn-outline-success" onclick="location.href='addform'">글쓰기</button>
					<button type="button" class="btn btn-outline-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href='list'">목록</button>
				</td>
			</tr>
		</table>
</div>
</body>
</html>