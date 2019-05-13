<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%

final String HOST = "jdbc:mysql://192.168.0.161:3306/kdy";
final String USER = "kdy";
final String PASS = "1234";

Connection conn = null;
PreparedStatement psmt = null;

	try {
	String uid = request.getParameter("uid");
	//1
	Class.forName("com.mysql.jdbc.Driver");
	//2
	conn = DriverManager.getConnection(HOST,USER,PASS);
	//3
	String sql = "DELETE FROM `MEMBER` WHERE `uid` =?;";
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, uid);
	//4
	psmt.executeUpdate();
	//5
	}catch(Exception e ) {
		e.printStackTrace();
	}finally {
	//6
	     try { psmt.close(); } catch(Exception e) {}
         try { conn.close(); } catch(Exception e) {}
	}
	response.sendRedirect("14-3.jsp");
	
	%>
	