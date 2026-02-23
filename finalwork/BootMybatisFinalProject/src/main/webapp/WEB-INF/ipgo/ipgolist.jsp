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
<title>ipgolist</title>
</head>
<body class="container">

<jsp:include page="../../layout/title.jsp"></jsp:include>

<div class="alert alert-info">${totalCount }개의 상품이 입고중입니다</div>
	<table class="table table-bordered" style="width: 800px;">
		<caption align="top">
			<span style="float: right;">
				<button type="button" class="btn btn-secondary" onclick="location.href='ipgoform'">상품추가</button>
			</span>
		</caption>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td width="400" rowspan="4" align="center" valign="middle">
					<c:if test="${dto.photoname!='no' }">
						<c:forTokens items="${dto.photoname }" delims="," var="photo" begin="0" end="0"> <!-- 대표사진 1개만 출력 -->
							<img alt="" src="../ipgosave/${photo }" style="width: 100px;">
						</c:forTokens>
					</c:if>
				</td>
				<td>${dto.sangpum }</td>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${dto.price }" type="currency"/></td>
			</tr>
			<tr>
				<td><fmt:formatDate value="${dto.ipgoday }" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
			<tr>
				<td>
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>