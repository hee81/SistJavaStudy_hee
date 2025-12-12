
<%@page import="org.apache.coyote.UpgradeToken"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="mysql_team.TeamDto"%>
<%@page import="java.util.List"%>
<%@page import="mysql_team.TeamDao"%>
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
	function decfunc(num) {
		var del=confirm("정말 삭제하시겠어요?");
		if(del)
		{
			location.href='deleteteam.jsp?num='+num;
		}
	}


</script>
</head>
<%
	TeamDao dao=new TeamDao();
	List<TeamDto> list=dao.getAllDatas();
%>
<body>
<div style="width: 700px; margin: 50px 150px;">
	<button type="button" class="btn btn-success" onclick="location.href='addform.jsp'">팀가입</button>
	<table class="table table-bordered">
		<caption align="top">팀목록</caption>
		<tr>
			<th>번호</th>
			<th>회원명</th>
			<th>주소</th>
			<th>결혼여부</th>
			<th>가입일</th>
		</tr>
		<%
			for(int i=0;i<list.size();i++)
			{
				TeamDto dto=list.get(i);
			%>
				<tr>
					<th><%=i+1 %></th>
					<th><%=dto.getName() %></th>
					<th><%=dto.getAddr() %></th>
					<th><%=dto.getMarry() %></th>
					<!-- 가입일 수정 필요!! -->
					<th><%=dto.getGaipday() %></th>
					<th>
						<button type="button" class="btn btn-outline-success" 
						onclick="location.href='updateform.jsp'">수정</button>
						<button type="button" class="btn btn-outline-warning" 
						onclick="decfunc('<%=dto.getNum()%>')">삭제</button>
					</th>
				</tr>
			<%}
		%>		
	</table>
</div>
</body>
</html>