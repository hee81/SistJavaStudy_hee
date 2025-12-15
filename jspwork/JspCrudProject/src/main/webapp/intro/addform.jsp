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
	//두번째 전화번호칸에 4자리만 입력하면 hp3로 넘어가도록 한다.
	function goFocus(hp) {
		if(hp.value.length==4)
			frm.hp3.focus();
	}
</script>
</head>
<body>
<div style="width: 600px; margin: 100px 150px;">
	<form action="addaction.jsp" method="post" name="frm">
		<table class="table table-bordered">
			<tr>
				<th style="text-align: center;" class="table-secondary">이름</th>
				<td>
					<input type="text" name="name" class="form-control" style="width: 120px;" required="required">
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">생년월일</th>
				<td>
					<input type="date" name="birthday" class="form-control" style="width: 200px;" value="1999-01-01">
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">전화번호</th>
				<td class="input-group mb-3">
					<select size="1" name="hp1" class="form-control" style="width: 80px;">
						<option value="02">02</option>
						<option value="010">010</option>
						<option value="017">017</option>
						<option value="032">032</option>
						<option value="019">019</option>
					</select>
					&nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
					<input type="text" name="hp2" class="form-control" style="width: 80px;" required="required" onkeyup="goFocus(this)">
					&nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
					<input type="text" name="hp3" class="form-control" style="width: 80px;" required="required">
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">출신지역</th>
				<td>
					<label><input type="radio" name="hometown" value="서울" checked="checked">서울 &nbsp;</label>
					<label><input type="radio" name="hometown" value="경기">경기 &nbsp;</label>
					<label><input type="radio" name="hometown" value="인천">인천 &nbsp;</label>
					<label><input type="radio" name="hometown" value="강원">강원 &nbsp;</label>
					<label><input type="radio" name="hometown" value="경상">경상 &nbsp;</label>
					<label><input type="radio" name="hometown" value="전라">전라 &nbsp;</label>
					<label><input type="radio" name="hometown" value="제주">제주 &nbsp;</label>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">취미</th>
				<td>
					<label><input type="checkbox" name="hobby" value="게임">게임 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="넷플릭스">넷플릭스 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="공부">공부 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="여행">여행 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="코딩">코딩 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="쇼핑">쇼핑 &nbsp;</label>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">MBTI</th>
				<td>
					<select name="mbti" class="form-control" style="width: 120px;">
						<option value="ESTP">ESTP</option>
						<option value="ENFJ">ENFJ</option>
						<option value="ESTJ">ESTJ</option>
						<option value="ISFP">ISFP</option>
						<option value="INTJ">INTJ</option>
						<option value="ISTP">ISTP</option>
					</select>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">하고싶은 말</th>
				<td>
					<textarea style="width: 500px; height: 80px;" name="free" 
					required="required" placeholder="자신의 성향이나 성격등을 자유롭게 작성하세요"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info" style="width: 100px;">작성완료</button>
					<button type="button" class="btn btn-info" style="width: 100px;"
					 onclick="location.href='introlist.jsp'">뒤로가기</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>

















