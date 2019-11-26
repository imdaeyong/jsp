<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %><%-- c로 시작하는 태그들->핵심 , 무조건 들어가야함 jstl관련--%>
<%@ taglib prefix = "fn" uri ="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>12-2</title>
</head>
<body>
	<h3> 2.JSTL Function 라이브러리 태그</h3>
	<%
		String str = "Hello Korea";
	
		int idx = str.indexOf("e");
		int ldx = str.lastIndexOf("e");
		int len = str.length();
		
		String rs1= str.substring(7,8); //?? 7,8로 해도 결과가 똑같이나옴 밑에건 안대든데
		String rs2= str.replace("Korea","Busan");		
	%>
	<ul>
		<li>idx : <%= idx%></li>
		<li>ldx : <%= ldx%></li>
		<li>len : <%= len%></li>
		<li>rs1 : <%= rs1%></li>
		<li>rs2 : <%= rs2%></li>
	</ul>
	
	<h4> Function 라이브러리 활용</h4>
	
	<c:set var ="str" value ="Hello Korea" />
	
	<ul>	
		<li>idx : ${ fn:indexOf(str,"e") }</li> <%-- lastindexof는 없음 --%>
		<li>len : ${ fn:length(str) }</li>
		<li>rs1 : ${ fn:substring(str,7,9) }</li>
		<li>rs2 : ${ fn:replace(str,"Korea","Busan") }</li>
	</ul>
	
</body>
</html>