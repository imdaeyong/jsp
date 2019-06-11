<%@page import="kr.co.farmstory.config.SQL"%>
<%@page import="kr.co.farmstory.config.DBConfig"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String email = request.getParameter("email");
	
	Connection conn = DBConfig.getConnection();	
	//3단계
	PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_EMAIL_COUNT);
	psmt.setString(1, email);
	
	//4단계
	ResultSet rs =  psmt.executeQuery(); //COUNT로 있으면 1 없으면 0 반환
		
	//5단계
	int count = 0;
	if(rs.next()) {
		count = rs.getInt(1); //1또는 0이 들어감
	}
	
	//6단계
	rs.close();
	psmt.close();
	conn.close();
	
	//JSON 데이터 생성 및 전송
	
	//String json = "{'result':1}"; //json다운받으면 안해도댐
	JSONObject json = new JSONObject();
	json.put("result",count);
	out.print(json);
	
%>
