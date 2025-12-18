<%@page import="java.io.File"%>
<%@page import="simpleBoard.BoardDao"%>
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
	//num읽기
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	//dao선언
	BoardDao dao=new BoardDao();
	
	boolean b=dao.isEqualPass(num, pass);
	
	if(b)
	{
		//게시글을 지우기전에 업로드한 이미지 삭제
		String imgName=dao.getOneData(num).getImgname();
		//업로드 경로 구하기
		String uploadPath=getServletContext().getRealPath("/save");
		//파일생성_save 경로에 있는 선택한 사진 
		File file=new File(uploadPath+"\\"+imgName);
		//파일삭제
		if(file.exists()) //파일이 존재하면
		{
			file.delete(); //파일을 삭제한다.
		}
		
		dao.deleteBoard(num); //db만 삭제, /save파일에는 그대로!
		response.sendRedirect("boardlist.jsp");
	}
	else
	{%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.");
			history.back();
		</script>	
	<%}
%>
</body>
</html>