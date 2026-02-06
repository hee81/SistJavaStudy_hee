<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<h5>list페이지</h5>
	<button type="button" class="btn btn-outline-info" onclick="location.href='writeform'">회원등록</button><br>
	
	<c:if test="${totalCount==0 }">
		${totalCount }명
	</c:if>
	<c:if test="${totalCount>0 }">
		${totalCount }명입니다.
	</c:if>
	
	<table class="table table-bordered" style="width: 700px;">
		<caption align="top">회원목록</caption>
		<tr>
			<th>회원번호</th>
			<th>회원명</th>
			<th>연락처</th>
			<th>주소</th>
			<th>가입일</th>
			<th>편집</th>
		</tr>
		<c:forEach items="${list }" var="cmlist" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${cmlist.name }</td>
				<td>${cmlist.hp }</td>
				<td>${cmlist.addr }</td>
				<td><fmt:formatDate value="${cmlist.gaipday }" pattern="yyyy-MM-dd HH:mm"/></td>
				<td colspan="2">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='updateform?num=${cmlist.num}'">수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${cmlist.num}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>