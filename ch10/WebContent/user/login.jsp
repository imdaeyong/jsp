<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 		String result = request.getParameter("result");
  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script>
		var result = "<%= result %>"; <%--자바스크립트랑 두개가 아예 다른언어니까 같은걸로 맞춰줘야함 --%>
		if(result == "fail") { // 자바스크립트에서는 이렇게 비교,,	
			alert("회원이 아닙니다");		
		}
		
	</script>
</head>
<body>
	<h3>로그인</h3>

	<form action="./LoginProc.jsp">	
		<table border="1">
			
			<tr>
				<td>아이디</td>
				<td><input type="text" name ="uid"/> </td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="pass" name ="pass"/> </td>
			</tr>
			
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인"/> </td>
			</tr>
		</table>
	</form>

</body>
</html>