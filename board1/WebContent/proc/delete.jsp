<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	String pg = request.getParameter("pg");

	Connection conn = DBConfig.getConnection();
		
	PreparedStatement psmt = conn.prepareStatement(SQL.DELETE_BOARD);
	psmt.setString(1,seq);
	psmt.executeUpdate();
	
	psmt.close();
	conn.close();

	response.sendRedirect("../list.jsp?pg="+pg);
%>