<%@page import="intro.IntroDao"%>
<%@page import="intro.IntroDto"%>
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
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	String name=request.getParameter("name");
	String birthday=request.getParameter("birthday");
	String hp=request.getParameter("hp1")+"-"+request.getParameter("hp2")+"-"+request.getParameter("hp3");
	String hometown=request.getParameter("hometown");
	String [] hobby=request.getParameterValues("hobby");
	String mbti=request.getParameter("mbti");
	String free=request.getParameter("free");	
	String num=request.getParameter("num");
	String hb="";
	if(hobby==null)
		hb="no";
	else
	{
		for(int i=0;i<hobby.length;i++)
		{
			hb+=hobby[i]+",";
		}
		/* substring(시작인덱스,끝인덱스)-원하는 부분 잘라서 가져오기! 마지막, 빼고 가져와야하기에 hb.length()-1로 작성 */
		hb=hb.substring(0, hb.length()-1);
	}
	
	//dto선언 후 잘 묶어주기
	IntroDto dto=new IntroDto();
	dto.setName(name);
	dto.setBirthday(birthday);
	dto.setHp(hp);
	dto.setHometown(hometown);
	dto.setMbti(mbti);
	dto.setFree(free);
	dto.setHobby(hb);
	dto.setNum(num);
	
	//update메서드 호출
	IntroDao dao=new IntroDao();
	dao.updateIntro(dto);
	
	//디테일폼으로 넘어가려면 num이 필요함.
	response.sendRedirect("detailpage.jsp?num="+num);
%>
</body>
</html>