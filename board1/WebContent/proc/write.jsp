<%@page import="kr.co.board1.bean.UserBean"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String subject =request.getParameter("subject");
	String content = request.getParameter("content");
	String regip = request.getRemoteAddr();
	
	UserBean ub = (UserBean) session.getAttribute("user"); //userbean 세션이름
	String uid = ub.getUid();

	//1단계 2단계
	Connection conn = DBConfig.getConnection();
	
	//3단계
	PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_BOARD);
	psmt.setString(1, subject);
	psmt.setString(2, content);
	psmt.setString(3, uid);
	psmt.setString(4, regip);
	
	psmt.executeUpdate();
	
	psmt.close();
	conn.close();
	
	response.sendRedirect("../list.jsp");
%>