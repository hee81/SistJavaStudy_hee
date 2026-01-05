<%@page import="reboard.ReboardDao"%>
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
<%
	//새글,답글 구별해야함
	//답글일 경우 읽어야할 것들 처리하기
	String num=request.getParameter("num");
	//String currentPage=request.getParameter("currentPage"); //첫페이지가 아닌 댓글이 있던 페이지로 넘어가도록 하기 위해서
	//새글 null, 답글 원글의 num이 넘어온다
	String regroup="",restep="",relevel="",subject="",currentPage="";
	//dao
	ReboardDao dao=new ReboardDao();
	
	if(num!=null) //답글인 경우
	{
		regroup=request.getParameter("regroup");
		restep=request.getParameter("restep");
		relevel=request.getParameter("relevel");
		currentPage=request.getParameter("currentPage");
		
		//답글일 경우 원글의 제목 넘어오도록
		subject="[답글]"+dao.getData(num).getSubject();
	}
	
%>
<body>
	<!-- 새글이자 답글 form임 그래서 hidden 추가 필요 -->
	<div style="margin: 100px 200px; width: 500px;">
	
		<form action="addAction.jsp" method="post">
		
			<!-- 답글일 경우에만 hidden(num,regroup,restep,relevel,currentPage -->
			<%
				if(num!=null)
				{%>
					<input type="hidden" name="num" value="<%=num%>">
					<input type="hidden" name="currentPage" value="<%=currentPage%>">
					<input type="hidden" name="regroup" value="<%=regroup%>">
					<input type="hidden" name="restep" value="<%=restep%>">
					<input type="hidden" name="relevel" value="<%=relevel%>">				
					<!-- 답글쓰기 버튼에 위에 hidden 넘겨야함! -->
					
				<%}
			%>
			
			<table class="table table-bordered">
				<!-- 삼항연산자로 테이블제목 구분 -->
				<caption align="top"><b><%=num==null?"새글등록":"답글등록" %></b></caption>
				<tr>
					<th class="table-success">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control" style="width: 320px;" required="required">
					</td>
				</tr>
				<tr>
					<th class="table-success">제목</th>
					<td>
						<input type="text" name="subject" class="form-control" style="width: 320px;" required="required" value="<%=subject%>">
					</td>
				</tr>
				<tr>
					<th class="table-success">비밀번호</th>
					<td>
						<input type="password" name="pass" class="form-control" style="width: 150px;" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<textarea style="width: 480px; height: 100px;" name="content" class="form-control" 
						placeholder="자유롭게 게시글을 남겨주세요~"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success">게시글등록</button>
						<input type="button" class="btn btn-success" value="목록이동" onclick="location.href='boardList.jsp'">
					</td>
				</tr>
			</table>
			
		</form>
		
	</div>
</body>
</html>