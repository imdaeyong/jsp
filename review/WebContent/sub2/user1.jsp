<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String age = request.getParameter("age");
	
	String HOST= "jdbc:mysql://192.168.0.161:3306/kdy";
	String USER= "kdy";
	String PASS = "1234";
	Class.forName("com.mysql.jdbc.Driver");
		
	Connection conn = DriverManager.getConnection(HOST,USER,PASS);
	
	String sql = "INSERT INTO `REVIEW_USER1` SET "
				+"uid=?,"
				+"name=?,"
				+"hp=?,"
				+"age=?";
				 
	PreparedStatement psmt = conn.prepareStatement(sql);
	psmt.setString(1,uid);
	psmt.setString(2,name);
	psmt.setString(3,hp);
	psmt.setString(4,age);
	psmt.executeUpdate();
	psmt.close();
	conn.close();
	
	//리다이렉트
	response.sendRedirect("../review2.jsp");
	
%>