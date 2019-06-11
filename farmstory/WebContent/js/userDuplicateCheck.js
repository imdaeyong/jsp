/**
 * 2019 05 14 자바스크립트 파일정리 김대용
 *사용자 아이디, 이메일, 닉네임, 휴대폰 중복체크 
 */
$(function(){ 
				$('input[name=id]').focusout(function(){
					var tag = $(this);
					var uid = tag.val();
					$.ajax({
						url : '/farmstory/proc/checkUid.jsp?uid=' +uid,
						type: 'get',
						dataType: 'json',
						success: function(data){
							if(data.result ==1) {
								$('.resultId').css('color','red').text('이미 사용중인 아이디입니다.');
								tag.focus();
							}else {
								$('.resultId').css('color','green').text('사용 가능한 아이디 입니다.');
							}													
						}											
					});					
				});
				$('input[name=nick]').focusout(function(){
					var tag = $(this);
					var nick = tag.val();
					$.ajax({
						url : '/farmstory/proc/checkNick.jsp?nick=' +nick,
						type: 'get',
						dataType: 'json',
						success: function(data){
							if(data.result ==1) {
								$('.resultNick').css('color','red').text('이미 사용중인 별명입니다.');
								tag.focus();
							}else {
								$('.resultNick').css('color','green').text('사용 가능한 별명입니다.');
							}												
						}											
					});					
				});
				$('input[name=email]').focusout(function(){
					var tag = $(this);
					var email = tag.val();
					$.ajax({
						url : '../proc/checkEmail.jsp?email=' +email,
						type: 'get',
						dataType: 'json',
						success: function(data){
							if(data.result ==1) {
								$('.resultEmail').css('color','red').text('이미 사용중인 이메일입니다.');
								tag.focus();
							}else {
								$('.resultEmail').css('color','green').text('사용 가능한 이메일입니다.');
							}												
						}											
					});					
				});				
				$('input[name=hp]').focusout(function(){
					var tag = $(this);
					var hp = tag.val();
					$.ajax({
						url : '../proc/checkHp.jsp?hp=' +hp,
						type: 'get',
						dataType: 'json',
						success: function(data){
							if(data.result ==1) {
								$('.resultHp').css('color','red').text('이미 사용중인 번호입니다.');
								tag.focus();
							}else {
								$('.resultHp').css('color','green').text('사용 가능한 번호입니다.');
							}												
						}											
					});					
				});			
			})			
		