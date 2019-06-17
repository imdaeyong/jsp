<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>글보기</title> 
		<link rel="stylesheet" href="./css/style.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	</head>

	<body>		
		<div id="board">
		<h3>글보기</h3>
		<div class="view">
		<c:forEach var="vo" items="${list}">
			<form action="#" method="post">
				<table>
				
					<tr>
						<td>제목</td>
						<td><input type="text" name="subject" value="${vo.title}" readonly /></td>
					</tr>
								
						<tr>
							<td>첨부파일</td>
							<td>
								<a href="#">파일명</a>
								<span>회 다운로드</span>
							</td>
						</tr>				
					<tr>
						<td>내용</td>
						<td>							
							<textarea name="content" rows="20" readonly>
							<c:out value="${vo.content}"/>
							</textarea>
						</td>
					</tr>
					
				</table>
				<div class="btns">
					<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="/board2/delete.jsp?seq=${vo.seq}" class="cancel del">삭제</a>
					<a href="#" class="cancel mod">수정</a>
					<a href="./list.jsp?pg="  class="cancel">목록</a>
				</div>
			</form>
		</div><!-- view 끝 -->
			</c:forEach>
			<style>
			.comments> .comment:nth-of-type(1) {
				display:none;
			}
			</style>
			<!-- 댓글리스트 -->
			<section class="comments">
				<h3>댓글목록</h3>											
				<div class="comment">
					<span>
						<span class="nick">닉네임</span>
						<span class="rdate">날짜</span>
					</span>
					<textarea>내용</textarea>
					<div>
						<a href="#" class="del">삭제</a>
						<a href="#" class="mod">수정</a>
					</div>
				</div>
				
				<div class="comment">
					<span>
						<span class="nick">닉네임</span>
						<span class="rdate">19-05-31</span>
					</span>
					<textarea></textarea>
					<div>
						<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="./proc/delete.jsp?seq=&parent=&pg= class="del">삭제</a>
						<a href="#" class="mod">수정</a>
					</div>
				</div>
			
						<p class="empty">등록된 댓글이 없습니다.</p>
			
			</section>
			
			<!-- 댓글쓰기 -->
			<section class="comment_write">
				<h3>댓글쓰기</h3>
				<div>
					<form action="./proc/commentWrite.jsp" method="post">
						<input type = "hidden" name="parent" value = ""/>
						 
						<%-- <input type = "text" name="uid" value = "<%= %>"/>  사용자정보를 list에서 받아올수도 있지만 보통 사용자정보는 넘기지 않는다. 여기서 열어도 어차피 넘겨야돼서commentwrite에 새로연다. --%> 
						
						<textarea name="comment" rows="5"></textarea>
						<div class="btns">
							<a href="./list.jsp" class="cancel">취소</a>
							<input type="submit" class="submit" value="작성완료" />
						</div>
					</form>					
			
				</div>				
			</section>
		</div><!-- board 끝 -->		
	</body>

</html>