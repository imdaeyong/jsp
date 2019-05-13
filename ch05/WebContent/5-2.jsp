<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5-2</title>
</head>
<body>
	<h3>2. pageContext 내장객체</h3>
	<%
	
	ServletRequest req = pageContext.getRequest();
	ServletResponse resp = pageContext.getResponse();
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	
	//pageContext.forward("http://naver.com"); 이건 안됌
	//pageContext.forward("./5-1.jsp"); // 프로젝트 내에서 또 다른 페이지 요청
		
		

%>	
	
	<p>
	이름 : <%= name %><br/>
	나이 : <%= age  %><br/>
	</p>



</body>
</html>
