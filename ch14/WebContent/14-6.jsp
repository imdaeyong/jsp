<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	Connection conn = null;
	Statement stmt = null;

	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(HOST, USER, PASS);
		stmt = conn.createStatement();
		String sql = "UPDATE `MEMBER` SET ";
		sql += "name=`" + name + "',";
		sql += "hp=`" + hp + "',";
		sql += "pos=`" + pos + "',";
		sql += "dep=" + dep + " ";
		sql += "WHERE `uid`=`" + uid + "';";
		
		stmt.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
	} finally {
		stmt.close();
		conn.close();
		
	}
	response.sendRedirect("14-3.jsp");
%>
