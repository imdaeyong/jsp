<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="./inc/config.jsp" %> <%-- 요기 바꼈음 이거 해주면 비번 아디바뀔떄마다 페이지한만 바꾸면댐--%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7-3</title>
</head>
<body>
	<h3>3. forward 액션태그 </h3>
	<%
		pageContext.forward("./7-1.jsp"); //주소는 7-3, 결과는 7-1
	
	%>
	<jsp:forward page = "./7-1.jsp"/> <%-- 잘안씀 --%> 
</body>
</html>