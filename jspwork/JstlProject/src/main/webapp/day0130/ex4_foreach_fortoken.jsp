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
	
	<h2>foreach</h2>
	<!-- step도 가능 -->
	<c:forEach var="a" begin="1" end="10" step="2">
		[${a}]&nbsp;
	</c:forEach>
	<hr>
	<!-- 테이블 만들기 -->
	<%
		String [] mycolor={"red","yellow","gray","blue","cyan","magenta"};
	%>
	<c:set var="mycolor" value="<%=mycolor %>"/>
	
	<table class="table table-bordered" style="width: 300px;">
		<tr>
			<td>index</td>
			<td>count</td>
			<td>color</td>
		</tr>
		<c:forEach var="mc" items="${mycolor}" varStatus="i">
			<tr>
				<td>${i.index }</td>
				<td>${i.count }</td>
				<td style="background-color: ${mc}">${mc}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	
	
	<h2>forToken</h2>
	<c:set var="flowers" value="장미,백합,프리지아,다알리아,안개꽃"/>
	${flowers}<br>
	
	<!-- forToken -->
	<h3>flowers값을 컴마로 분리해서 출력</h3>
	<c:forTokens var="s" items="${flowers}" delims="," varStatus="i">
		<h3>${i.count}: ${s}</h3>
	</c:forTokens>
	
</body>
</html>






















