<%@page import="kr.co.board1.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%

	UserBean ub =(UserBean)  session.getAttribute("user"); 
	//user( 사용자) 로그인 했는지 안했는지 판별

	if(ub== null){
		//로그인 안했을때 board1기본화면
		pageContext.forward("./user/login.jsp");
	}else{
		//로그인 했을때 board1기본화면
		pageContext.forward("./list.jsp");
	}
%>