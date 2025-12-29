<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myboard.BoardDto"%>
<%@page import="myboard.BoardDao"%>
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
<style type="text/css">
	table.detail{
		width: 500px;
		margin: 50px 50px;
	}
	caption{
		color: black;
		font-size: 1.5em;
	}
	span.aday{
		float: right;
	}
</style>
<script type="text/javascript">
	$(function() {
		var num=$("#num").val();
		//alert(num);
		
		list();
		
		//댓글 insert
		$("#btnSend").click(function(){
			
			var nickname=$("#nickname").val();
			var comment=$("#comment").val();
			
			//null체크
			if(nickname==''){
				alert('닉네임을 입력하세요');
				return;
			}
			if(comment==''){
				alert('댓글을 입력하세요');
				return;
			}
			
			var data="num="+num+"&nickname="+nickname+"&comment="+comment;
			//alert(data);
			
			$.ajax({
				type:"post",
				url:"../myboardanswer/insertAnswer.jsp",
				dataType:"html",
				data:data,
				success:function(){
					//alert("저장 성공")
					$("#nickname").val("");
					$("#comment").val("");
					list();
				}
			})
			
			
		})
		
		
		function list(){
			
			$.ajax({
				type:"get",
				url:"../myboardanswer/listAnswer.jsp",
				dataType:"json",
				data:{"num":num},
				success:function(res){
					
					//댓글갯수출력
					$(".acount>span").html(res.length);
					
					//댓글출력
					var s="";
					if(res.length==0)
						s+="댓글이 없습니다.";
					else{
						$.each(res,function(i,elt){
							s+="<div>";
							s+="<i class='bi bi-person-circle'></i>"
							s+=elt.nickname+" : "+elt.comment+"&nbsp;";
							s+="<span class='aday'>"+elt.writeday+"</span>";
							s+="<i class='bi bi-pencil-square'></i>";
							s+="<i class='bi bi-x-circle'></i>";
							s+="</div>";
						})
					}				
					$(".alist").html(s);
					
				}
			})
		}
	})
</script>
</head>
<% 
	String num=request.getParameter("num");

	BoardDao dao=new BoardDao();
	dao.updateReadCount(num);
	BoardDto dto=dao.getOneData(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<body>

<input type="hidden" id="num" value="<%=num%>">

<div>
	<table class="table table-bordered detail">
		<caption align="top"><%=dto.getSubject() %></caption>
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span><%=sdf.format(dto.getWriteday()) %></span> &nbsp;&nbsp;
				<span>조회: <%=dto.getReadcount() %></span> 
			</td>
		</tr>
		<tr>
			<td><%=dto.getContent().replace("\n", "<br>")%></td>
		</tr>
		
		<!-- 댓글 -->
		<tr>
			<td>
				<b class="acount">댓글 <span>0</span></b>
				<div class="alist">
					댓글목록...
				</div>
				<div class="aform input-group">
					<input type="text" id="nickname" class="form-control" style="width: 120px;" placeholder="닉네임">&nbsp;&nbsp;
					<input type="text" id="comment" class="form-control" style="width: 200px;" placeholder="댓글을 입력하세요">&nbsp;&nbsp;
					<button type="button" id="btnSend" class="btn btn-info">저장</button>
				</div>
			</td>
		</tr>
		
		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='insertForm.jsp'">글쓰기</button>	
				<button type="button" class="btn btn-outline-success" onclick="location.href='updatePassForm.jsp?num=<%=dto.getNum()%>'">수정</button>
				<button type="button" class="btn btn-outline-danger" onclick="location.href='deletePassForm.jsp?num=<%=dto.getNum()%>'">삭제</button>
				<button type="button" class="btn btn-outline-info" onclick="location.href='boardlist.jsp'">목록</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>