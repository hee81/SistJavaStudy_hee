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

	<h2>resources 폴더 안의 이미지 출력</h2>
	<!-- servlet_context에 지정한 mapping주소를 사용해야함!!! -->
	<img alt="" src="../res/01.png"> <!-- ../안하면 주소가 shop/res/01.png가 된다 -->
	<img alt="" src="../res/02.png">
	<img alt="" src="../res/image/03.png">
	<img alt="" src="../res/image/04.png">

	<h2>WEB-INF/image 폴더 안의 이미지 출력</h2>
	<img alt="" src="../image/05.png">
	<img alt="" src="../image/06.png">
	<img alt="" src="../image/shop/07.png">
	<img alt="" src="../image/shop/08.png">
	

</body>
</html>