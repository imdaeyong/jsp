<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>request4</title>
</head>
<body>
	<h3> 파라미터 결과출력</h3>
	<%  
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nm = request.getParameter("nm");
	String ag = request.getParameter("ag");
	
	%>
	
	<p>
		id : <%=id %><br/>
		pw : <%=pw %><br/>
		nm : <%=nm %><br/>
		ag : <%=ag %><br/>
	</p>
	
</body>
</html>