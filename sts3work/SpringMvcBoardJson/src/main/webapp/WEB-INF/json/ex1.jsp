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
<title>ex1페이지</title>
</head>
<body>
	<h3 class="alert alert-info">Ex1예제</h3>
	<br>
	<button type="button" id="btn1" class="btn btn-danger">Json 데이터 출력하기_list1</button>
	<div id="out"></div>
	
	<script type="text/javascript">
		$("#btn1").click(function(){
			$.ajax({
				type:"get",
				dataType:"json",
				url:"list1",
				success:function(res){
					$("#out").append("이름: "+res.name+"<br>");
					$("#out").append("전화번호: "+res.hp+"<br>");
					$("#out").append("주소: "+res.addr+"<br>");
				}
			})
		})
	</script>

</body>
</html>