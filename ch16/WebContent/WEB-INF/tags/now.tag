<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="java.util.Calendar"%>
<%
	Calendar c = Calendar.getInstance(); //new가 안됨
	
	int year	 = c.get(Calendar.YEAR);
	int month = c.get(Calendar.MONTH);
	int date	     = c.get(Calendar.DATE);
	int hour    = c.get(Calendar.HOUR);
	int min 	 = c.get(Calendar.MINUTE);
	int sec 		 = c.get(Calendar.SECOND);
	
	request.setAttribute("year", year);
%>
<p>
	오늘은 ${year} 년 <%=month %> 월 <%=date %>일 입니다. <br>
	현재 시간은 <%=hour %>시 <%=min %>분 <%=sec %>초 입니다. <br>	
</p>