<%@page import="memguest.MemGuestDto"%>
<%@page import="memguest.MemGuestDao"%>
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
<style>
	#preview{
		position: absolute;
		left: 600px;
		top: 100px;	
		max-width: 300px;
	}
	
	i.camera{
		cursor: pointer;
	}
</style>
<script type="text/javascript">

	$(function(){
		$("i.camera").click(function(){
			//id photo를 강제 클릭한 이벤트 만들기
			$("#photo").trigger("click");
		})
	})

	function readURL(input) {
	   // 파일이 선택되었고, 파일 객체가 존재하는지 확인
	   if (input.files[0]) {
	       var reader = new FileReader(); // FileReader 객체 생성
	       // 파일 읽기가 완료되면 실행될 콜백 함수 설정
	       reader.onload = function (e) {
	           // 이미지 미리보기 영역의 src 속성을 읽어온 데이터 URL로 변경
	           $('#preview').attr('src', e.target.result);
	           //$('#preview').show(); // 숨겨져 있던 이미지 표시
	       };
	       // 파일을 Data URL 형식(base64 문자열)으로 읽어옴
	       reader.readAsDataURL(input.files[0]);
	   }
	}
</script>

</head>
<%
	String num=request.getParameter("num");
	String currentPage=request.getParameter("currentPage");
	
	MemGuestDao dao=new MemGuestDao();
	MemGuestDto dto=dao.getOneData(num);
%>
<body>
<%
	//session으로부터 로그인한 사람의 아이디 얻기
	String id=(String)session.getAttribute("idok");

	//로그인한 상태인지?
	String loginok=(String)session.getAttribute("loginok");
	
	if(loginok!=null) //null이 아니라면 로그인 상태라면!
	{
		if(dto.getPhoto().equals("no")){%>
			<img id="preview">
		<%}
		else{%>
			<!-- 이미지 미리보기 -->
			<img id="preview" src="../save/<%=dto.getPhoto()%>">
		<%}
	
	%>
		<div style="margin: 50px 100px; width: 520px;">
			<form action="updateAction.jsp" method="post" enctype="multipart/form-data">
			
				<!-- hidden 필수 -->
				<input type="hidden" name="num" value=<%=num%>>
				<input type="hidden" name="currentPage" value=<%=currentPage%>>
				
				<table class="table table-bordered">
					<caption align="top"><b>회원방명록(<%=id %>)</b></caption>
					<tr height="150">
						<td class="input-group">
							<b>사진을 선택해주세요(1개)</b>
							<i class="bi bi-camera-fill camera" style="font-size: 2em;"></i>
							<input type="file" name="photo" id="photo" style="display: none;" onchange="readURL(this)" value="<%=dto.getPhoto()%>">
							<br>
							<textarea name="content" style="width: 400px; height: 100px;" class="form-control" required="required"><%=dto.getContent() %></textarea>
							<button type="submit" class="btn btn-secondary" style="width: 100px; height: 100px;">수정</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	
		
	<%}
	
%>
</body>
</html>