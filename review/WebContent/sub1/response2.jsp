<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>response1</title>
</head>
<body>
	<h3> 리다이렉트 </h3>	
	<%
		response.sendRedirect("./request1.jsp?uid=kdy");
	%>	
</body>
</html>