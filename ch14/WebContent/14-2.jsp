<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("UTF-8");

	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String pos = request.getParameter("pos");
	String dep = request.getParameter("dep");

	final String HOST = "jdbc:mysql://192.168.0.161:3306/kdy";
	final String USER = "kdy";
	final String PASS = "1234";
	
	Connection conn=null;
	PreparedStatement psmt = null;
	
	try{
		
		Class.forName("com.mysql..jdbc.Driver");
		conn = DriverManager.getConnection(HOST,USER,PASS);
		psmt = conn.prepareStatement("INSERT INTO `MEMBER` SET `uid`=?, `name`=?,  `hp`=?, `pos`=?, `dep`=?, `rdate`=NOW();");
		psmt.setString(1, uid);
		psmt.setString(2, name);
		psmt.setString(3, hp);
		psmt.setString(4, pos);
		psmt.setInt(5, Integer.parseInt(dep));
	
		psmt.executeUpdate();
		
	}catch(Exception e) {
			e.printStackTrace();
			
	}finally {
         psmt.close();
         conn.close();
	}
%>