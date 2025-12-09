<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here3</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style type="text/css">
	img{
		width: 100px;
		height: 90px;
		border:1px solid gray;
		border-radius: 20px;
	}
</style>
</head>
<body>
	<!-- 이미지 가져오기 연습_다른폴더 -->
	<img alt="" src="../image/Food/1.jpg">
	<!-- 이미지 가져오기 연습_같은폴더 ./ 생략가능 -->
	<img alt="" src="./1.png">
	
	<h4>이미지를 배열로 가져오기 연습</h4>
	<%
		String [] imgArr={"01","09","a","a01","a06","b01","b03","c1","c7"};
		int n=0; //증감식 변수
	%>
	<table>
		<%
			for(int i=0;i<3;i++) //행 0,1,2
			{%>
				<tr>
					<%
						for(int j=0;j<3;j++) //열 0,1,2
						{%>
							<td>
								<img alt="" src="../image/jquery_img/<%=imgArr[n]%>.png">
							</td>
						<%
						n++;
						}
					%>
				</tr>
			<%}
		%>
	</table>
	
	<h4>이미지 배열로 가져오기 연습_
	<br>배열선언 없이(Food,연예인사진처럼 일련번호로)_
	4행5열(4행3열)</h4>

	<table>
	<%
		int s=1; //증감변수
		
		for(int i=0;i<4;i++) //행
		{%>
			<tr>
				<%
					for(int j=0;j<5;j++) //열
					{%>
						<td>
							<img alt="" src="../image/연예인사진/<%=s%>.jpg">
						</td>
					<%
					s++;
					}
				%>
			</tr>
		<%}
	%>
	
	</table>
	
	<h4>쇼핑몰 사진의 1~20개를 4행5열로 출력해보기</h4>
	<table>
		<%
			int x=1;
			for(int i=0;i<4;i++)
			{%>
				<tr>
					<%
						for(int j=0;j<5;j++)
						{%>
							<td>
								<img alt="" src="../image/쇼핑몰사진/<%=x%>.jpg" width="100">
							</td>
						<%
						x++;
						}
					%>
				</tr>
			<%}
		%>	
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>