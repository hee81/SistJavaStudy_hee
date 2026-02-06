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
	<h5>updateform페이지</h5>
	<form action="update" method="post">
		<table class="table table-bordered" style="width: 500px;">
			<caption align="top">차량구입회원등록</caption>
			<tr>
				<th>회원명</th>
				<td><input type="text" name="name" class="form-control" style="width: 130px;" value="${dto.name }"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="hp" class="form-control" style="width: 200px;" value="${dto.hp }"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr" class="form-control" style="width: 300px;" value="${dto.addr }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-outline-success" style="width: 150px;" value="DB수정">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>