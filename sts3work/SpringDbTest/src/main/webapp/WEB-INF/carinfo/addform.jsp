<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h4>addform페이지</h4>
	<form action="write" method="post">
		<table class="table table-bordered" style="width: 500px;">
			<caption align="top"><b>자동차정보입력</b></caption>
			<tr>
				<th>자동차명</th>
				<td><input type="text" name="carname" class="form-control" style="width: 120px;" required></td>
			</tr>
			<tr>
				<th>색상</th>
				<td><input type="color" name="carcolor" class="form-control" style="width: 250px;" required></td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td><input type="text" name="carprice" class="form-control" style="width: 150px;" required></td>
			</tr>
			<tr>
				<th>상품입고일</th>
				<td><input type="date" name="carguip" class="form-control" style="width: 250px;" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit" class="btn btn-outline-success">DB저장</button></td>
			</tr>
		</table>
	</form>
</body>
</html>