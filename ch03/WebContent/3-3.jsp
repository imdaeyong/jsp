<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3-3</title>
</head>
<body>
	<h3>3. 회원가입 parameter 수신 </h3>
	<%
	
		request.setCharacterEncoding("UTF-8");
		//post방식으로 데이터를 전송했을때 데이터 디코딩(한글깨짐방지) (server.xml에서 커넥터에 달아도 깨짐)
		
		String name 			= request.getParameter("name");
		String gender 		= request.getParameter("gender");
		String[] hobbies	= request.getParameterValues("hobby");
		String addr 			= request.getParameter("addr");
	%>
	<p>
		이름 : <%= name %><br/>
		성별 : <%= gender  %><br/>
		취미 : 
		<% 
		for(String hobby : hobbies){
				out.print(hobby +", ");
		}
		%><br/>
		지역 : <%= addr  %>
	</p>

</body>
</html>