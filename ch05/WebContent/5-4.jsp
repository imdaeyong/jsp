<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5-4</title>
</head>
<body>
	<h3>4. 내장객체 영역</h3>
	<%
		pageContext.setAttribute("name", "김유신"); //하나의 jsp에만 주어짐. , 공유불가
		request.setAttribute("name","김춘추");
		session.setAttribute("name","강감찬");
		application.setAttribute("name", "이순신");	
		

		pageContext.forward("./5-5.jsp"); //이걸붙이면 request값까진 나온다
		//request가 공유됨 ( 요청) - 포워딩
	%>
	<h4> 내장객체 영역에 name값 저장완료</h4>
	<a href = "./5-5.jsp"> 저장값 확인하기</a>

</body>
</html>