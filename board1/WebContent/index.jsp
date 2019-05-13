<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%
	if(true){
		//로그인 안했을때
		pageContext.forward("./user/login.jsp");
	}else{
		//로그인 했을때
		pageContext.forward("./list.jsp");
	}
%>