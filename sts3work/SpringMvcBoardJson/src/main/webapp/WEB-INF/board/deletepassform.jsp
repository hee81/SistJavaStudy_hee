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
<title>deletepassform</title>
</head>
<body>

	<div style="margin: 200px 200px;">
		<form action="deletepass" method="post">
			<table>
				<caption align="top">비밀번호 확인</caption>
				<tr>
					<td>
						<input type="password" name="pass" placeholder="비밀번호입력" required>
						<button type="submit">삭제</button>
						<button type="button" onclick="history.back()">뒤로가기</button>
					</td>
				</tr>
			</table>
			<input type="hidden" name="num" value="${num }">
			<input type="hidden" name="currentPage" value="${currentPage }">
		</form>
	</div>
	
</body>
</html>