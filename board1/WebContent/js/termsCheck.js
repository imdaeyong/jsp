	//2019 05 15 회원약관 동의안하면 못넘어감
			$(document).ready(function() {	//$(window).ready(function() { 브라우저 객체 대체가능
				
								
				$('.btnNext').click(function (){	//$('.btnNext').click(a){ 이렇게 바꿀수도 있음 var a = function() {} 
					
					var chk1 = $('input[name=chk1]').is(':checked');
					var chk2 = $('input[name=chk2]').is(':checked');
							
					if(!chk1){
						alert('첫번째 체크안됐어요');
						return false;
						
					}else if(!chk2){
						alert('두번째 약관에 동의체크를 해주세요');
						return false; //<a href 링크이동을 막을수 있다.
						
					}else{
						alert('제대로 읽었긴한가요');
						return true;
					}					
				});				
			});