<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String type = request.getParameter("type");
    if(type==null){
    	return;
    }
    %>
    <br>
    <table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
    	<td>타입 </td>
    	<td><b><%= type %> </b></td>
    	</tr>
    	
    </table>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>