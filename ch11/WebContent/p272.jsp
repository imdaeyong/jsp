<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "elfunc" uri="/WEB-INF/tlds/el-functions.tld" %>
<%
request.setAttribute("price",12345);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useELObject</title>
</head>
<body>
	오늘은 <b>{elfunc:formatNumber(price,'#,##0')}</b>입니다.

</body>
</html>