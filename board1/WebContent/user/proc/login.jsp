<%@page import="kr.co.board1.bean.UserBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%
	//파라미터 언어셋 지정	
	request.setCharacterEncoding("utf-8");
	
	//파라미터 수신
	String uid = request.getParameter("id");
	String pass = request.getParameter("pw");
	
	final String HOST = "jdbc:mysql://192.168.0.161:3306/kdy";
	final String USER = "kdy";
	final String PASS = "1234";
	
	//1단계
	Class.forName("com.mysql.jdbc.Driver");
	
	//2단계
	Connection conn  = DriverManager.getConnection(HOST,USER,PASS);
	
	//3단계
	String sql = "SELECT  * FROM `JSP_USER` WHERE uid=? AND pass=PASSWORD(?);"; //PASSWORD 암호를 암호화해주는 함수 
	PreparedStatement psmt = conn.prepareStatement(sql);
	psmt.setString(1, uid);
	psmt.setString(2, pass);
	
	//4단계
	ResultSet rs = psmt.executeQuery();
	boolean log = false;
	
	if(rs.next()){
		//session.setAttribute("uid", rs.getString(1)); //이거 12개만드는거보다 자바빈 만드는게 ㅈㅎ음
		UserBean ub = new UserBean();
		ub.setUid(rs.getString(1));
		ub.setPass(rs.getString(2));
		ub.setName(rs.getString(3));
		ub.setNick(rs.getString(4));
		ub.setEmail(rs.getString(5));
		ub.setHp(rs.getString(6));
		ub.setGrade(rs.getInt(7));
		ub.setZip(rs.getString(8));
		ub.setAddr1(rs.getString(9));
		ub.setAddr2(rs.getString(10));
		ub.setRegip(rs.getString(11));
		ub.setRdate(rs.getString(12));
		
		//회원정보 한번에 모아서 객체에 저장!
		session.setAttribute("user", ub);
		
		response.sendRedirect("../../list.jsp");
		
	}else{ 
		response.sendRedirect("../login.jsp?result=fail");		
	}
	
	//5단계
	
	
	//6단계
	rs.close();
	psmt.close();
	conn.close();
	//게시판 목록 화면 or 로그인 화면 이동

	
%>

