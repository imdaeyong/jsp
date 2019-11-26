<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String HOST= "jdbc:mysql://192.168.0.161:3306/kdy";
	String USER= "kdy";
	String PASS = "1234";
	
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String addr = request.getParameter("adrr");
	
	Class.forName("com.mysql.jdbc.Driver");
		
	Connection conn = DriverManager.getConnection(HOST,USER,PASS);
	
	String sql = "INSERT INTO `REVIEW_USER2` SET "
				+"name=?,"
				+"birth=?,"
				+"addr=?";
				 
	PreparedStatement psmt = conn.prepareStatement(sql);
	psmt.setString(1,name);
	psmt.setString(2,birth);
	psmt.setString(3,addr);
	psmt.executeUpdate();
	psmt.close();
	conn.close();
	
	//리다이렉트
	response.sendRedirect("../review2.jsp");
	
%>