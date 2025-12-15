<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<div style="width: 400px; margin: 100px 100px;">
	<form action="addproc.jsp" method="post">
		<table class="table table-bordered">
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="sangpum">
				</td>
			</tr>
			<tr>
				<th>상품사진</th>
				<td>
					<input type="image" name="photo">
				</td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<th>입고일</th>
				<td>
					<input type="text" name="ipgoday">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success">상품등록</button>
					<button type="button" class="btn btn-outline-info">상품목록</button>
				</td>
			</tr>
		</table>
	</form>	
</div>
</body>
</html>