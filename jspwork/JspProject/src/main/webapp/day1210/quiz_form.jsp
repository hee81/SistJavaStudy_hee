<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here5</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<!-- 
	form으로 quiz_action에 전송 후 action페이지에서 처리할 것!
	1. 본인이름입력(text)
	2. 오늘 점심메뉴(radio)
	3. 가능IT언어(checkbox 다중선택)
	 -->
	<form action="quiz_action.jsp">
		<table class="table table-bordered" style="width: 500px">
			<tr>
				<th width="150px" class="table-warning">이름</th>
				<td width="350px">
					<input type="text" name="name" required="required" placeholder="이름입력">
				</td>
			</tr>
			<tr>
				<th width="150px" class="table-warning">점심메뉴</th>
				<td>
					<input type="radio" name="lunch" value="../image/Food/1.jpg" checked="checked" >한식 &nbsp;
					<input type="radio" name="lunch" value="../image/Food/2.jpg" >중식 &nbsp;
					<input type="radio" name="lunch" value="../image/Food/3.jpg" >일식 &nbsp;
					<input type="radio" name="lunch" value="../image/Food/4.jpg" >양식 &nbsp;
				</td>
			</tr>
			<tr>
				<th width="150px" class="table-warning">가능한 IT언어</th>
				<td>
					<input type="checkbox" name="itlan" value="Java">Java &nbsp;
					<input type="checkbox" name="itlan" value="C언어">C언어 &nbsp;
					<input type="checkbox" name="itlan" value="Python">Python &nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success btn-large">정보전송</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>