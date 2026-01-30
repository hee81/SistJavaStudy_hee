<%@page import="java.util.Date"%>
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
	
	<!-- jstl에서 변수 선언하는 방법 -->	
	<c:set var="name" value="홍길동"/>
	<c:set var="age" value="30"/>
	<c:set var="today" value="<%=new Date() %>"/>
	<c:set var="money" value="87451845"/>
	<c:set var="num1" value="8745.18455625623"/>
	
	<!-- jstl에서 변수 출력하는 방법1 -->
	<h2>이름: <c:out value="${name}"/></h2>
	
	<!-- jstl에서 변수 출력하는 방법2(c:out생략가능) -->
	<h2>이름: ${name }</h2>
	<h2>나이: ${age }세</h2>
	<h2>날짜: ${today }</h2>
	
	<!-- fmt날짜형식 pattern -->
	<pre>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd a hh:mm"/>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEE"/>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEEE"/>
	</pre>
	
	<!-- jstl에서 숫자 출력 양식 -->
	${money }<br>
	${num1 }<br>
	
	<!-- number: 3자리마다 컴마 -->
	<fmt:formatNumber value="${money }" type="number"/><br>
	
	<!-- currency: 3자리마다 컴마+화폐단위 -->
	<fmt:formatNumber value="${money }" type="currency"/><br>
	
	<!-- patten:잘 안씀 -->
	<fmt:formatNumber value="${num1 }" pattern="0.00"/><br>
	<fmt:formatNumber value="1.2" pattern="0.00"/><br>
	<fmt:formatNumber value="1.2" pattern="0.##"/><br>
	
	<!-- jstl : else, 증감식 없음..!! -->

</body>
</html>








