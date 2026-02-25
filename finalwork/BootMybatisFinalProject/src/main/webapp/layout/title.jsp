<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function(){
		//ajax모달에 있는 ajax로그인 아이디,비번얻기
		$("#btnloginok").click(function(){
			var id=$("#loginid").val();
			var pass=$("#loginpass").val();
			//alert(id+","+pass);
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"/member/login", // /member/ 절대패스 반드시 해줄 것!!
				data:{"id":id,"pass":pass},
				success:function(res){
					if(res.result=="fail")
						alert("아이디,비번이 맞지 않습니다");
					else
						location.reload();
				}
			});
		});
		
		//로그아웃
		$("#btnlogout").click(function(){
			$.ajax({
				type:"get",
				dataType:"html",
				url:"/member/logout",
				success:function(){
					location.reload();
				}
			})
		})
	})

</script>
<title>title</title>
</head>

<!-- 절대경로 -->
<c:set var="root" value="${pageContext.request.contextPath }"/>

<body>

<!-- 제목 로고 -->
<a href="${root} "><img src="${root }/image2/title_two.png"></a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<c:if test="${sessionScope.loginok==null}">
	<button type="button" class="btn btn-success" onclick="location.href='${root}/login/main'">Login</button>
</c:if>
<c:if test="${sessionScope.loginok!=null}">
	<b>${sessionScope.myid}님 로그인 중</b>
	<button type="button" class="btn btn-danger" onclick="location.href='${root}/login/main'">Logout</button>
</c:if>

<!-- ajax로그인 -->
<c:if test="${sessionScope.loginok==null}">
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
	  Ajax 로그인
	</button>
</c:if>
<c:if test="${sessionScope.loginok!=null}">
	<b>${sessionScope.loginname}님 로그인 중</b>
	<button type="button" class="btn btn-danger" data-bs-toggle="modal" id="btnlogout">
	  Ajax 로그아웃
	</button>
</c:if>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       	<input type="text" class="form-control" style="width: 150px;" placeholder="로그인 아이디" id="loginid">
       	<input type="text" class="form-control" style="width: 150px;" placeholder="로그인 패스워드" id="loginpass">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="btnloginok">Login</button>
      </div>
    </div>
  </div>
</div>

<!-- 메뉴 -->
<ul class="nav">
    <li class="nav-item">
        <a class="nav-link text-dark" href="${root}/">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link text-dark" href="${root}/ipgo/list">상품목록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link text-dark" href="${root}/member/form">회원가입</a>
    </li>
    <li class="nav-item">
        <a class="nav-link text-dark" href="${root}/member/list">회원목록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link text-dark" href="${root}/board/list">회원게시판</a>
    </li>
    <li class="nav-item">
        <a class="nav-link text-dark" href="${root}/login/main">로그인</a>
    </li>
    <li class="nav-item">
        <a class="nav-link text-dark" href="${root}/member/myinfo">나의정보</a>
    </li>
</ul>


</body>
</html>