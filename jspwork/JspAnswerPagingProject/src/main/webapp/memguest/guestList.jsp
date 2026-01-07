<%@page import="memanswer.AnswerDao"%>
<%@page import="memanswer.AnswerDto"%>
<%@page import="login.LoginDao"%>
<%@page import="memguest.MemGuestDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="memguest.MemGuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js" integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
	div.answer{
		cursor: pointer;
	}
	span.day{
		color: gray;
		float:right;
		font-size: 0.9em;
	}
	i.aupdate,i.adel{
		cursor: pointer;
		color: orange;
		font-weight: bold;
	}
</style>
<script type="text/javascript">
	$(function(){
		
		//전체댓글이랑 입력창 안보이게 하기
		$("div.answer").next().hide();
		
		//댓글 부분 클릭이벤트
		//클릭한 부분의 다음태그(div show/hide 반복)
		$("div.answer").click(function(){
			//모든 댓글태그 다음 숨기기
			$(this).next().toggle();
		})
		
		//댓글삭제
		$("i.adel").click(function(){
			
			var a=confirm("정말 삭제하실건가요??");
			
			if(a){
				var idx=$(this).attr("idx");
				//alert(idx);	

				$.ajax({
					type:"post",
					url:"../memanswer/answerDelete.jsp",
					dataType:"html",
					data:{"idx":idx},
					success:function(){
						//새로고침
						swal("삭제성공!", "You clicked the button!", "success")
						.then(function(){
							location.reload();
						})
					}
				})
			}
		})
		
		//댓글수정버튼 누르면 모달창뜨도록!
		$("i.aupdate").click(function(){
			
			var idx=$(this).attr("idx");
			//alert(idx);
			
			
			//댓글 수정폼의 hidden idx에 idx 넣어주기
			$("#idx").val(idx);
			
			//json으로 본 memo를 수정창안에 넣어주기
			$.ajax({
				type:"get",
				url:"../memanswer/answerMemo.jsp",
				dataType:"json",
				data:{"idx":idx},
				success:function(res){
					$("#memo").val(res.memo);
				}
			})
			
			$("#updateAnsModal").modal('show');
		});
		
		//**모달창에 댓글수정하기 누르면 해당 idx의 메모값 수정후 성공시 새로고침(idx,memo 둘다 넘어가야함!)**
		$(".ansupdate").click(function(){
			
			var idx=$("#idx").val();
			var memo=$("#memo").val();
			//alert(idx+","+memo);
			
			$.ajax({
				type:"post",
				url:"../memanswer/answerUpdate.jsp",
				dataType:"html",
				data:{"idx":idx,"memo":memo},
				success:function(){
					location.reload();
				}
			})
			
		})
		
	})
</script>
</head>
<%
	//dao선언
	MemGuestDao dao=new MemGuestDao();
	//totalCount로 총 글 출력하기
	int totalCount=dao.getTotalCount();
	
	//list출력
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//페이징에 필요한 변수들
	int perPage=3; //한 페이지에 보여질 글 갯수
	int perBlock=3; //한 블럭에 보여질 페이지 갯수
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
	//총페이지갯수/한페이지에 보여질 글 갯수 (7/5=1) (totalCount/perPage+나머지)
	//나머지가 한개라도 남아있다면 무조건 1페이지 추가해야함 (1+1=2페이지 필요) (totalCount%perPage==0?0:1)
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
	List<MemGuestDto> list=dao.getPagingList(startNum, perPage);
	
