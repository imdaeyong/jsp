<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11-1</title>
</head>
<body>
	<h3> 1. 표현언어</h3>
<%
	
	String name = "홍길동";
	int num1 = 1;
	int num2 = 2;
	
	//표현언어에서 출력하기위한 변수 설정	
	request.setAttribute("name",name);
	request.setAttribute("num1",num1);
	request.setAttribute("num2",num2);
	//이 3줄을 주석달면 맨밑의 표현언어는 출력이 되지않음
	
%>
<h4> 표현식</h4>
<ul>
<li>name = <%= name %></li>
<li>num1+num2 = <%= num1+num2 %></li>
</ul>

<h4> 표현언어</h4>
<ul>
<li>name = ${name}</li>
<li>num1+num2 = ${num1+num2}</li> <%-- 이건 맨위의 변수를 출력하는게 아닌 request.setAttribute를 출력하는것임 --%>
</ul>

</body>
</html>