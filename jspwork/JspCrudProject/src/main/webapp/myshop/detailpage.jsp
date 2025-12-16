<%@page import="java.text.NumberFormat"%>
<%@page import="myshop.ShopDto"%>
<%@page import="myshop.ShopDao"%>
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
<script type="text/javascript">
	function funcdel(num) {
		
		//삭제버튼에서 num값 확인
		/* alert(num); */
		
		var del=confirm("정말 삭제하시겠어요?");
		if(del)
			location.href='deleteshop.jsp?num='+num;
		
	}
</script>
</head>
<%
	String num=request.getParameter("num");
	ShopDao dao=new ShopDao();
	ShopDto dto=dao.getOneData(num);
	NumberFormat nf=NumberFormat.getCurrencyInstance();
	
%>
<body>
<div style="margin: 100px 100px; width: 500px;">
	<table class="table">
		<tr>
			<td rowspan="4">
				<img alt="" src="../image/쇼핑몰사진/<%=dto.getPhoto() %>.jpg">
			</td>
			<td>
				<h3><b><%=dto.getSangpum() %></b></h3>
			</td>
		</tr>
		<tr>
			<td>
				<h5>가격: <%=nf.format(dto.getPrice())%></h5>
			</td>
		</tr>
		<tr>
			<td>
				<h5>입고날짜: <%=dto.getIpgoday() %></h5>
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" class="btn btn-warning" onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
				<button type="button" class="btn btn-danger" onclick="funcdel('<%=dto.getNum()%>')">삭제</button>
			</td>
		</tr>
	</table>
</div>

</body>
</html>