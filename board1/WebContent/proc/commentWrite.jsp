<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.co.board1.bean.UserBean"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");
	String parent		 = request.getParameter("parent");
	String content	 = request.getParameter("content");
	String regip 		 = request.getRemoteAddr();
	
	//현재 로그인 사용자 세션열기
	UserBean ub =  (UserBean)session.getAttribute("user");
	
	
	Connection conn = DBConfig.getConnection();
	
	PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
	psmt.setString(1,parent);
	psmt.setString(2,content);
	psmt.setString(3,ub.getUid());
	psmt.setString(4,regip);

	psmt.executeUpdate();
	
	psmt.close();
	conn.close();
	
	//json으로 변경, 데이터 생성
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	String today = sdf.format(date);
	
	JSONObject json = new JSONObject();
	json.put("content",content);
	json.put("nick",ub.getNick());
	json.put("rdate",today);
	
	out.print(json);

%>