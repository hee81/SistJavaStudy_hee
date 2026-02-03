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
	<h2>get방식 form</h2>
	<form action="read1" method="get">
		<input type="text" name="name" class="form-control" style="width: 120px;" placeholder="이름입력">
		<input type="text" name="age" class="form-control" style="width: 120px;" placeholder="나이입력">
		<button type="submit" class="btn btn-outline-success">get방식 전송</button>
	</form>
	
	<h2>post방식 form_dto로 읽기</h2>
	<form action="read2" method="post">
		<input type="text" name="sangname" class="form-control" style="width: 120px;" placeholder="상품명입력">
		<input type="text" name="price" class="form-control" style="width: 120px;" placeholder="가격입력">
		<button type="submit" class="btn btn-outline-info">post방식 전송</button>
	</form>
	
	<h2>post방식 form_map으로 읽기</h2>
	<form action="read3" method="post">
		<input type="text" name="sname" class="form-control" style="width: 120px;" placeholder="상품명입력">
		<input type="text" name="sprice" class="form-control" style="width: 120px;" placeholder="가격입력">
		<button type="submit" class="btn btn-outline-warning">post방식 전송</button>
	</form>
	
	
</body>
</html>