<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>content</title>
<script type="text/javascript">
	//댓글출력
	




	//댓글삭제
	$("i.del").click(function(){
		var idx=$(this).attr("idx");
		//alert(idx);
		
		//비번입력
		var pass=prompt("비밀번호를 입력해주세요");
		alert(pass);
		if(pass==null)
			return; //취소시 함수종료
		
			$.ajax({
				type:"get",
				dataType:"json",
				url:"adelete",
				data:{"idx":idx,"pass":pass},
				success: function(res){
					if(res.check==0){
						alert("비밀번호가 틀렸습니다");
					}else{
						alert("댓글이 삭제되었습니다");
						location.reload();
					}
				}
			})
		
	})
</script>

</head>
<body>

	<table class="table table-bordered" style="width: 600px; margin: 30px 30px;">
		<tr>
			<td>
				<h3>제목:${dto.subject }</h3>
				<span style="float: right">조회:${dto.readcount }&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/></span>
				<br>
				<h5>작성자:${dto.writer }</h5>
			</td>
		</tr>
		<tr>
			<td>
				<pre>${dto.content }</pre>
				<br><br>
				<c:if test="${dto.photo.equals('no') }">
					사진없음
				</c:if>
				<c:if test="${dto.photo != 'no' }">
					<c:forTokens items="${dto.photo }" delims="," var="photo">
						<a href="../photo/${photo }">
							<img alt="" src="../photo/${photo }" style="width: 100px; height: 100px;">
						</a>
					</c:forTokens>
				</c:if>
			</td>
		</tr>
		
		<!-- 댓글추가 -->
		<tr>
			<td>
				<div id="alist">
					<b>댓글  ${acount }</b><br><br>
		           <c:forEach var="a"  items="${alist }">
		           <i class="bi bi-person-circle"></i>
		             ${a.nickname }: ${a.content } &nbsp;&nbsp;
		             <span style="color: gray; font-size: 0.9em;"><fmt:formatDate value="${a.writeday }" pattern="yyyy-MM-dd"/>  </span>
		             <i class="amod bi bi-pencil-square" style="cursor: pointer;"></i>
		             <i class="adel bi bi-file-earmark-x" style="cursor: pointer;" idx="${a.idx }"></i><br>
		           </c:forEach>
				
				</div>
				
				<form action="ainsert" method="post">
					<div class="d-flex">
						<input type="text" name="nickname" class="form-control" style="width:120px;" placeholder="닉네임">
						<input type="password" name="pass" class="form-control" style="width:120px;" placeholder="비밀번호">
					</div>
					<div class="d-flex">
						<input type="text" name="content" class="form-control" style="width:500px;" placeholder="댓글입력">
						<button type="submit" class="btn btn-outline-success btn-sm">확인</button>	
					</div>
					<input type="hidden" name="num" value="${dto.num }">
					<input type="hidden" name="currentPage" value="${currentPage}">
				</form>
			</td>
		</tr>
		
		
		
		
		<tr>
			<td align="right">	
				<button type="button" class="btn btn-outline-primary btn-sm" onclick="location.href='addform'">글쓰기</button>
				<button type="button" class="btn btn-outline-warning btn-sm" onclick="location.href='upassform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
				<button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='dpassform?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
				<button type="button" class="btn btn-outline-info btn-sm" onclick="location.href='list?currentPage=${currentPage}'">목록으로</button>
			</td>	
		</tr>
	</table>

</body>
</html>