%>
<body>

	<jsp:include page="guestForm.jsp"/>
	<hr>
	
	<div style="margin-left: 100px; width: 500px;">
		<b>총 <%=totalCount %>개의 방명록 글이 있습니다</b>
		<br><br>
		 <%
		 LoginDao logdao=new LoginDao();
		 
		 for(MemGuestDto dto:list){
			 
			 String name=logdao.getName(dto.getMyid());
		 %>
			 <table class="table table-bordered" style="margin: 10px 10px ; width: 400px;">
				
				 <tr height="130" >
				 	<td style="position: relative; padding-top: 25px;">
				 	
				 	
				 	
			 			<!-- 로그인한 본인이 쓴 글의 수정,삭제버튼만 보여야 한다 -->
				 		<div style="position: absolute; top: 0; left: 10;">
					 		<%	
					 			//현재 로그인한 상태
					 			String loginok=(String)session.getAttribute("loginok");
					 			//로그인(세션)
					 			String sessionId=(String)session.getAttribute("idok");
								//로그인 중이면서 로그인한 아이디와 글쓴 아이디가 같다면
					 			if(loginok!=null && sessionId.equals(dto.getMyid())){%>
					 			
					 			<span style="color: green; float: right; size: 2em;" >
					 				<i class="bi bi-pencil-square" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'"></i>
					 				<i class="bi bi-trash3" onclick="location.href='delete.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'"></i>
					 			</span>
					 			<input type="hidden" name="num" value=<%=dto.getNum()%>>
					 			<input type="hidden" name="currentPage" value=<%=currentPage%>>
					 			<%}
					 		%>
					 	</div>
				 		
				 		
				 		
				 		<!-- 공통으로 출력될 데이터(이름,작성일,사진,본문) -->
				 		<b><%=name %> (<%=dto.getMyid() %>) </b>
				 		<span style="float: right; color: gray"><%=sdf.format(dto.getWriteday()) %></span><br>		
				 		<%
				 			if(!dto.getPhoto().equals("no")){%>
				 				<img src="../save/<%=dto.getPhoto()%>" style="max-width: 100px;" align="left" hspace="20"><br>
				 			<%}
				 		%>
				 		<div class="content"><%=dto.getContent().replace("\n", "<br>") %></div>



				 		<!-- 1/6 댓글창 추가 -->
				 		<div style="clear: both;"></div>
				 		<div class="answer" >
				 		<%
				 			AnswerDao tadao=new AnswerDao();
				 			int total=tadao.totalAnswer(dto.getNum());
				 		%>
				 		댓글 <%=total %>
				 		</div>
				 		<div class="list">
				 			목록출력<br>
				 			
			 			<%
			 				AnswerDao adao=new AnswerDao();
			 				SimpleDateFormat sdf2=new SimpleDateFormat("yy-MM-dd HH:mm");
			 			
			 				List<AnswerDto> alist=adao.getAllAnswers(dto.getNum());
			 				
			 				for(int i=0;i<alist.size();i++)
			 				{
			 					AnswerDto adto=alist.get(i);
			 					//댓글쓴 사람이름
			 					String writer=logdao.getName(adto.getMyid());	
			 				%>
			 					 					
			 					<%=writer %>(<%=adto.getMyid() %>) : 							 					
			 					<%=adto.getMemo() %>
			 					
			 					<!-- 댓글 작성자만 수정,삭제 아이콘 보이도록 한다 -->
				 				<%
				 				if(sessionId.equals(dto.getMyid()))
				 				{%>
				 					<!-- ajax로 하려면 idx값 주어야 함!!!!! -->
				 					<i class="bi bi-pencil-fill aupdate" idx="<%=adto.getIdx()%>"></i>
					 				<i class="bi bi-x-circle adel" idx="<%=adto.getIdx()%>"></i>
				 				<%}
				 				%>
				 				
				 				<span class="day"><%=sdf2.format(adto.getWriteday()) %></span>
			 					<br>
			 				<%
			 				
			 				}
			 				
		 				%>
				 		</div>
				 			
				 			
				 			
				 		<!-- 회원만 댓글작성가능&댓글창 내용 확인가능 -->	
				 		<%	
				 			//현재 로그인한 상태
				 			String loginoka=(String)session.getAttribute("loginok");
							
				 			if(loginoka!=null){%>
				 				<form action="../memanswer/answerAddAction.jsp" method="post">
					 				<div class="input-group">
					 					<input type="text" name="memo" 
					 					class="form-control" required="required" 
					 					placeholder="댓글을 입력하세요" style="width: 250px;">		
					 						
					 					&nbsp;&nbsp;&nbsp;
					 					
					 					<button type="submit" class="btn btn-info btn-sm">저장</button>
					 					<input type="hidden" name="num" value=<%=dto.getNum()%>>
					 					<input type="hidden" name="myid" value=<%=sessionId%>>
					 					<input type="hidden" name="currentPage" value=<%=currentPage%>>
					 				</div>
					 			</form>
				 			<%}
				 		%>	
						
				 		
				 		</td>
			 		</tr>
			 </table>
		 <%}
		 %>	  
	</div>



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
				    	<a class="page-link" href="guestList.jsp?currentPage=<%=startPage-1%>">Previous</a>
				    </li>
			  	<%}
			  
				//현재(active css클래스 추가),그외 구분필요
			  	for(int pp=startPage;pp<=endPage;pp++)
			  	{
			  		if(pp==currentPage)
			  		{%>
			  		<!--  -->
			  			<li class="page-item active"><a href="guestList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp %></a></li>
			  		<%}else
			  		{%>
			  			<li class="page-item"><a href="guestList.jsp?currentPage=<%=pp%>" class="page-link"><%=pp %></a></li>
			  		<%}
			  	}
			  	
			  	//다음
			  	if(endPage<totalPage)
			  	{%>
			  		<li class="page-item">
					    <a class="page-link" href="guestList.jsp?currentPage=<%=endPage+1%>">Next</a>
					</li>
			  	<%}
			  %>

			</ul>
		</nav>
	</div>
	
	
	<!-- Modal -->
	<div class="modal fade" id="updateAnsModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="staticBackdropLabel">댓글수정창</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<input type="hidden" id="idx" value="">
	        <input type="text" class="form-control" id="memo">
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary ansupdate">댓글수정하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	 
	
</body>
</html>