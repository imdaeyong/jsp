<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
MEMBER 테이블의 내용
<table width="100%" border="1">
<tr>
	<td>이름</td>
	<td>아이디</td>
	<td>이메일</td>
</tr>	
<%
	//1
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		String host = "jdbc:mysql://192.168.0.161:3306/kdy";
		String user = "kdy";
		String pass = "1234";
		
		
		
	//2
	//3
	//4
	//5
	//6
	
%>

</table>

</body>
</html>