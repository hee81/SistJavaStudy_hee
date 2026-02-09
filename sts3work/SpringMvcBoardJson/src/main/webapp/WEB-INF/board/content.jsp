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
<title>content</title>
</head>
<body>

	<table class="table table-bordered" style="width: 600px; margin: 30px 30px;">
		<tr>
			<td>
				<h3>제목:${dto.subject }</h3>
				<span style="float: right">조회:${dto.readcount }&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/></span>
				<br>
				<h5>작성자:${dto.writer }</h5>
			</td>
		</tr>
		<tr>
			<td>
				<pre>${dto.content }</pre>
				<br><br>
				<c:if test="${dto.photo.equals('no') }">
					사진없음
				</c:if>
				<c:if test="${dto.photo != 'no' }">
					<c:forTokens items="${dto.photo }" delims="," var="photo">
						<a href="../photo/${photo }">
							<img alt="" src="../photo/${photo }" style="width: 100px; height: 100px;">
						</a>
					</c:forTokens>
				</c:if>
			</td>
		</tr>
		
		<!-- 댓글추가 -->
		<tr>
			<td>
				<div id="alist">댓글리스트 출력 예정</div>
				<form action="ainsert" method="post">
					<div class="d-flex">
						<input type="text" name="nickname" class="form-control" style="width:120px;" placeholder="닉네임">
						<input type="password" name="pass" class="form-control" style="width:120px;" placeholder="비밀번호">
					</div>
					<div class="d-flex">
						<input type="text" name="content" class="form-control" style="width:500px;" placeholder="댓글입력">
						<button type="submit" class="btn btn-outline-success btn-sm">확인</button>	
					</div>
					<input type="hidden" name="num" value="${dto.num }">
					<input type="hidden" name="currentPage" value="${currentPage}">
				</form>
			</td>
		</tr>
		
		<tr>
			<td align="right">	
				<button type="button" class="btn btn-outline-primary btn-sm" onclick="location.href='addform'">글쓰기</button>
				<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='upassform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
				<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='dpassform?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
				<button type="button" class="btn btn-outline-info btn-sm" onclick="location.href='list?currentPage=${currentPage}'">목록으로</button>
			</td>	
		</tr>
	</table>

</body>
</html>