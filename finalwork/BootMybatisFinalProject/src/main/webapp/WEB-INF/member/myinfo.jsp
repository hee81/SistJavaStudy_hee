<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(function(){
	$(".btnnewphoto").click(function(){
		$("#newphoto").trigger("click");
	})
	
	$("#newphoto").change(function(){
		var num=$(this).attr("num");
		console.log(num);
		
		var form=new FormData();
		form.append("photo",this.files[0]); //선택한 1개만 추가하겠다!
		form.append("num",num);
		console.dir(form);
		
		$.ajax({
			type:"post",
			dataType:"json",
			url:"updatephoto",
			processData:false, //기본-서버에 전달하는 데이터(=쿼리스트링) //false-사진업데이트에는 안쓰겠다는 말
			contentType:false, //기본-enctype="application //fasle-multipart 쓰겠다 라는 말
			data:form,
			success:function(){
				location.reload();
			}
		})
	})
})
</script>
<title>myinfo</title>
</head>
<body>
<jsp:include page="../../layout/title.jsp"></jsp:include>

<div class="container">
<!-- 사진옆에 정보들  그옆에  수정,삭제버튼 -->
<table class="table table-bordered">

	<c:forEach items="${list }" var="dto">
		<tr>
			<td rowspan="5" align="center">
				<img src="../membersave/${dto.photo}">
				<br>
				<input type="file" id="newphoto" style="display: none;" num="${dto.num}"><!-- 사진 수정시 호출 -->
				<button type="button" class="btn btn-info btnnewphoto">사진수정</button>
				</td>
			
		</tr>
		<tr>
			<td>${dto.name}(${dto.id})</td>
		</tr>
		<tr>
			<td>${dto.email}</td>
		</tr>
		<tr>
			<td>${dto.gaipday}</td>
		</tr>
		<tr>
			<td>
				<button type="button" class="btn btn-default btnupdate" num="${dto.num}">수정</button>
				<button type="button" class="btn btn-default" num="${dto.num}">탈퇴</button>
			</td>
		</tr>
	</c:forEach>
	
</table>
</div>

</body>
</html>