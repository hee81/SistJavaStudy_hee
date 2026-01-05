<%@page import="reboard.ReboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//수정폼에서 넘긴 3개받아서
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	String currentPage=request.getParameter("currentPage");
	
	//num,pass로는 비번이 맞는지 체크
	//맞으면 수정폼이동(num,currentPage) 틀리면 경고창
	ReboardDao dao=new ReboardDao();
	
	boolean Password=dao.isEqualPass(num, pass);
	
	if(Password)
	{
		response.sendRedirect("updateForm.jsp?num="+num+"&currentPage="+currentPage);
	}
	else
	{%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.")
			history.back();
		</script>
	<%}
	

	
	
%>
