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
<style type="text/css">

</style>
</head>
<script type="text/javascript">
	$(function(){
		
	})

</script>

<body>
	<h1>회원가입폼</h1>
	<form action="memberInsertAction.jsp" method="post" id="joinForm" style="max-width:650px;">
	  <table class="table">
	    <tr>
	      <th style="width:150px;">이름</th>
	      <td><input type="text" name="name" class="form-control" required></td>
	    </tr>
	
	    <!-- 아이디 + 중복확인(AJAX) -->
	    <tr>
	      <th>아이디</th>
	      <td>
	        <div style="display:flex; gap:8px; align-items:center;">
	          <input type="text" name="id" id="memId" class="form-control" required>
	          <button type="button" class="btn btn-outline-secondary" id="btnIdCheck" style="white-space:nowrap;">
	            중복확인
	          </button>
	        </div>
	        <small id="idMsg"></small>
	
	        <!-- 서버 제출 시 "중복확인 완료" 여부 -->
	        <input type="hidden" id="idChecked" value="0">
	      </td>
	    </tr>
	
	    <!-- 비밀번호 + 비밀번호확인(오른쪽) -->
	    <tr>
	      <th>비밀번호</th>
	      <td>
	        <div style="display:flex; gap:8px; align-items:center;">
	          <input type="password" name="pass" id="pass" class="form-control" required>
	          <input type="password" id="pass2" class="form-control" placeholder="비밀번호 확인" required>
	        </div>
	        <small id="passMsg"></small>
	      </td>
	    </tr>
	
	    <tr>
	      <th>휴대폰</th>
	      <td><input type="text" name="hp" class="form-control" placeholder="010-1234-5678" required></td>
	    </tr>
	
	    <tr>
	      <th>주소</th>
	      <td><input type="text" name="addr" class="form-control" required></td>
	    </tr>
	
	    <!-- 이메일 -->
	    <tr>
	      <th>이메일</th>
	      <td>
	        <div style="display:flex; gap:8px; align-items:center;">
	          <input type="text" id="emailId" class="form-control" placeholder="이메일 아이디" style="max-width:180px;" required>
	          <span>@</span>
	          <select id="emailDomain" class="form-select" style="max-width:200px;">
	            <option value="naver.com">naver.com</option>
	            <option value="gmail.com">gmail.com</option>
	            <option value="daum.net">daum.net</option>
	            <option value="kakao.com">kakao.com</option>
	          </select>
	          <input type="hidden" name="email" id="emailFull">
	        </div>
	      </td>
	    </tr>
	
	    <tr>
	      <td colspan="2" style="text-align:center;">
	        <button type="submit" class="btn btn-primary">회원가입</button>
	      </td>
	    </tr>
	  </table>
	</form>
</body>
</html>