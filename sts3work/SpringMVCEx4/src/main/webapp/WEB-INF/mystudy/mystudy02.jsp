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
<title>${title }</title>
</head>
<body>
	<h4>mystudy02파일</h4>
	<h4>WEB-INF 이미지 출력</h4>
	<h5>${foodMenu }</h5>
	<img alt="" src="../image/1.jpg"><br><br>
	<!-- WEB-INF 폴더는 “직접 URL로 접근 불가” 영역 -->
	<img alt="" src="../WEB-INF/image/2.jpg"><br>

</body>
</html>