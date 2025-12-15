<%@page import="java.util.StringTokenizer"%>
<%@page import="intro.IntroDto"%>
<%@page import="intro.IntroDao"%>
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
<%
	String num=request.getParameter("num");
	IntroDao dao=new IntroDao();
	IntroDto dto=dao.getOneIntro(num);
%>
</head>
<body>
<div style="width: 600px; margin: 100px 150px;">
	<form action="updateaction.jsp" method="post" name="frm">
	<!-- hidden 꼭 넣기!! -->
	<input type="hidden" name="num" value="<%=num%>">
		<table class="table table-bordered">
			<tr>
				<th style="text-align: center;" class="table-secondary">이름</th>
				<td>
					<input type="text" name="name" class="form-control" style="width: 120px;" value="<%=dto.getName()%>">
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">생년월일</th>
				<td>
					<input type="date" name="birthday" class="form-control" style="width: 200px;" required="required" value="<%=dto.getBirthday() %>">
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">전화번호</th>
				<td class="input-group mb-3">
					<select size="1" name="hp1" class="form-control" style="width: 80px;">
						<%
							//하이픔을 구분자로 분리
							//StringTokenizer st = new StringTokenizer(문자열, 구분자);
							StringTokenizer st=new StringTokenizer(dto.getHp(),"-");
							String hp1=st.nextToken();
							String hp2=st.nextToken();
							String hp3=st.nextToken();
						
							String [] hpstr={"02","010","017","032","019"};
						
							for(int i=0;i<hpstr.length;i++)
							{
								if(hp1.equals(hpstr[i]))
								{%>
									<option value="<%=hpstr[i]%>" selected="selected"><%=hpstr[i]%></option>
								<%}
								else
								{%>
									<option value="<%=hpstr[i]%>"><%=hpstr[i]%></option>
								<%}
							}
						%>
					</select>
					&nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
					<input type="text" name="hp2" class="form-control" style="width: 80px;" value="<%=hp2%>">
					&nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
					<input type="text" name="hp3" class="form-control" style="width: 80px;" value="<%=hp3%>">
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">출신지역</th>
				<td>
					<label><input type="radio" name="hometown" value="서울" <%=dto.getHometown().equals("서울")?"checked":"" %>>서울 &nbsp;</label>
					<label><input type="radio" name="hometown" value="경기" <%=dto.getHometown().equals("경기")?"checked":"" %>>경기 &nbsp;</label>
					<label><input type="radio" name="hometown" value="인천" <%=dto.getHometown().equals("인천")?"checked":"" %>>인천 &nbsp;</label>
					<label><input type="radio" name="hometown" value="강원" <%=dto.getHometown().equals("강원")?"checked":"" %>>강원 &nbsp;</label>
					<label><input type="radio" name="hometown" value="경상" <%=dto.getHometown().equals("경상")?"checked":"" %>>경상 &nbsp;</label>
					<label><input type="radio" name="hometown" value="전라" <%=dto.getHometown().equals("전라")?"checked":"" %>>전라 &nbsp;</label>
					<label><input type="radio" name="hometown" value="제주" <%=dto.getHometown().equals("제주")?"checked":"" %>>제주 &nbsp;</label>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">취미</th>
				<td>
					<label><input type="checkbox" name="hobby" value="게임" <%=dto.getHobby().contains("게임")?"checked":""%>>게임 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="넷플릭스" <%=dto.getHobby().contains("넷플릭스")?"checked":""%>>넷플릭스 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="공부" <%=dto.getHobby().contains("공부")?"checked":""%>>공부 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="여행" <%=dto.getHobby().contains("여행")?"checked":""%>>여행 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="코딩" <%=dto.getHobby().contains("코딩")?"checked":""%>>코딩 &nbsp;</label>
					<label><input type="checkbox" name="hobby" value="쇼핑" <%=dto.getHobby().contains("쇼핑")?"checked":""%>>쇼핑 &nbsp;</label>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">MBTI</th>
				<td>
					<select name="mbti" class="form-control" style="width: 120px;">
					<%
						String [] mstr={"ESTP","ENFJ","ESTJ","ISFP","INTJ","ISTP"};
					
						for(int i=0;i<mstr.length;i++)
						{
							if(dto.getMbti().equals(mstr[i]))
							{%>
								<option value="<%=mstr[i]%>" selected="selected"><%=mstr[i]%></option>
							<%}
							else
							{%>
								<option value="<%=mstr[i]%>"><%=mstr[i]%></option>
							<%}
						}
					%>
					</select>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-secondary">하고싶은 말</th>
				<td>
					<textarea style="width: 500px; height: 80px;" name="free" 
					required="required" placeholder="자신의 성향이나 성격등을 자유롭게 작성하세요"><%=dto.getFree() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success" style="width: 100px;">수정완료</button>
					<button type="button" class="btn btn-success" style="width: 100px;"
					 onclick="location.href='introlist.jsp'">뒤로가기</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
