<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<link rel="stylesheet" href="/board2/css/style.css" />
	</head>
	<body>
		<div id="member">
			<section class="login">		
				<form action="/board2/user/login.do" method="post"> <%-- get으로 method 보내면 다 노출되니까 포스트로 보내야함 --%>
					<table>
						<tr>
							<td><img src="/board2/img/login_ico_id.png" alt="아이디" /></td>
							<td><input type="text" name="id" required placeholder="아이디 입력" autocomplete="off" /></td>
							<%-- required="required" 뒷부분 생략 , 필수조건이라 안달면 안넘어감, 자동완성기능 off --%>
						</tr>
						<tr>
							<td><img src="/board2/img/login_ico_pw.png" alt="비밀번호" /></td>
							<td><input type="password" name="pw" required placeholder="비밀번호 입력" /></td>
						</tr>
					</table>
					<input type="submit" class="btnLogin" value="로그인" />
					<%--btnLogin 버튼 누르면 서버로 제출되고 정보가 맞으면 로그인됨,  --%>
				</form>							
				<div class="info">
					<h3>회원로그인 안내</h3>
					<p>아직 회원이 아니시면 회원으로 가입하세요.</p>
					<div><a href="/board2/user/terms.do">회원가입</a></div>
					<%-- 회원가입 글자 누르면 terms - 약관읽는페이지로 넘어감 --%>
				</div>			
			</section>
		</div>
	</body>
</html>