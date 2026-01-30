<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

	<%
		List<String> list=new ArrayList();
		
		list.add("red");
		list.add("blue");
		list.add("orange");
		list.add("gray");
		list.add("yellow");
		list.add("cyan");
		list.add("magenta");
		
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		
		//session에 아이디 저장
		session.setAttribute("id", "angel");
	%>
	
	<h3>1~10까지 출력</h3>
	<c:forEach begin="1" end="10" var="a">
		${a }&nbsp;
	</c:forEach>
	<hr>
	
	<!-- requestScope 생략가능 -->
	<h3>list에는 총 ${requestScope.count }개의 색상이 있습니다</h3>
	<h3>list에는 총 ${count }개의 색상이 있습니다</h3>
	<hr>
	
	<!-- sessionScope는 생략 권장XXXXX -->
	<h3>세션아이디 출력</h3>
	<h3>현재 로그인한 아이디는 ${sessionScope.id }입니다</h3> 
	<h3>현재 로그인한 아이디는 ${id }입니다</h3>
	<hr>
	
	<!-- 테이블 만들기1 -->
	<h3>리스트 전체 테이블로 출력</h3>
	<table class="table table-bordered" style="width: 300px;">
		<tr>
			<th>번호</th>
			<th>인덱스</th>
			<th>색상</th>
		</tr>
		<c:forEach var="s" items="${list }" varStatus="i"> <!-- i:상태변수(number변수) -->
			<tr>
				<td>${i.count }</td> <!-- 1부터 시작 -->
				<td>${i.index }</td> <!-- 0부터 시작 -->
				<td>
					<b style="color: ${s}">${s }</b>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	
	<!-- 테이블 만들기2 -->
	<h3>list index2~4 테이블로 출력</h3>
	<table class="table table-bordered" style="width: 300px;">
		<tr>
			<th>번호</th>
			<th>인덱스</th>
			<th>색상</th>
		</tr>
		<c:forEach var="s" items="${list }" varStatus="i" begin="2" end="4">
			<tr>
				<td>${i.count }</td> <!-- 1부터 시작 -->
				<td>${i.index }</td> <!-- 2부터 시작 -->
				<td>
					<b style="color: ${s}">${s }</b>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr>

</body>
</html>





















