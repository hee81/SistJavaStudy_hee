<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">

	$(function(){
		
		//아이디 충복체크
		$("#btncheck").click(function(){
			//id읽기
			var id=$("#id").val();
			//alert(id);
			
			$.ajax({
				type:"get",
				url:"member/idcheck.jsp",
				dataType:"json",
				data:{"id":id},
				success:function(res){
					alert(res.count)
					if(res.count==1){
						$("span.idsuccess").text("가입불가");
						$("#id").val(''); /* 유효성체크에서 반드시 있어야 하는 코드!!! */
					}else{
						$("span.idsuccess").text("가입가능");
					}
				}
			});
		})
		
		//email
		$("#selemail").change(function(){
			if($(this).val()=='-'){
				$("#email2").val('');
			}else{
				$("#email2").val($(this).val());
			}
		});
		
		
	})

	function check(f) 
	{
		if(f.pass.value!=f.pass2.value){
			alert("비밀번호가 다릅니다");
			f.pass.value='';
			f.pass2.value='';
			return false; //action을 호출하지 않는다.
			
		}
	}
</script>
</head>
<body>
<div>
	<!-- id,pass 유효성체크 후 submit이 되어야한다!! > onsubmit 필수 -->
   <form action="member/memberadd.jsp" method="post" onsubmit="return check(this)">
	
<table class="table table-bordered" style="width: 500px; margin-left: 200px;"> 

	<caption align="top"><b>회원 가입</b></caption>
	<tr>
		<th width="100" class="table-secondary">아이디</th>
		<td align="left">
		  <div class="d-flex gap-2">
		  	<!-- 자바스트립트 함수 처리를 위해 id 꼭 추가 되어야한다! -->
			<input type="text" name="id" id="id" maxlength="8" class="form-control"
				required="required" style="width: 120px;">
			<button type="button" class="btn btn-danger" id="btncheck">중복체크</button>	
			<span class="idsuccess"></span>
		</div>
		</td>
	</tr>
	<tr>
		<th width="100" class="table-secondary">비밀번호</th>
		<td>
		  <div class="d-flex gap-2">
			<input type="password" name="pass" class="form-control" required="required" style="width: 120px;" placeholder="비밀번호">
			<input type="password" name="pass2" class="form-control" required="required" style="width: 120px;" placeholder="비밀번호확인">
			<span class="passsuccess"></span>
		  </div>
		</td>
	</tr>
	<tr>
		<th width="100" class="table-secondary">이름</th>
		<td>
			<input type="text" name="name"  class="form-control"
				required="required" style="width: 120px;">			
		</td>
	</tr>
	<tr>
		<th width="100" class="table-secondary">핸드폰</th>
		<td>
			<input type="text" name="hp"  class="form-control"
				required="required" style="width: 200px;">			
		</td>
	</tr>
	<tr>
		<th width="100" class="table-secondary">주소</th>
		<td>
			<input type="text" name="addr"  class="form-control"
				required="required" style="width: 400px;">			
		</td>
	</tr>
	<tr>
		<th width="100" class="table-secondary">이메일</th>
		<td>
		  <div class="d-flex gap-2"> <!-- input 가로로 2개 놓을 때 class(강사님gpt 물어보심)  -->
			<input type="text" name="email1"  class="form-control" required="required" style="width: 80px;">	
			<b>@</b>
			<input type="text" name="email2" id="email2" class="form-control" required="required" style="width: 150px;">	
			<select id="selemail" class="form-control">
				<option value="-">직접입력</option>
				<option value="naver.com">네이버</option>
				<option value="nate.com">네이트</option>
				<option value="gmail.com">구글</option>
				<option value="hanmail.net">다음</option>				
			</select>
		   </div>	
		</td>
	</tr>
	<tr>
		<td align="center" colspan="2">
			<button type="submit" class="btn btn-secondary" style="width: 100px;">저장하기</button>
			<button type="reset" class="btn btn-secondary" style="width: 100px;">다시하기</button>
		</td>		
	</tr>
</table>
</form>

   
</div>
</body>
</html>