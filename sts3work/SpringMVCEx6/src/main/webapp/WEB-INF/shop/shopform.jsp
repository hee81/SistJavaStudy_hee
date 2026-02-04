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
	<h4>shopform파일</h4>
	<form action="process2" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="sang" class="form-control" style="width: 150px;">
				</td>
			</tr>
			<tr>
				<th>수량</th>
				<td>
					<input type="text" name="su" class="form-control" style="width: 150px;">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="text" name="price" class="form-control" style="width: 150px;">
				</td>
			</tr>
			<tr>
				<th>색상</th>
				<td>
					<input type="color" name="color" class="form-control" style="width: 150px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="서버전송" class="btn btn-outline-success">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>