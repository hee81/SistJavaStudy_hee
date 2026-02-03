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
	<form action="info" method="post">
		<table>
			<tr>
				<th>사원명</th>
				<td><input type="text" name="name" class="form-control" style="width: 150px;" placeholder="사원명입력"></td>
				
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="text" name="pay" class="form-control" style="width: 150px;" placeholder="급여입력"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" class="form-control" style="width: 150px;" placeholder="나이입력"></td>
			</tr>
			<tr>
				<th>혈액형</th>
				<td>
					<select name="blood" class="form-select" required>
						<option value="">선택</option>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="O">O</option>
						<option value="AB">AB</option>
					</select>
				</td>
				<!-- <td><input type="text" name="blood" class="form-control" style="width: 150px;" placeholder="혈액형입력"></td> -->
			</tr>
			<tr>
				<td colspan="2"><button type="submit" class="btn btn-outline-warning">과제출력</button></td>
			</tr>
		</table>
		
		
		
		
		
	</form>
</body>
</html>