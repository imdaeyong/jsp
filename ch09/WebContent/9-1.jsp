<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>9-1</title>
</head>
<body>
<h3> 1. 쿠키</h3>

<% 
//쿠키생성
Cookie cookie1 = new Cookie("name","홍길동");
Cookie cookie2 = new Cookie("uid","honggildong");
cookie1.setMaxAge(60*3);//3분뒤에사라지는 쿠키
cookie2.setMaxAge(60*3);//3분뒤에사라지는 쿠키

response.addCookie(cookie1);
response.addCookie(cookie2);

%>

<h4>쿠키 생성 후 클라이언트로 전송 완료</h4>
<a href ="./9-2.jsp"> 쿠키확인</a>
</body>
</html>
<%-- 쿠키확인 - 브라우저 f12 - application - cookie--%>

<%-- 
1. 요청 
2. 9-1에서 쿠키생성. 
3. 쿠키전송 < (서버에서 클라로) 
4. 쿠키저장.
5. 쿠키전송 > (클라에서 서버로)
6. 9-2에서 쿠키출력 
--%>