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
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style type="text/css">
	#showimg{
		width: 130px;
		height: 160px;
		border: 1px solid gray;
	}
</style>
<script type="text/javascript">
	$(function(){
		
		//버튼 누르면 사진 불러오기
		$("#btnphoto").click(function(){
			$("#myphoto").trigger("click");
		})
		
		//사진 불러오면 미리보기
	    $("#myphoto").on('change', function(e) {
	        let file = e.target.files[0]; // 선택된 파일 가져오기
	        
	        // 이미지 파일인지 확인 (MIME 타입)
	        if (file && file.type.match('image.*')) {
	            let reader = new FileReader();
	            
	            // 파일 읽기가 완료되면 실행
	            reader.onload = function(e) {
	                // 미리보기 영역에 img 태그 추가
	                $('#showimg').html('<img src="' + e.target.result + '" style="max-width: 140px; max-height: 150px;">');
	            }
	            reader.readAsDataURL(file); // 파일 내용을 data URL로 읽기
	        } else {
	            alert("이미지 파일만 선택할 수 있습니다.");
	        }
	    });
		
		
		//중복체크 누르면 아이디 체크
		$("#btnidcheck").click(function(){
			var myid=$("#loginid").val();
			//alert(myid);
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"idcheck",
				data:{"id":myid},
				success:function(res){
					if(res.checkcount==0)
						$("span.idsucess").text("ok");
					else
						$("span.idsucess").text("중복된 아이디!");
				}
			})
		})
		
		//2번째 비밀번호 입력시 체크
		$("#pass2").keyup(function(){
			
			var p1=$("#pass").val();
			var p2=$(this).val();
			
			if(p2.length < p1.length){
			       $("span.passsuccess").text("");
			       return;
			   }
			
			if(p1==p2)
				$("span.passsucess").text("ok");
			else{
				$("span.passsucess").text("비밀번호 다름");
				$("#pass2").val('');
			}
				
			
		})

	});
	
	//submit하기전에 호출
	function check(){
		//사진
		if($("#myphoto").val()==''){
			alert("사진을 넣어주세요")
			return false;
		}
		//중복체크
		if($("span.idsucess").text()!="ok"){
			alert("아이디 중복체크해주세요")
			return false;
		}
		
		//비밀번호체크
	    if($("span.idsucess").text()!="ok"){
	        alert("비밀번호가 서로 다릅니다.");
	        return false;
	    }
	    
	    return true; // 모든 검사를 통과하면 전송
	}
</script>

<title>memberform</title>
</head>
<body>

<div class="container">
    <form action="/member/insert" method="post" enctype="multipart/form-data" onsubmit="return check()">
        <table>
            <caption align="top">회원가입</caption>
            <tr>
                <td>
                    <div>
                        <div id="showimg"></div>
                    </div>
                    <input type="file" name="myphoto" id="myphoto" style="display: none;" >
                    <button type="button" class="btn btn-outline-secondary" id="btnphoto">사진 선택</button>
                </td>
 
                <td>
                    <div>
                        <div class="input-group">
                            <input type="text" class="form-control" name="id" id="loginid" placeholder="아이디" required>
                            <button class="btn btn-dark" type="button" id="btnidcheck">중복확인</button>
                        </div>
                        &nbsp; &nbsp; &nbsp;
                        <span class="idsucess" style="width: 100px; color: green;"></span>
                    </div>
                    
                    <div>
                        <input type="text" class="form-control" name="name" placeholder="이름을 입력하세요" required>
                    </div>

                    <div>
                        <input type="password" class="form-control" name="pass" id="pass" placeholder="비밀번호" required>
                        <input type="password" class="form-control" name="pass2" id="pass2" placeholder="비밀번호확인" required>
                        &nbsp; &nbsp; &nbsp;
                        <span class="passsucess" style="width: 100px; color: green;"></span>
                    </div>

                    <div>
                        <input type="email" class="form-control" name="email" placeholder="이메일입력" required>
                    </div>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <div><button type="submit" class="btn btn-primary">회원가입 완료</button></div>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>