<%@page import="java.text.SimpleDateFormat"%>
<%@page import="reboard.ReboardDto"%>
<%@page import="java.util.List"%>
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
	//dao선언
	ReboardDao dao=new ReboardDao();
	//총갯수
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	//페이징에 필요한 변수들
	int totalCount=dao.getTotalCount(); //전체갯수
	int perPage=5; //한 페이지에 보여질 글 갯수
	int perBlock=5; //한 블럭에 보여질 페이지 갯수
	////아래 5가지 중요!!!!
	int startNum; //db에서 가져올 글의 시작번호 (mysql이므로 첫글 0  / 오라클은 첫글 1 시작&limit없음)
	int startPage; //각 블럭당 보여질 시작페이지
	int endPage; //각 블럭당 보여질 끝페이지
	int currentPage; //현재페이지 (없으면 수정할 때마다 1페이지로 넘어감)
	int totalPage; //총 페이지
	
	int no; //각 페이지 당 풀력할 시작번호 (필수아님)
	
	////현재페이지 읽기(currentPage),단 null일 경우 1로 준다
	if(request.getParameter("currentPage")==null)
		currentPage=1;
	else
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	
	////총페이지 구하기(totalPage)
	//총페이지갯수/한페이지에 보여질 글 갯수 (7/5=1) (totalcount/perPage+나머지)
	//나머지가 한개라도 남아있다면 무조건 1페이지 추가해야함 (1+1=2페이지 필요) (totalcount%perPage==0?0:1)
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
	
	////각 블럭당 보여질 시작페이지,끝페이지(startPage,endPage) 1~5 6~10, 11~15 16~20
	//perBlock=5일 경우 현재페이지 1~5, 시작페이지1, 끝페이지5 (만약 현재페이지 13 시작페이지11, 끝페이지15)
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;
	//총페이지갯수 23일 경우 마지막 25가 아니라 23이다
	if(endPage>totalPage)
		endPage=totalPage;
	
	////각 페이지에서 보여질 시작번호(startNum)
	//예) 5개의 글을 한페이지에 둔다
	//예) 1페이지:0 2페이지:5 3페이지:10..15..20
	startNum=(currentPage-1)*perPage;
	
	////현재페이지 글 갯수
	no=totalCount-(currentPage-1)*perPage;
	
	//페이지에서 보여질 글만 가져오기
	List<ReboardDto> list=dao.getPagingList(startNum, perPage);
%>
<body>

	<div style="margin: 100px 100px; width: 900px;">
	
		<button type="button" class="btn btn-secondary" onclick="location.href='addForm.jsp'">새글쓰기</button>
		
		<table class="table table-bordered">
			<caption align="top"><b><%=totalCount %>개의 게시글이 있습니다</b></caption>
			<tr class="table-success">
				<th width="70">번호</th>
				<th width="70">제목</th>
				<th width="70">작성자</th>
				<th width="70">작성일</th>
				<th width="70">조회수</th>
			</tr>
			
			<%
			
				if(totalCount==0)
				{%>
					<tr>
						<td colspan="5" align="center">
							<b>등록된 게시글이 없습니다</b>
						</td>
					</tr>
				<%}
			
				else{
					
					for(ReboardDto dto:list){%>
						
						<tr>
							<td><%=no-- %></td>
							
							<td><!-- 제목부분..대댓글일 경우 공백 1레벨당 2칸 -->
							<%
								for(int i=1;i<dto.getRelevel();i++)
								{%>
									&nbsp;&nbsp;
								<%}
							%>
							
							<!-- 답글일 경우 re이미지 -->
							<%
							if(dto.getRelevel()>0)
							{%>
								<img alt="" src="../image/re.png">
							<%}
							%>
							
							<a href="detailPage.jsp?num=<%=dto.getNum()%>">
							<%=dto.getSubject() %>
							</a>
							
							</td>
							
							<td><%=dto.getWriter() %></td>
							<td><%=sdf.format(dto.getWriteday()) %></td>
							<td><%=dto.getReadcount() %></td>
						</tr>
						
					<%}
				}
			
			%>
			
		</table>
		
		<!-- 페이지 번호 출력 -->
	<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">

			  <!-- 조건은 자바에서 -->
			  <%
			  	//이전
			  	if(startPage>1)
			  	{%>
			  		<li class="page-item">
				    	<a class="page-link" href="boardList.jsp?currentPage=<%=startPage-1%>">Previous</a>
				    </li>
			  	<%}
			  
				//현재(active css클래스 추가),그외 구분필요
			  	for(int pp=startPage;pp<=endPage;pp++)
			  	{
			  		if(pp==currentPage)
			  		{%>
			  		<!--  -->
			  			<li class="page-item active"><a href="boardList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp %></a></li>
			  		<%}else
			  		{%>
			  			<li class="page-item"><a href="boardList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp %></a></li>
			  		<%}
			  	}
			  	
			  	//다음
			  	if(endPage<totalPage)
			  	{%>
			  		<li class="page-item">
					    <a class="page-link" href="boardList.jsp?currentPage=<%=endPage+1%>">Next</a>
					</li>
			  	<%}
			  %>

			</ul>
		</nav>
	</div>
	
	
		
	</div>

</body>
</html>