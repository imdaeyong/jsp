<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%  
	request.setCharacterEncoding("UTF-8");		
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>request5</title>
</head>
<body>
	<h3> 파라미터 결과출력</h3>
	<p>
	<%
		String author = request.getParameter("author");
		String poem = request.getParameter("poem");
	%>
		작성자 : <%= author %> <br/>
		<textarea rows="10" cols="50" readonly>
		 	<%= poem %>
		 </textarea>
	</p>	
</body>
</html>