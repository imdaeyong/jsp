<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%  
	request.setCharacterEncoding("UTF-8");
	String uid= request.getParameter("uid");
	String name= request.getParameter("name");
	String[] hobbys= request.getParameterValues("hobby");	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>request3</title>
</head>
<body>
	<h3> 파라미터 결과출력</h3>
	<p>
		uid : <%=uid %>
		name : <%=name %>
		hobby : 
		<%
		for(String hobby : hobbys){
				out.print(hobby +" ");
		}%>
	</p>	
</body>
</html>