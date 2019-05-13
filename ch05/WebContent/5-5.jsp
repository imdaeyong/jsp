<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5-5</title>
</head>
<body>
	<h3>5. 내장객체 영역 name값 화면</h3>
	<%
		String pname = (String)pageContext.getAttribute("name");	
		String rname = (String)request.getAttribute("name");	
		String sname = (String)session.getAttribute("name");	
		String aname = (String)application.getAttribute("name");
		
		
	%>
	
	<p>
	pageContext 값 : <%= pname%> <br>
	request 값 : <%= rname%> <br>
	session 값 : <%= sname%> <br>
	application 값 : <%= aname%> <br>
	
	</p>

</body>
</html>