<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<% 
	
	String uid = request.getParameter("uid");
	final String HOST = "jdbc:mysql://192.168.0.161:3306/kdy";
	final String USER = "kdy";
	final String PASS = "1234";
	
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet = null;
	MemberBean mb = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	//2
		conn = DriverManager.getConnection(HOST,USER,PASS);
	//3
		stmt = conn.createStatement();
	//4
		rs = stmt.executeQuery("SELECT * FROM `MEMBER` WHERE uid='"+uid+"';");
	
	//5
	  mb = new MemberBean();
	  if(rs.next()) {
		    	mb.setUid(rs.getString(2));
		    	mb.setName(rs.getString(3));
		    	mb.setHp(rs.getString(4));
		    	mb.setPos(rs.getString(5));
		    	mb.setDep(rs.getInt(6));
		    	mb.setRdate(rs.getString("rdate"));
		    	    	
		    }  
	
	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
	//6
	rs.close();
	stmt.close();
	conn.close();
	



%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14-5</title>
</head>
	<body>
		<h3>직원 수정</h3>
		<form action="14-6.jsp" method="post">
			<table border ="1">
					<tr>
						<td>아이디</td>
						<td><input type = "text" name="uid" value = "<%= mb.getUid() %>"  readonly placeholder="아이디 입력"/> </td>
					</tr>
					
					<tr>
						<td>이름</td>
						<td><input type = "text" name="name" value = "<%= mb.getName() %>" placeholder="이름 입력"/> </td>
					</tr>
					
					<tr>
						<td>휴대폰</td>
						<td><input type = "text" name="hp"  value = "<%= mb.getHp() %>" maxlength = "13" placeholder="휴대폰 입력"/> </td>
					</tr>
					
					<tr>
						<td>직급</td>
						<td>
							<select name ="pos" >
								<option>사원</option>
								<option>대리</option>
								<option>과장</option>
								<option>차장</option>
								<option>부장</option>
								<option>이사</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>부서</td>
						<td>
							<select name ="dep">
							<option value="101">영업1부</option>
							<option value="102">영업2부</option>
							<option value="103">영업3부</option>
							<option value="104">영업4부</option>
							<option value="105">영업지원부</option>
							<option value="106">인사부</option>
							</select>
				
						 </td>
					</tr>
	<tr>
	<td colspan="2" align="right"> <input type="submit" value ="수정하기"/></td>
	</tr>					
					
				</table>
		
		
		</form>

</body>
</html>
