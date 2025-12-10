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

<form action="insertaction.jsp">
<table class="table table-bordered" style="width: 500px;">
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="name">
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="addr">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit">전송</button>
			<button type="button" onclick="location.href='infolist.jsp'">목록</button>
		</td>
	</tr>

</table>




</form>



</body>
</html>