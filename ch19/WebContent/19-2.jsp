<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>19-2</title>
</head>
<body>
	<h3> 인코딩 필터</h3>
	<%
		//request.setCharacterEncoding("UTF-8"); //이걸 필터로 처리하자
		String name= request.getParameter("name");
		String msg = request.getParameter("msg");	
	%>
	
	<p>
		name : <%= name %> <br>
		msg : <%= msg %><br>
	</p>
	
	
	
</body>
</html>