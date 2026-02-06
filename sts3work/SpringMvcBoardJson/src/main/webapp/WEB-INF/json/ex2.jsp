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
	<h3 class="alert alert-info">Ex2번 예제</h3>
	<br>
	<button type="button" class="btn btn-info" id="btn2">Json 배열 데이터 출력하기_list2</button>
	<div id="out">1</div>
	<figure>
		<figcaption></figcaption>
		<img alt="" src="">
	</figure>
	
	<script type="text/javascript">
		$("#btn2").click(function(){
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"list2",
				success:function(res){
					var s="";
					$.each(res,function(idx,ele){
						s+="<figure>"
						s+="<img src='image/Food/"+ele.foodphoto+"' style='width:150px;'>";
						s+="<figcaption>"+ele.foodname+"</figcaption>";
						s+="</figure>";
					})
					$("#out").html(s);
				}
			})
			
		})
	</script>
</body>
</html>