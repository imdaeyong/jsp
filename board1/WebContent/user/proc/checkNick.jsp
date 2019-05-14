<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String nick = request.getParameter("nick");
	
	final String HOST = "jdbc:mysql://192.168.0.161:3306/kdy";
	final String USER = "kdy";
	final String PASS = "1234";
	
	//1단계
	Class.forName("com.mysql.jdbc.Driver");
	
	//2단계
	Connection conn  = DriverManager.getConnection(HOST,USER,PASS);
	
	//3단계
	Statement stmt = conn.createStatement();
	
	//4단계
	ResultSet rs =  stmt.executeQuery("SELECT COUNT(*) FROM `JSP_USER` WHERE nick='"+nick+"';"); //COUNT로 있으면 1 없으면 0 반환
	
	//5단계
	int count = 0;
	if(rs.next()) {
		count = rs.getInt(1); //1또는 0이 들어감
	}
	
	//6단계
	rs.close();
	stmt.close();
	conn.close();
	
	//JSON 데이터 생성 및 전송
	
	//String json = "{'result':1}"; //json다운받으면 안해도댐
	JSONObject json = new JSONObject();
	json.put("result",count);
	out.print(json);
	
%>
