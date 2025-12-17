<%@page import="simpleBoard.BoardDto"%>
<%@page import="simpleBoard.BoardDao"%>
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
<style type="text/css">
	#preview{
		position: absolute;
		left: 700px;
		top: 100px;
		width: 300px;
	}
</style>
<script type="text/javascript">

function readURL(input) {
    // 파일이 선택되었고, 파일 객체가 존재하는지 확인
    if (input.files && input.files[0]) {
        var reader = new FileReader(); // FileReader 객체 생성
        // 파일 읽기가 완료되었을 때 실행될 이벤트 핸들러
        reader.onload = function(e) {
            // 미리보기 이미지 요소의 src 속성을 읽어온 데이터 URL로 설정
            $('#preview').attr('src', e.target.result);
            $('#preview').show(); // 숨겨져 있던 이미지 표시
        };
        // 파일을 Data URL 형식(Base64 인코딩된 문자열)으로 읽어옴
        reader.readAsDataURL(input.files[0]);
    }
}
</script>
<%
	//num읽기
	String num=request.getParameter("num");
	//dao선언
	BoardDao dao=new BoardDao();
	//num으로 얻어온 하나의 dto
	BoardDto dto=dao.getOneData(num);
	
	
%>
</head>
<body>
<div style="margin: 100px 100px; width: 500px;">
	<form action="updateAction.jsp" method="post" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th width="100" class="table-secondary">작성자</th>
				<td>
					<input type="text" name="writer" class="form-control" style="width: 120px;" required="required" value="<%=dto.getWriter()%>">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-secondary">제목</th>
				<td>
					<input type="text" name="subject" class="form-control" style="width: 300px;" required="required" value="<%=dto.getSubject()%>">
				</td>
			</tr>

			<tr>
				<!-- type-file은 dto(imgname)와 addForm-name(photo)을 다르게 설정해야함....Spring?에서는 100%오류남  -->
				<th width="100" class="table-secondary">업로드</th>
				<td>
					<input type="file" name="photo" class="form-control" style="width: 300px;" required="required"
					onchange="readURL(this)">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-secondary">비밀번호</th>
				<td>
					<input type="password" name="pass" class="form-control" style="width: 150px;" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 480px; height: 80px;" name="content" class="form-control" 
					required="required" placeholder="제목에 기반한 상세한 내용을 입력해주세요"><%=dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="num" value="<%=num%>">
					<button type="submit" class="btn btn-success">수정하기</button>
					<button type="button" class="btn btn-info" onclick="location.href='boardlist.jsp'">목록가기</button>
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 미리보기 할 이미지 위 name=photo에서 안하고 여기서 하면됨 -->
	<img alt="" src="../save/<%=dto.getImgname() %>" id="preview">
</div>
</body>
</html>