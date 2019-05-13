<%@page import="kr.co.ch14.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%
		String host = "jdbc:mysql://192.168.0.161:3306/kdy";
		String user = "kdy";
		String pass = "1234";
		
		Connection conn=null;
		PreparedStatement psmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberBean> list =null;
		
		try{
			//1
			Class.forName("com.mysql.jdbc.Driver");
			//2
			 conn = DriverManager.getConnection(host,user,pass);
			//3
			stmt = conn.createStatement();
			//4
		    rs = stmt.executeQuery("SELECT * FROM `MEMBER`;");
			//5
			
			list = new ArrayList<MemberBean>();
				
		    while(rs.next()) {		    	
		    	MemberBean mb = new MemberBean();
		    	mb.setUid(rs.getString(2));
		    	mb.setName(rs.getString(3));
		    	mb.setHp(rs.getString(4));
		    	mb.setPos(rs.getString(5));
		    	mb.setDep(rs.getInt(6));
		    	mb.setRdate(rs.getString("rdate"));
		    	
		    	list.add(mb);
		    	   
		    }  
		    		    
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{   
			rs.close();  
			psmt.close();
        	conn.close();
         
        
    	
		}


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14-3</title>
</head>
<body>
	<h3> 직원목록 </h3>

	<tabel border= "1">
		<tr>
			<td> 아이디</td>
			<td> 이름</td>
			<td> 휴대폰</td>
			<td> 직급</td>
			<td> 부서</td>
			<td> 입사일</td>
			<td> 수정 </td>
			<td> 삭제 </td>
		</tr>
		
		<%
			for(MemberBean mb:list) {
		%>
		<tr>
			<td><%= mb.getUid()%></td>
			<td><%= mb.getName() %></td>
			<td><%= mb.getHp() %></td>
			<td><%= mb.getPos() %></td>
			<td><%= mb.getDep() %></td>
			<td><%= mb.getRdate().substring(2,10) %></td>
			<td><a href="14-5.jsp?uid=" +<%= mb.getUid() %>"> 수정 </a></td>
			<td><a href="14-4.jsp?uid=" +<%= mb.getUid() %>"> 삭제 </a></td>
		</tr>
		<%
			}
		%>	
	
	</body>
</html>