<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %><%-- c로 시작하는 태그들->핵심 , 무조건 들어가야함 jstl관련--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<c:choose>
	<c:when test="${param.name=='bk'}">
		<li> 당신의 이름은 {param.name} 입니다.
	</c:when>
	<c:when test="${param.age>20}">
		<li> 당신의 이름은 {param.name} 입니다.
	</c:when>
	<c:otherwise>
		<li>bk도아니고 20세도 안되네요
	</c:otherwise>

</c:choose>

</ul>

</body>
</html>