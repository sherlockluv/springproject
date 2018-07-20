<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="nav">

	<div class="nav_center">
		<c:catch>
			<c:choose>
				<c:when test="${login.id eq null }">
					<div class="nav_left">
						<ul>
							<li><a class="nav_left_A nav_C" href="index.jsp">홈</a></li>
							<li><a class="nav_left_A" href="#">학원소개</a></li>

						</ul>
					</div>
					<div class="nav_right">
						<ul>
							<li><span class="nav_right_B nav_C">수능D-DAY </span><span
								id="dateView" style="color: #ef544d"></span></li>
							<li><a class="nav_right_B" href="#" id="myLoginBtn">로그인</a></li>


							<li><a class="nav_right_B btn_register"
								href="#">회원가입</a></li>
							<li><a class="nav_right_B" href="#">아이디 비밀번호 찾기</a></li>
							<li><a class="nav_right_B" href="index.jsp?destPage=mLogin">마이페이지</a></li>
						</ul>
					</div>

				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${login.agree eq '99' }">
							<div class="nav_left">
								<ul>
									<li><a class="nav_left_A nav_C" href="index.jsp">홈</a></li>
									<li><a class="nav_left_A" href="#">학원소개</a></li>

								</ul>
							</div>
							<div class="nav_right">
								<ul>
									<li><a class="nav_right_B nav_C" href="#">수능D-DAY <span
											id="dateView" style="color: #ef544d"></span>
									</a></li>
									<li><a class="nav_right_B" href="./mCtrl?flag=5">${login.id}-관리자</a></li>
									<li><a class="nav_right_B logout" href="#">로그아웃</a></li>
									<li><a class="nav_right_B" href="./mCtrl?flag=5">관리자페이지</a></li>
									<!-- 					<li><a class="nav_right_B" href="./mCtrl?flag=3">아이디 비밀번호 찾기</a></li>
					<li><a class="nav_right_B" href="./mCtrl?flag=3">마이페이지</a></li> -->
								</ul>
							</div>

						</c:when>

						<c:otherwise>
							<c:choose>
								<c:when test="${login.agree eq'3' }">
									<div class="nav_left">
										<ul>
											<li><a class="nav_left_A nav_C" href="index.jsp">홈</a></li>
											<li><a class="nav_left_A" href="#">학원소개</a></li>

										</ul>
									</div>
									<div class="nav_right">
										<ul>
											<li><a class="nav_right_B nav_C" href="#">수능D-DAY <span
													id="dateView" style="color: #ef544d"></span>
											</a></li>
											<li><a class="nav_right_B" href="./mCtrl?flag=">${login.name }(${login.id })선생님</a></li>
											<li><a class="nav_right_B logout" href="#">로그아웃</a></li>
											<li><a class="nav_right_B" href="./mCtrl?flag=">선생님페이지</a></li>
											<!-- 					<li><a class="nav_right_B" href="./mCtrl?flag=3">아이디 비밀번호 찾기</a></li>
					<li><a class="nav_right_B" href="./mCtrl?flag=3">마이페이지</a></li> -->
										</ul>
									</div>

								</c:when>


								<c:otherwise>

									<div class="nav_left">
										<ul>
											<li><a class="nav_left_A nav_C" href="index.jsp">홈</a></li>
											<li><a class="nav_left_A" href="#">학원소개</a></li>

										</ul>
									</div>
									<div class="nav_right">
										<ul>
											<li><a class="nav_right_B nav_C" href="#">수능D-DAY <span
													id="dateView" style="color: #ef544d"></span>
											</a></li>
											<li><a class="nav_right_B" href="./mCtrl?flag=7">${login.name }(${login.id }
													)</a></li>
											<li><a class="nav_right_B logout" href="#">로그아웃</a></li>
											<li><a class="nav_right_B" href="./mCtrl?flag=7">마이페이지</a></li>
											<!-- 					<li><a class="nav_right_B" href="./mCtrl?flag=3">아이디 비밀번호 찾기</a></li>
					<li><a class="nav_right_B" href="./mCtrl?flag=3">마이페이지</a></li> -->
										</ul>
									</div>
								</c:otherwise>
							</c:choose>

						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:catch>

		<div class="search_box">

			<div class="side_banner">
				<a href="#"><img src="/resources/img/banner2.png"></a>
			</div>
		</div>




	</div>
</nav>

<div class="nav2">
	<div class="nav2_center">
		<div class="nav_left">

			<ul>
<div class="dropdown">
				<li><a class="nav2_left_A nav2_C dropbtn" href="#" >전체선생님</a></li>
				
		 <div class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
    </div>
				<li><a class="nav2_left_A " href="#">전체 강좌</a></li>
				<li><a class="nav2_left_A" style="color: #fff1a2">고3</a></li>
				<li><a class="nav2_left_A" href="#">강의</a></li>
				<li><a class="nav2_left_A" style="color: #fff1a2">고1,고2</a></li>
				<li><a class="nav2_left_A" href="#">강의</a></li>


			</ul>
		</div>

	</div>


</div>

<form action="/loginPost" method="post">
	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->

		<div class="modal-content">
			<span class="close">&times;</span>
			<h3 id="loginH3">login.</h3>
			<!-- 서버에서 전달한 값을 셋팅한다. -->





			<input type="text" name="id" class="inp_login" placeholder="&nbsp;ID" />



			<input type="password" name="pwd" class="inp_login"
				placeholder="&nbsp;비밀번호" />




			<div class="checkbox icheck">
				<label> <input type="checkbox" name="useCookie"> 아이디
					저장
				</label>
			</div>


			<button type="submit" class="btn_login">Sign In</button>

		</div>
	</div>

</form>

<script>
	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	var btn = document.getElementById("myLoginBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal 
	btn.onclick = function() {
		modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>

<script type="text/javascript"></script>

<script>
	$(".logout").on("click", function(e) {

		self.location = "/logout";

	});
	
	$(".btn_register").on("click", function(e) {
		
		location.href="/mypage/register";
	});
</script>





