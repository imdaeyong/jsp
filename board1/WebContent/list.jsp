<%@page import="kr.co.board1.service.BoardService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.board1.bean.BoardBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.board1.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%
	UserBean ub = (UserBean) session.getAttribute("user"); //userbean 세션이름
	String nick = null;
		
	List<BoardBean> list = new ArrayList<>();
	int totalPage = 0;
	
	if(ub==null) {
		//로그인을 안했을때
		response.sendRedirect("./user/login.jsp?result=101");
	}else{
		request.setCharacterEncoding("UTF-8");
		String pg = request.getParameter("pg");
		
		BoardService bs = new BoardService();
		int total = bs.getTotalBoard(); //getTotalBoard에서 리턴값인 총 게시물수(total) 받아옴
		totalPage = bs.getTotalPage(total); //getTotalPage에 대입.  getTotalBoard - > getTotalPage // 총 페이지수를 리턴값으로 받아옴
		
		int start =bs.getStartForLimit(pg);  
		
		//로그인을 했을때
		nick = ub.getNick();
		list = bs.getBoardList(start); //이거 한줄로 압축, 1단계~6단계 boardservice로 보냄 //여기에 숫자 넣어주는거, 10이면 1페이지, 20이면 2페이지 이런식
	}	
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>글목록</title> 
		<link rel="stylesheet" href="./css/style.css" />
	</head>
	<body>
		<div id="board">
			<h3>글목록</h3>
			<!-- 리스트 -->
			<div class="list">
				<p class="logout"><%= nick %>님! 반갑습니다. <a href="/board1/user/proc/logout.jsp">[로그아웃]</a><p>
				<table>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>글쓴이</td>
						<td>날짜</td>
						<td>조회</td>
					</tr>
					 
				<% for(BoardBean bb:list) { %>
					<tr>
						<td><%=bb.getSeq() %></td>
						<td><a href="#"><%= bb.getTitle() %></a>&nbsp;[<%=bb.getComment() %>]</td>
						<td><%= bb.getNick() %></td>
						<td><%= bb.getRdate().substring(2,10) %></td>
						<td><%= bb.getHit() %></td>						
					</tr>
				<% }%>				
				</table>
			</div>
			<!-- 페이징 -->
			<nav class="paging">
				<span> 
				<a href="#" class="prev">이전</a>
				
				<% for(int i = 1; i<=totalPage; i++) { %>
					<a href="./list.jsp?pg=<%= i %>" class="num"><%=i %></a>
				<% } %>
				
				<a href="#" class="next">다음</a>
				</span>
			</nav>
			<a href="/board1/write.jsp" class="btnWrite">글쓰기</a>
		</div>
	</body>

</html>










