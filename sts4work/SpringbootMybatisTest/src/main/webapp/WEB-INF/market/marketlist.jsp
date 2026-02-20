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
<title>Insert title here</title>
</head>
<body>
  <c:if test="${totalcount==0 }">
     <div class="alert alert-success">
         <b>저장된 상품정보가 없습니다</b>
     </div>
  </c:if>
  <c:if test="${totalcount>0 }">
     <div class="alert alert-success">
         <b>총 ${totalcount }개의 상품정보가 있습니다</b>
     </div>
  </c:if>
  
  <button type="button" class="btn btn-info"
  onclick="location.href='form'">상품정보입력</button>
  
  <br><br>
  <c:forEach var="a" items="${list }">
     <table  class="table table-bordered" style="width: 600px;">
        <tr>
          <td>
            <c:if test="${a.photoname!=null }">
              <img alt="" src="../photo/${a.photoname }" style="width: 150px;" align="left" hspace="50">
            </c:if>
            <c:if test="${a.photoname==null }">
              <img alt="" src="../image/logoImg/a.png" style="width: 150px;" align="left" hspace="50">
            </c:if>
            
            <h4>상품명: ${a.sang }</h4>
            <h4>가격: <fmt:formatNumber value="${a.dan }" type="currency"/>   </h4>
            <h4>입고일: <fmt:formatDate value="${a.ipgo }" pattern="yyyy-MM-dd HH:mm"/> 
              </h4>
              
            <h4>
               <button type="button" class="btn btn-outline-primary"
               onclick="location.href='updateform?num=${a.num}'">수정</button>
               <button type="button" class="btn btn-outline-danger"
               onclick="location.href='delete?num=${a.num}'">삭제</button>
            </h4>
          </td>
        </tr>
     </table>
  </c:forEach>
  
  
</body>
</html>