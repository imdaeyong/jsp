<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file ="../_head.jsp" %>	

<div id="terms">
			<section>
				<table>
					<caption>사이트 이용약관</caption>
					<tr>
						<td>
							<textarea readonly>${requestScope.vo.getTerms()}	</textarea>
							<div>
								<label><input type="checkbox" name="chk1" />&nbsp;동의합니다.</label>        
							</div>
						</td>
					</tr>
				</table>
			</section>			
			<section>
				<table>
					<caption>개인정보 취급방침</caption>
					<tr>
						<td>
							<textarea readonly>${vo.privacy}</textarea>
							<div>
								<label><input type="checkbox" name="chk2" />&nbsp;동의합니다.</label>        
							</div>
						</td>
					</tr>
				</table>
			</section>
			
			<div>
				<a href="/farmstory/user/login.do" class="btnCancel">취소</a>
				<a href="/farmstory/user/register.do" class="btnNext">다음</a> 
				
				<%-- a태그는 자체적으로 클릭 이	벤트를 가지고있어서 비활성화 시켜줘야함! --%>
			</div>
			
		</div>
	
<%@include file ="../_footer.jsp" %>











