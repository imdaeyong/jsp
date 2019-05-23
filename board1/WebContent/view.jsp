<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="kr.co.board1.service.BoardService"%>
<%@page import="kr.co.board1.bean.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	request.setCharacterEncoding("UTF-8");
    
	String pg 	= request.getParameter("pg");
	String seq 	= request.getParameter("seq");
	
	BoardService service = BoardService.GetInstance();
	
	service.updateHit(seq);
	BoardBean bb = service.viewBoard(seq);
	
	//댓글리스트 가져오기
	List<BoardBean> commentList	= service.commentList(seq); //ArrayList 해도 상관없음? 오류는 떴긴함 다형성? ArrayList보다 list쓰는게 나음
		
	
	
%>
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
				<form action="#" method="post">
					<table>
						<tr>
							<td>제목</td>
							<td><input type="text" name="subject" value="<%= bb.getTitle() %>" readonly />
							</td>
						</tr>
						<%
							if(bb.getFile() == 1){
						%>						
							<tr>
								<td>첨부파일</td>
								<td>
									<a href="#">테스트.hwp</a>
									<span>3회 다운로드</span>
								</td>
							</tr>
						<%
							}
						%>
						<tr>
							<td>내용</td>
							<td>
								<textarea name="content" rows="20" readonly><%= bb.getContent() %></textarea>
							</td>
						</tr>
					</table>
					<div class="btns">
						<a onclick="return confirm('정말로 삭제하시겠습니까?')"	 href="./proc/delete.jsp?pg=<%= pg %>&seq=<%= bb.getSeq() %>" class="cancel del">삭제</a>
						<a href="#" class="cancel mod">수정</a>
						<a href="./list.jsp?pg=<%= pg %>"  class="cancel">목록</a>
					</div>
				</form>
			</div><!-- view 끝 -->
			
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
				<%
					for(BoardBean comment : commentList) {
				%>			
				<div class="comment">
					<span>
						<span class="nick"><%=comment.getNick() %></span>
						<span class="rdate"><%=comment.getRdate().substring(2,10) %></span>
					</span>
					<textarea><%=comment.getContent() %></textarea>
					<div>
						<a href="#" class="del">삭제</a>
						<a href="#" class="mod">수정</a>
					</div>
				</div>
				<%
					}
					if(commentList.size()==0) {
				%>		
						<p class="empty">등록된 댓글이 없습니다.</p>
				<%
					}
				%>
			</section>
			
			<!-- 댓글쓰기 -->
			<section class="comment_write">
				<h3>댓글쓰기</h3>
				<div>
					<form action="./proc/commentWrite.jsp" method="post">
						<input type = "hidden" name="parent" value = "<%=bb.getSeq() %>"/>
						 
						<%-- <input type = "text" name="uid" value = "<%= %>"/>  사용자정보를 list에서 받아올수도 있지만 보통 사용자정보는 넘기지 않는다. 여기서 열어도 어차피 넘겨야돼서commentwrite에 새로연다. --%> 
						
						<textarea name="comment" rows="5"></textarea>
						<div class="btns">
							<a href="#" class="cancel">취소</a>
							<input type="submit" class="submit" value="작성완료" />
						</div>
					</form>
					
					<script>
						$(function() {
							
							var comments = $('.comments');
							
							var btnSubmit = $('.comment_write .submit'); //comment_write.submit의 객체이다
							
							btnSubmit.click(function() {
								
								var commentView = $('.comments > .comment:nth-of-type(1)');
								var textarea =$('.comment_write textarea');//클래스이름은 .아니면 띄워쓰기
								var content = textarea.val(); //텍스트상자 내용을 담음
								var parent = $('.comment_write input[name=parent]').val(); 
								
								if(content =="") {
									alert('댓글 내용을 입력하세요');
									textarea.focus();
									
								}else {
									var jsonData = {parent:parent , content:content}; // 앞의 content = 데이터이름( key): value 뒤의content = 위의 변수
																		
									$.ajax({
										url : './proc/commentWrite.jsp',
										type : 'post', //get or post 아무거나 해도됨, json으로 전송하기 떄문에, 위에 url에 파라미터가 들어가면( ?=uid=홍길동)먼가 바낌, 아니면 빼도됨
										dataType: 'json', //return받을 데이터 타입 (function(>result<))
										data: jsonData, 
										success: function(result){
											//alert(result.content);//result로 commentWrite의 json을 가져온다? view =>홍길동 전달,commentWrite에서도 역으로 json화해서 전달 / 알터로 조금전에 쓴 글을 출력
										
											var commentNew = commentView.clone(); //그냥하니까 맨위에꺼가(nth1) 사라져서 만들었음
											
											
											commentNew.find('.nick').text(result.nick);
											commentNew.find('.rdate').text(result.rdate);
											commentNew.find('textarea').text(result.content);
											
											comments.append(commentNew);
													
											//	empty 문구 삭제
											var empty =$('.empty');
											
											if(empty.is(':visible')){
												empty.remove();												
											}
											
											
										}
									});
								}							
								return false; //폼 전송 취소
							});										
					
						});					
					</script>
				</div>				
			</section>
		</div><!-- board 끝 -->		
	</body>

</html>