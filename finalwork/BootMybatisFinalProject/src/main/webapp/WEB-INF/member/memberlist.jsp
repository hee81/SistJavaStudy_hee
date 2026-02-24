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
		//전체삭제-체크박스 선택/해제
		$("#allcheck").click(function(){
			//체크값 얻기
			var chk=$(this).is(":checked");
			//얻은 체크를 글 앞의 체크에 일괄전달
			$(".del").prop("checked",chk);
		});
		
		//삭제
		$("#btnmemdel").click(function(){
			var cnt=$(".del:checked").length;
			//alert(cnt);
			if(cnt==0){
				alert("최소 한개는 선택해주세요");
				return;
			}
			$(".del:checked").each(function(i,elt){
				var num=$(this).attr("num");
				//alert(num); //선택한 num맞는지 확인!! 심어논 num으로!
				
				//ajax로 삭제하기!
				$.ajax({
					type:"get",
					dataType:"html",
					url:"delete",
					data:{"num":num},
					success:function(){
						//alert("삭제됨");
						location.reload();
					}
				})
				
			})
		})
	})
</script>
<title>memberlist</title>
</head>
<body>
<jsp:include page="../../layout/title.jsp"></jsp:include>
<div class="container">
   <!-- 번호   회원명    아이디    이메일    -->
   <table class="table table-bordered">
	<caption align="top">전체회원명단</caption>
	<tr>
		<th>번호</th>
		<th>회원명</th>
		<th>아이디</th>
		<th>이메일</th>
		<th><input type="checkbox" id="allcheck">전체삭제</th>
	</tr>
   	<c:forEach items="${list }" var="dto" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td>${dto.name}</td>
			<td>${dto.id}</td>
			<td>${dto.email}</td>	
			<td><input type="checkbox" class="del" num=${dto.num}></td>	
		</tr>
	</c:forEach>
	</table>
	<button type="button" class="btn btn-danger" id="btnmemdel">삭제</button>
</div>
</body>
</html>