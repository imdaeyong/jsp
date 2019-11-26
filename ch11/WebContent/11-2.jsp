<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11-2</title>
</head>
<body>
	<h3> 2. 표현언어 기본객체 </h3>
	<%
			pageContext.setAttribute("name","김유신");
			request.setAttribute("name","김춘추");
			session.setAttribute("name", "장보고");
			application.setAttribute("name","이순신");
	
	%>

	<ul>
	<%-- <li>${name}</li> <%-- 김유신이 나온다? = 기본 객체는 페이지컨텍스트다 --%>
	<li>${pageScope.name}</li>
	<li>${requestScope.name}</li>
	<li>${sessionScope.name}</li>
	<li>${applicationScope.name}</li>
	</ul>

</body>
</html>