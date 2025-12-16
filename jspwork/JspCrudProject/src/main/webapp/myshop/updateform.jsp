<%@page import="java.text.SimpleDateFormat"%>
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
	$(function() {
		
		//select의 첫이미지와 맞추기
		var selImg=$("#photo option:selected").val();
		$("#myphoto").attr("src","../image/쇼핑몰사진/"+selImg+".jpg");
		
		//사진을 선택하면 옆의 이미지에 사진이 나오게...
		$("#photo").change(function(){
			var s="../image/쇼핑몰사진/"+$(this).val()+".jpg";
			$("#myphoto").attr("src",s);
		});
	});
</script>
<%
	String num=request.getParameter("num");
	ShopDao dao=new ShopDao();
	ShopDto dto=dao.getOneData(num);

%>
</head>
<body>
<div style="width: 500px; margin: 50px 100px;">
	<form action="updateproc.jsp" method="post">
		<input type="hidden" name="num" value="<%=num%>">
		<table class="table table-bordered">
			<caption align="top"><a>상품수정</a></caption>
			<tr>
				<th width="100" class="table-secondary">상품명</th>
				<td>
					<input type="text" name="sangpum" required="required" class="form-contorl" style="width: 200px;" value="<%=dto.getSangpum()%>">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-secondary">상품이미지</th>
				<td class="input-group">
					<select name="photo" class="form-control" id="photo">
						<option value="30" <%=dto.getPhoto().equals("30")?"selected":"" %>>헤어밴드</option>
						<option value="11" <%=dto.getPhoto().equals("11")?"selected":"" %>>단화#1</option>
						<option value="12" <%=dto.getPhoto().equals("12")?"selected":"" %>>단화#2</option>
						<option value="13" <%=dto.getPhoto().equals("13")?"selected":"" %>>단화#3</option>
						<option value="20" <%=dto.getPhoto().equals("20")?"selected":"" %>>진주팔찌</option>
						<option value="22" <%=dto.getPhoto().equals("22")?"selected":"" %>>진주반지</option>
						<option value="26" <%=dto.getPhoto().equals("26")?"selected":"" %>>플라워헤어밴드</option>
						<option value="10" <%=dto.getPhoto().equals("10")?"selected":"" %>>쁘띠스카프</option>
						<option value="19" <%=dto.getPhoto().equals("19")?"selected":"" %>>리본헤어핀</option>
					</select>
					&nbsp;&nbsp;&nbsp;
					<img alt="" src="" width="30" height="30" id="myphoto">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-secondary">가격</th>
				<td>
					<input type="number" name="price" required="required" class="form-contorl" 
					style="width: 200px;" pattern="[0~9]{3,}" value="<%=dto.getPrice()%>">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-secondary">입고일자</th>
				<td>
					<input type="date" name="ipgoday" class="form-contorl" 
					style="width: 200px;" value="<%=dto.getIpgoday()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success">상품수정</button>
					<button type="button" class="btn btn-outline-info" onclick="location.href='shoplist.jsp'">상품목록</button>
				</td>
			</tr>
		</table>
	</form>	
</div>
</body>
</html>