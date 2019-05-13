<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버정보 출력</title>
</head>
<body>
	서버정보 : <%= application.getServerInfo() %><br/>
	서버규약(메이저) : <%= application.getMajorVersion() %><br/>
	서버규약(마이너) : <%= application.getMinorVersion() %><br/>
	
</body>
</html>