<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="./inc/config.jsp" %> <%-- 요기 바꼈음 이거 해주면 비번 아디바뀔떄마다 페이지한만 바꾸면댐--%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7-2</title>
</head>
<body>
	<h3>2. include  jsp'액션'태그 </h3>
	
	<%-- 
			 include 지시자
		- 공통의 전역파일을 삽입하는 include 
		- 정적타임에 삽입된다.
	 --%>
	<%@ include file ="./inc/header.jsp" %> <%--강사님 추천 , 삽입되는 타이밍이 다름 이건 정적( 이미 삽입됨)// 밑에껀 동적(페이지를 요청할때 삽입이 일어남) --%>
	
	<section>
		<h1>본문 내용 영역</h1>
	</section>
	
	
	<!--  
			include 액션태그
		- UI뷰를 모듈화해서 삽입하는 include
		- 컴파일(실행)타임에 삽입된다. 
	-->
	<jsp:include page="./inc/footer.jsp"/>
	
</body>
</html>