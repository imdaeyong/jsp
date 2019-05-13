<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>9-2</title>
</head>
<body>
<h3> 2. 쿠키확인</h3>

<%

Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies) {
	String name = cookie.getName();
	String value = cookie.getValue();
	%>

	<p>
	 이름 : <%= name %> <br/>
	 값 : <%= value %> <br/>
	
	</p>
<%		
}
%>

</body>
</html>
