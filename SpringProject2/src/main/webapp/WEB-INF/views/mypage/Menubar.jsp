<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="id" value="${id }" scope="session" />
<c:set var="name" value="${name }" scope="session" />
<c:set var="agree" value="${agree }" scope="session" />


<c:choose>
	<c:when test="${agree eq 99 }">

		<div class="register_left">

			<div id="register_left_01_box">
				<span id="register_left_01_span">관리자페이지</span>
			</div>

			<div id="register_left_02_box"></div>
			<div id="register_left_03_box">
				<ul>
					<li class="register_li_1"><a href="./mCtrl?flag=5" class="register_a">회원정보
							수정</a></li>
					<li class="register_li_2"><a href="./mCtrl?flag=9"
						class="register_a">과목 추가/변경</a></li>
					<li class="register_li_3"><a href="./myCtrl?flag=2" class="register_a">회원
							등록 현황</a></li>
					<li class="register_li_4"><a href="#" class="register_a">개인정보처리방침</a></li>
				</ul>
			</div>

		</div>
	</c:when>
<c:when test="${agree eq 0 }">
<div class="register_left">

	<div id="register_left_01_box">
		<span id="register_left_01_span">마이 페이지</span>
	</div>

	<div id="register_left_02_box"></div>
	<div id="register_left_03_box">
		<ul>
			<li class="register_li_1"><a href="./mCtrl?flag=7" class="register_a">내강의실</a></li>
			<li class="register_li_1"><a href="./myCtrl?flag=0" class="register_a">강의신청</a></li>
			<li class="register_li_2"><a href="./myCtrl?flag=3" class="register_a">나의 Q&A</a></li>
			<li class="register_li_3"><a href="./mCtrl?flag=6" class="register_a">회원정보관리</a></li>
		</ul>
	</div>

</div>

</c:when>
<c:when test="${id eq null }">
<div class="register_left">

	<div id="register_left_01_box">
		<span id="register_left_01_span">회원정보</span>
	</div>

	<div id="register_left_02_box"></div>
	<div id="register_left_03_box">
		<ul>
			<li class="register_li_1"><a href="#" class="register_a">로그인</a></li>
			<li class="register_li_2"><a href="index.jsp?destpage=mRegister.jsp" class="register_a">회원가입</a></li>
			<li class="register_li_3"><a href="#" class="register_a">아이디/비밀번호
					찾기</a></li>
			<li class="register_li_4"><a href="#" class="register_a">이용약관</a></li>
			<li class="register_li_5"><a href="#" class="register_a">개인정보처리방침</a></li>
		</ul>
	</div>

</div>

</c:when>
</c:choose>