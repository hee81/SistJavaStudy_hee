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
<title>Insert title here</title>
</head>
<body>

<div class="container mt-5">
    <div class="row">
    
        <div class="col-md-6">
            <c:if test="${dto.photo != 'no'}">
                <div class="product-gallery">
                    <c:forTokens items="${dto.photo}" delims="," var="onephoto" varStatus="status">
                        <img src="../photo/${onephoto}" class="img-fluid rounded mb-3 shadow-sm" alt="${dto.sangpum}">
                    </c:forTokens>
                </div>
            </c:if>
            <c:if test="${dto.photo == 'no'}">
                <img src="../photo/noimage.png" class="img-fluid rounded" alt="이미지 없음">
            </c:if>
        </div>

        <div class="col-md-6">
            <div class="product-details ps-md-4">
                <h2 class="display-5 fw-bold mt-2">${dto.sangpum}</h2>
                <h3 class="text-danger mt-4"><fmt:formatNumber value="${dto.price}" type="currency" /></h3>
                <small class="text-muted">입고일: ${dto.ipgoday}</small>
                
				<hr>
		
		        <div class="btn-group">
		            <button type="button" class="btn btn-light border" onclick="location.href='addform'">글쓰기</button>
		            <button type="button" class="btn btn-success" onclick="location.href='updateform.jsp?num=${dto.num}'">수정</button>
		            <button type="button" class="btn btn-danger" onclick="location.href='del?num=${dto.num }'">삭제</button>
		            <button type="button" class="btn btn-outline-secondary" onclick="location.href='list'">목록</button>
		        </div>
		    </div>
        </div>
        
    </div>
</div>

</body>
</html>