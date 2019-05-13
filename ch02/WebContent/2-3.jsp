<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>3.반복문</h3>
	<%
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
	%>
	<p>
		1부터 10까지 합 :
		<%=sum%>
	</p>

	<h3>별모양</h3>
	<% 
		for(int i =10; i>=1; i--){
			for(int j =1; j<=i; j++){
			out.print("★");
		}
			out.print("<br/>");
		}
			
	%>

	<h4>구구단</h4>
	<table border="1">
		
		<tr>
			<%	
			for (int i = 2; i <= 9; i++) {	
			%>
			<td><%=i%>단단</td>
			<%	}	%>
		</tr>

		<%	
		for (int i = 1; i <= 9; i++) {	
		%>
		<tr>
			<%	
			for (int j = 2; j <= 9; j++) { 
				int k = j*i;
			%>
			<td><%=j + "x"+ i + "=" + k %></td>
			<%	} %>
		</tr>
		<%	}	%>

	</table>

</body>

</html>