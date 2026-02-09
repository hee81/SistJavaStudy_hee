<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>boardlist</title>
</head>
<body>
	<div class="alert alert-info" style="width: 500px;">
		총 ${totalCount }개의 게시글이 있습니다.
	</div>  
	<br>
	<button type="button" class="btn btn-outline-info" onclick="location.href='addform'">글쓰기</button>
	
	<div>
		<table class="table table-bordered" style="width: 500px;">
		 	<caption align="top">Spring Paging 목록 게시판</caption>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<c:if test="${totalCount==0 }">
				<tr>
					<td colspan="5" align="center">
						<b>등록된 게시글이 없습니다.</b>
					</td>
				</tr>
			</c:if>
			<c:if test="${totalCount>0 }">
				<c:forEach items="${list }" var="li">
					<tr>
						<td>${no }</td>
						<c:set var="no" value="${no-1 }"/> <!-- 출력 후 감소 , 증감식은 안됨 -->
						<td><a href="detail?num=${li.num }&currentPage=${currentPage}">${li.subject }</a></td>
						<td>${li.writer}</td>
						<td><fmt:formatDate value="${li.writeday}" pattern="yyyy-MM-dd"/></td>
						<td>${li.readcount}</td>
						
					</tr>
				</c:forEach>
			</c:if>
			
		</table>
	</div>
	
	 <!-- 페이지 번호 출력 -->
	<div>
		 <nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  
		  <!-- 이전 -->
		  <c:if test="${startPage>1 }">
		  	<li class="page-item">
		  		<a class="page-link" href="list?currentPage=${startPage-1}">이전</a>
		  	</li>
		  </c:if>
		  
		  <!-- 1~5 -->
		  <c:forEach var="pp" begin="${startPage }" end="${endPage }">
			<c:if test="${pp==currentPage }">
		  		<li class="page-item active"><a href="list?currentPage=${pp }" class="page-link">${pp }</a></li>
		  	</c:if>
		  	<c:if test="${pp!=currentPage }">
		  		<li class="page-item"><a href="list?currentPage=${pp }" class="page-link">${pp }</a></li>
		  	</c:if>
		  </c:forEach>
		  
		  <!-- 다음  -->
		  <c:if test="${endPage<totalPage }">
	    	 <li class="page-item">
	      		<a class="page-link" href="list?currentPage=${endPage+1 }">다음</a>
	    	</li>
		  </c:if>

		  </ul>
		</nav>
	</div>
	
</body>
</html>