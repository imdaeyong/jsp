	// 2019 05 15 로그인 조건 (Validation)


			//$(document).ready(function() {
				
			$(function() {
				
					$('#regForm').submit(function () {
						
						var uid = $('input[name=id]').val();
						var pw1 = $('input[name=pw1]').val();
						var pw2 = $('input[name=pw2]').val();
									
						//아이디 5자리 이하일때 전송 취소
						if(uid.length <5) {
							alert('아이디는 최소 5자리 이상 이어야 합니다.')
							return false;
						}
						//비밀번호와 확인이 다를때 전송 취소
						if(pw1 !=pw2) {
							alert('비밀번호가 일치하지 않습니다.');
							return false;
							}
						//모든 조건 통과!
						return true;					
					});			
				});
			
