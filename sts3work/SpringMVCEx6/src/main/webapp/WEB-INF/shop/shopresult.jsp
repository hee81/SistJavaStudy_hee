<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!--
		shopresult에 출력하시오
		출력하는 글자색을 폼에서 선택한 색상으로 출력할 것
		상품명:
		수량:
		단가:
		총 금액:
	 -->	
	 
	 <c:set var="tot" value="${dto.su *dto.price }"/>

	<h4>shopresult페이지</h4>
	<div style="color: ${dto.color}">
		<h5>상품명: ${dto.sang }</h5>
		<h5>수량: <fmt:formatNumber value="${dto.su }" pattern="#,##0"/></h5>
		<h5>단가: <fmt:formatNumber value="${dto.price }" type="currency"/></h5>
		<h5>총 금액: <fmt:formatNumber value="${tot }" type="currency"/></h5>
	</div>

</body>
</html>