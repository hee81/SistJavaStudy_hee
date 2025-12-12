<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDao"%>
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
	function funcDel(num){
		var ok=confirm('정말 삭제하시겠습니까?');
		if(ok){
			location.href="memberdelete.jsp?num="+num;
		}
	}
</script>
</head>
<%
	MemberDao dao=new MemberDao();
	ArrayList<MemberDto> list=dao.getAllDatas();

%>
<body>
<div style="margin: 50px 100px; width: 1200px;">
	<button type="button" class="btn btn-success" onclick="location.href='addform.jsp'">
	<i class="bi bi-vector-pen"></i>글쓰기</button>
	<table class="table table-bordered">
		<caption align="top">회원정보</caption>
		<tr class="table-success">
			<th width="80">번호</th>
			<th width="120">회원명</th>
			<th width="160">전화번호</th>
			<th width="150">운전면허여부</th>
			<th width="120">직업</th>
			<th width="160">등록일</th>
		</tr>
		<%
			for(int i=0;i<list.size();i++)
			{
				MemberDto dto=list.get(i);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일");
			%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getHp() %></td>
					<td><%=dto.getDriver() %></td>
					<td><%=dto.getJop() %></td>
					<td><%=sdf.format(dto.getWriteday()) %></td>
					<td>
					<!-- 
					리스트에서 수정버튼 누르면 수정폼안에 데이터가 나오도록한다
					1. 인서트폼안에 전체복사해서 업데이트폼안에 붙여넣기 한다
						-dao로부터 하나의 데이터 조회하는 메서드 가져오기
						-num을 hidden처리해서 폼안에 넣기
						-각각의 value값 찍어준다
					2. dao안에서 하나의 데이터 조회하는 메서드 만들기
						-getOneData
					 -->
						<button type="button" class="btn btn-info"
						onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
						<button type="button" class="btn btn-warning"
						onclick="funcDel('<%=dto.getNum()%>')">삭제</button>
					</td>
				</tr>
			<%}
		%>
	</table>
	
</div>

</body>
</html>