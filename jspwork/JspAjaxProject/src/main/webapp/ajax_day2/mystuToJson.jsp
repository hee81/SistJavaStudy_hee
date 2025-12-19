<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="mysql.db.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DbConnect db=new DbConnect();
	Connection conn=db.getDbConnect();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from mystu order by num";
	
	String s="[";
	
	try{
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			String num=rs.getString("num");
			String stuname=rs.getString("stuname");
			String stuphoto=rs.getString("stuphoto");
			int java=rs.getInt("java");
			int ajax=rs.getInt("ajax");
			
			s+="{";
			s+="\"num\":"+num+",";
			s+="\"stuname\":\""+stuname+"\",";
			s+="\"stuphoto\":\""+stuphoto+"\",";
			s+="\"java\":"+java+",";
			s+="\"ajax\":"+ajax+"";
			s+="},";
		}
		
		s=s.substring(0, s.length()-1);
		
	}catch(Exception e){
		
	}finally{
		db.dbClose(rs, pstmt, conn);
	}
	
	s+="]";
	
%>

<%=s%>