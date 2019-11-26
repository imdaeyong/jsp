<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>1. JSP 내장객체</title>
</head>
<body>
	<h3>request</h3>
	<a href="./sub1/request1.jsp?uid=abcd">request1.jsp</a>
	<a href="./sub1/request2.jsp?uid=abcd&name=홍길동">request2.jsp</a>
	<a href="./sub1/request3.jsp?uid=abcd&name=홍길동&hobby=등산&hobby=영화">request3.jsp</a>
	
	<h4>개인정보</h4>
	<form action="./sub1/request4.jsp">
		<input type="text" name="id" placeholder = "아이디를 입력하세요."/><br/>
		<input type="text" name="pw" placeholder = "비번을 입력하세요."/><br/>
		<input type="text" name="nm" placeholder = "이름을 입력하세요."/><br/>
		<input type="text" name="ag" placeholder = "나이를 입력하세요."/><br/>
		<input type="submit" value="전송" />
	</form>
	
	<h4>나의 시</h4>
	<form action ="./sub1/request5.jsp" method="post">
		<input type="text" name="author" placeholder="작성자를 입력하세요"/> <br/>
		<textarea name="poem" rows="10" cols="50" placeholder="시를 지으세요"></textarea><br/>
		<input type="submit" value="전송" />		
	</form> 	<!-- 시는 길어서 포스트에 작성-->
	<h3> response 객체</h3>
	<a href="./sub1/response1.jsp"> response1</a>
	<a href="./sub1/response2.jsp"> response2</a>
		
	<h3> session 객체</h3>
	<a href="./sub1/session1.jsp?uid=kdy&name=김대용"> session1</a>
	<a href="./sub1/session2.jsp"> session2</a> 	
</body>
</html>