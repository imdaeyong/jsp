<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %><%-- c로 시작하는 태그들->핵심 --%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>12-1</title>
</head>
<body>
	<h3> 1.JSTL(Java Standards Tag Library)</h3>
	
	<h4>스크립트릿</h4>
	<%// html태그에 중간에 이런게 있으면 코드가 지저분해서 잘 안쓴다 
		String str = "Hello!" ;
		out.println("<p>" + str+"</p>"); 
		
		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		
		if(num1>num2) {
			out.println("<p>num1이 num2보다 크다. </p>");
		}else{
			out.println("<p>num1이 num2보다 작다. </p>");
		}
		
		if(num1>num2){
			out.println("<p>num1이 num2보다 크다</p>");
		}else if(num2>num3){
			out.println("<p>num2이 num3보다 크다</p>");
		}else{
			out.println("<p>num3이 가장 크다</p>");
		}
		
		for(int i =1; i<=5; i++) {
			out.println("<p>hello you?</p>");
		}
		
		int total =0;
		for(int k=1; k<=10; k++) {
			total +=k;
		}
		out.println("<p>1부터 10까지 합: " +total+"</p>");
		
	%>
	
	<h4>JSTL</h4>
	<c:set var = "str" value ="Hello" />
	<p>${str}</p><%-- f12눌러서 보면 위에거랑 완전 똑같음 --%>
	
	<c:set var = "num1" value ="1" />
	<c:set var = "num2" value ="2" />
	
	<c:if test= "${num1 lt num2}" > <%-- if문이 아님, if태그"(먼차이지) 그리고 else태그는 없음--%>
		<p> num1이 num2보다 작다.</p>
	</c:if>
	
	<c:choose> <%-- jsp의 if  else /when otherwise--%>
		<c:when test="${num1 gt num2 }">
			<p>num1이 num2보다 크다. </p>
		</c:when>
		<c:otherwise>
			<p>num1이 num2보다 작다. </p>
		</c:otherwise>
	</c:choose>
	
	<c:choose> <%--if elseif else문 --%>
		<c:when test="${num1 gt num2 }">
			<p>num1이 num2보다 크다</p>
		</c:when>
		<c:when test="${num2 gt num3 }">
			<p>num2이 num3보다 크다</p>
		</c:when>
		<c:otherwise>
			<p>num3이 가장 크다</p>
		</c:otherwise>
	</c:choose>

	<c:forEach begin="1" end="5"> <%-- 1에서 5까지 --%>
			<p>hello you?</p>
	</c:forEach>

	<c:set var= "total" value="0"/> <%-- 변수선언 	 --%>
	<c:forEach var="k" begin ="1" end="10">
		<c:set var="total" value ="${total+k }"/><%-- </c:set> 을 />로 합침 --%>	
	</c:forEach>
	<p>1부터 10까지의 합 : ${total}</p>

</body>
</html>