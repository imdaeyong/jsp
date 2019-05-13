<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import ="java.util.Map"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>
<b> request.getParameter() 메서드 사용 </b> <br/>
<%
String[] values = request.getParameterValues("pet");
if(values!=null) {
	for(int i=0; i<values.length; i++) {
%>
<%= values[i] %>
<%
	}
} 
%>
<p>
<b>request.getParameterNames() 메서드 사용</b> <br/>
<% Enumeration paen = request.getParameterNames(); 
	while(paen.hasMoreElements()) {
		String name = (String)paen.nextElement();
		%>
	<%= name  %>
	<%
		}
	 %>
<p>
<b>request.getParameterMap사용</b><br>
<%
Map pamap = request.getParameterMap();
String[] napa= (String[])pamap.get("name");
if(napa!=null) {
	%>
	name=<%= napa[0]  %>
	<%
	}
	%>
</body>
</html>