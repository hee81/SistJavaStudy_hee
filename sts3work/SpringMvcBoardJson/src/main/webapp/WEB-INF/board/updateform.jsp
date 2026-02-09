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
<title>updateform</title>
</head>
<body>
	<form action="update" method="post" enctype="multipart/form-data">
	    <table class="table table-bordered align-middle" style="width: 500px; margin: 50px 50px;">
	      <tr>
	        <th>작성자</th>
	        <td><input type="text" name="writer" class="form-control" style="width: 150px;" value="${dto.writer }"></td>
	      </tr>
	      <tr>
	        <th>제목</th>
	        <td><input type="text" name="subject" class="form-control" style="width: 300px;" value="${dto.subject }"></td>
	      </tr>
	      <tr>
	        <th>내용</th>
	        <td><textarea name="content" class="form-control" rows="3" style="width: 300px;" >${dto.content }</textarea></td>
	      </tr>
	      <tr>
	        <th>파일</th> <!-- 파일은 name db명과 다르게하기 -->
	        <td><input type="file" name="upload" class="form-control" style="width: 300px;" multiple></td>
	      </tr>
	      <tr>
	        <td colspan="2" class="text-center">
	          <button type="submit" class="btn btn-danger">DB수정</button>
	          <button type="button" class="btn btn-secondary" onclick="location.href='detail?num=${dto.num}&currentPage=${currentPage }'">취소</button>
	        </td>
	      </tr>
	    </table>
	    <input type="hidden" name="num" value="${dto.num }">
		<input type="hidden" name="currentPage" value="${currentPage }">
	</form>
</body>
</html>