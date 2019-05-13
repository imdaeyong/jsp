<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10-2</title>
</head>
<body>
 <h3>2. 세션확인</h3>
 
 
 <%
		 String sid = (String)session.getId();	
		 String name = (String)session.getAttribute("name"); // getattribute는 오브젝트변수, 오브젝트 = 자바 최상위, 변환 손쉽게가능
		 String uid = (String)session.getAttribute("uid"); 
 %>
 
 <p>
sid : <%= sid %><br/>
  name : <%= name  %> <br/>
   uid : <%= uid %>
    </p>
 
 
 </body>
</html>