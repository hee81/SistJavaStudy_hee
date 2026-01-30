<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- jstl은 라이브러리이기에 사용하기전에 core를 hearder에 추가해주어야 함 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

	<!-- 한글 엔코딩 -->
	<fmt:requestEncoding value="utf-8"/>
	
	<form action="ex2_jstlTag.jsp" method="post">
		<h3>이름을 입력해주세요</h3>
		<input type="text" name="irum" class="from-control" style="width: 200px;">
		<h3>배우고 싶은 IT언어는?</h3>
		<input type="text" name="lang" class="from-control" style="width: 300px;">
		<br><br>
		<button type="submit" class="btn btn-success">결과확인</button>
	</form>
	
	<!-- 이름을 입력해야 결과가 나옴 -->
	<!-- c:if는 /로 닫아주면 안됨! -->
	<c:if test="${!empty param.irum }">
	
		<h3>이름: ${param.irum }</h3>
		<h3>이름: ${irum }</h3>
		<h3>희망언어: ${param.lang }</h3>
		
		<c:choose>
			<c:when test="${param.lang=='스프링' }">
				<h3 style="color: blue;">스프링은 백엔드 개발입니다_1달과정</h3>
			</c:when>
			<c:when test="${param.lang=='자바' }">
				<h3 style="color: blue;">자바 백엔드 기초입니다_방특과정</h3>
			</c:when>
			<c:when test="${param.lang=='오라클' }">
				<h3 style="color: blue;">오라클은 데이터베이스 입문용_겨울특강</h3>
			</c:when>
			<c:otherwise>
				<h3 style="color: blue;">${param.lang }과정은 특강 계획이 없습니다</h3>
			</c:otherwise>
		</c:choose>
		
	</c:if>
	
</body>
</html>