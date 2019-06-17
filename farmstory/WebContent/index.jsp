<%@ page  contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="./_head.jsp" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<% 
if(request.getRequestURI().equals(request.getContextPath()+"/")) {
	response.sendRedirect("/farmstory/index.do");
}
%>
      <main>
        <div class="slider">

          <img src="./img/main_slide_img_tit.png" class="slogan" alt="사람과 자연을 사랑하는 팜스토리"/>

          <ul>
            <li><img src="./img/main_slide_img1.jpg" alt="슬라이드1"/></li>
            <li><img src="./img/main_slide_img2.jpg" alt="슬라이드2"/></li>
            <li><img src="./img/main_slide_img3.jpg" alt="슬라이드3"/></li>
          </ul>

          <article>
            <img src="./img/main_banner_txt.png" alt="GRAND OPEN"/>
            <img src="./img/main_banner_tit.png" alt="팜스토리 오픈기념 30%할인 이벤트"/>
            <img src="./img/main_banner_img.png" alt="이미지"/>
          </article>

        </div>
        <div class="banner">
          <a href="/farmstory/board/list.do?grp=community&cate=menu"><img src="./img/main_banner_sub1_tit.png" alt="팜스토리 오늘의 식단"/></a>
          <a href="/farmstory/board/list.do?grp=community&cate=chef"><img src="./img/main_banner_sub2_tit.png" alt="팜스토리 나도 요리사"/></a>
        </div>

        <div class="latest">
          <article>
            <a href="/farmstory/board/list.do?grp=croptalk&cate=grow"><img src="./img/main_latest1_tit.png" alt="텃밭가꾸기"></a>
            <img src="./img/main_latest1_img.jpg" alt="이미지">
            <table border="0">
              <c:forEach var="vo" items="${list1}"><%--requestScope.생략 --%>		 
				<tr>
					<td>></td>
					<td><a href="/farmstory/board/view.do?grp=croptalk&cate=${vo.cate}&seq=${vo.seq}">${vo.title}</a></td>					
					<td>${vo.rdate.substring(2,10)}</td>											
				</tr>
			  </c:forEach>	
            </table>
          </article>
          <article>
            <a href="/farmstory/board/list.do?grp=croptalk&cate=school"><img src="./img/main_latest2_tit.png" alt="귀농학교"></a>
            <img src="./img/main_latest2_img.jpg" alt="이미지">
            <table border="0">
                <c:forEach var="vo" items="${list2}"><%--requestScope.생략 --%>		 
				<tr>
					<td>></td>
					<td><a href="/farmstory/board/view.do?grp=croptalk&cate=${vo.cate}&seq=${vo.seq}">${vo.title}</a></td>					
					<td>${vo.rdate.substring(2,10)}</td>											
				</tr>
			  </c:forEach>	
            </table>
          </article>
          <article>
            <a href="/farmstory/board/list.do?grp=croptalk&cate=story"><img src="./img/main_latest3_tit.png" alt="농작물이야기"></a>
            <img src="./img/main_latest3_img.jpg" alt="이미지">
            <table border="0">
            	<c:forEach var="vo" items="${list3}"><%--requestScope.생략 --%>		 
				<tr>
					<td>></td>
					<td><a href="/farmstory/board/view.do?cate=${vo.cate}&seq=${vo.seq}">${vo.title}</a></td>					
					<td>${vo.rdate.substring(2,10)}</td>											
				</tr>
			  </c:forEach>	
            </table>
          </article>

        </div>

      <div class="info">
          <div>
            <img src="./img/main_sub2_cs_tit.png" alt="고객센터">
            <img src="./img/main_sub2_cs_img.png" alt="전화기">
            <img src="./img/main_sub2_cs_txt.png" alt="번호">
            <p>평일: AM 09:00 ~ PM 06:00<br>
              	점심: PM 12:00 ~ PM 01:00 <br>
              	토, 일요일, 공휴일 휴무<br></p>
              <div>
                <a href="/farmstory/board/list.do?grp=community&cate=qna"><img src="./img/main_sub2_cs_bt1.png" alt="1:1고객문의"> </a>
                <a href="/farmstory/board/list.do?grp=community&cate=faq"><img src="./img/main_sub2_cs_bt2.png" alt="자주묻는질문"> </a>
                <a href="#"><img src="./img/main_sub2_cs_bt3.png" alt="배송조회"> </a>
              </div>
          </div>

          <div>
            <img src="./img/main_sub2_account_tit.png" alt="">
            <p>기업은행 123-456789-01-01-012<br>
              국민은행 01-1234-56789<br>
              우리은행 123-456789-01-01-012<br>
              하나은행 123-456789-01-01<br>
              예 금 주 (주)팜스토리</p>
          </div>
          <div></div>
        </div>

      </main>
   <%@ include file="./_footer.jsp"%>