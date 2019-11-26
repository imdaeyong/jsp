<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<% 
	String uid= request.getParameter("uid");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>request1</title>
</head>
<body>
	<h3> 파라미터 결과출력</h3>	
	<p>
		uid :<%=uid %>	
	</p>
	
</body>
</html>