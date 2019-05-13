<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pagecontext 기본객체</title>
</head>
<body>
<% HttpServletRequest httpRequest = (HttpServletRequest)pageContext.getRequest(); %>
request 기본객체와 pageContext.getRequest() 의 동일여부:
<%= request ==httpRequest %>
<br>

pagecontext.getOut()메서드를 이용한 데이터 출력:
<% pageContext.getOut().println("안녕");%>
</body>
</html>