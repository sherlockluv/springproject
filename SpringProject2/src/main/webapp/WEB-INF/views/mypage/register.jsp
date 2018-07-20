
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function CheckForm(Join) {

		//체크박스 체크여부 확인 [하나]
		var chk1 = document.myform.U_checkAgreement1.checked;
		var chk2 = document.myform.U_checkAgreement2.checked;

		if (!chk1) {
			alert('약관1에 동의해 주세요');
			return false;
		}
		if (!chk2) {
			alert('약관2에 동의해 주세요');
			return false;
		}

	}
</script>





<div class="register_center">


	<div class="register_right">

		<div class="register_input">회원정보입력</div>
		<div class="register_text">회원가입약관</div>
		
		<div class="registerA_textarea"></div>

		
	

		<form action="/mypage/registerPost" method="post"
			onSubmit="return CheckForm(this)" id="myform" name="myform">
			<div class="check">
				<label for="agree1">이용약관에 동의<span class="check_import">(필수)</span></label>
				<input type="checkbox" name="U_checkAgreement1"
					id="U_checkAgreement1" value="">
			</div>


			<div class="register_right"></div>

			<div class="registerA_textarea" id="SirenDiv"></div>



			<div class="check">
				<label for="agree2">이용약관에 동의<span class="check_import">(필수)</span></label>
				<input type="checkbox" name="U_checkAgreement2"
					id="U_checkAgreement2" value="">
			</div>




			<div class="register_right">
				<input type="hidden" name="flag" value="1">
				<table>
					<colgroup>
						<col style="width: 195px">
					</colgroup>

					<tr>
						<td class="main_font" style="border-top: none">이름</td>
						<td style="border-top: none"><input type="text" name="name"
							required></td>
					</tr>

					<tr>

						<td class="main_font">생년월일</td>

						<td><input type="hidden" name="birthday" required> <select
							id="year" name="year" onclick="appendYear()">

								<option>- 선택하세요 -</option>

						</select> <select id="month" name="month" name="bithday"
							onclick="appendMonth()">

								<option>- 선택하세요 -</option>

						</select> <select id="day" name="day" name="bithday" onclick="appendDay()">

								<option>- 선택하세요 -</option>

						</select></td>

					</tr>




					<tr>
						<td class="main_font">아이디</td>
						<td><input type="text" name="id" placeholder="id" id="id"
							required> <span id="checkid" class="check2"
							style="display: inline-block;"> &nbsp;&nbsp;5~10자로 한글/특수문자
								입력불가</span></td>
					</tr>
					<tr>
						<td class="main_font">비밀번호</td>
						<td><input type="password" name="pwd" required></td>


					</tr>
					<tr>
						<td class="main_font">비밀번호 확인</td>
						<td><input type="password" name="rpwd" required></td>


					</tr>


					<tr>
						<td class="main_font">학년</td>
						<td><input type="checkbox" name="grade" class="checkbox"
							value="고1" onSubmit="return checkbox(this)"> 고1 <input
							type="checkbox" name="grade" class="checkbox" value="고2"
							onSubmit="return checkbox(this)"> 고2 <input
							type="checkbox" name="grade" class="checkbox" value="고3"
							onSubmit="return checkbox(this)"> 고3</td>
					</tr>
					<tr>
						<td class="main_font">주소</td>
						<td><input type="text" name="address" required></td>


					</tr>

					<tr>
						<td class="main_font">학교</td>
						<td><input type="text" name="school" required></td>


					</tr>
					<tr>
						<td class="main_font">전화번호</td>
						<td><input type="text" name="hometel">&nbsp;&nbsp;<input
							type="checkbox" name="hometel" value="N" class="check1">
							<span class="checkmark"></span>없음</td>



					</tr>

					<tr>
						<td class="main_font">부모님 휴대전화</td>
						<td><input type="text" name="ptel">&nbsp;&nbsp;<input
							type="checkbox" name="ptel" value="N" class="check1"> <span
							class="checkmark"></span>없음</td>


					</tr>

					<tr>
						<td class="main_font">휴대전화</td>
						<td>
							<div class="check2" style="padding-bottom: 30px;">

								<span> 아이디/비밀번호 찾기 및 기타 본인 확인 시 필요한 정보입니다. 정확한 정보를
									입력해주세요. (-제외)</span>
							</div> <input type="text" name="tel">&nbsp;&nbsp;<input
							type="checkbox" name="tel" value="N" class="check1"> <span
							class="checkmark"></span>없음

							<div class="check2" style="padding-top: 30px;">
								<input type="checkbox" name="telad" value="Y" class="check1">
								<span class="checkmark"></span> <span
									style="margin-bottom: 30px;">&nbsp;학습 정보, 이벤트에 대한 알림
									메시지를 수신 동의합니다.</span>
							</div>


							<div class="check2">
								<span style="margin-bottom: 30px;">입시설명회 정보 및 신규 상품 안내를
									위한 마케팅정보를 받으시겠습니까? (동의를 거부하셔도 서비스 이용에 불이익은 없습니다.)</span>
							</div>

						</td>
					</tr>

					<tr>
						<td class="main_font" style="border-bottom: none">이메일</td>
						<td style="border-bottom: none">
							<div class="check2" style="padding-bottom: 30px;">
								<span>아이디/비밀번호 찾기 및 기타 본인 확인 시 필요한 정보입니다. 정확한 정보를 입력해주세요.</span>
							</div>
							<div>
								<input type="text" name="email" required> <span
									class="checkmark"></span>
							</div>
							<div style="padding-top: 30px;">
								<input type="checkbox" name="emailad" value="Y"> <span
									class="check2"> &nbsp;이투스 신규 상품 안내 및 광고성 정보 메일 수신에
									동의합니다.Hanmail(한메일)의 경우 수신이 불가할 수 있으니 다른 메일로 등록해주세요 </span>
							</div>

						</td>
					</tr>

				</table>


				<p class="text-center">
					<input type="submit" value="확인">

					<button type="reset">Reset</button>
				</p>

			</div>





		</form>
	</div>

</div>



<script>
	$("#id").blur(
			function() {
				$.post("../__projectJsp/mCtrl", {
					'id' : $('#id').val(),
					'flag' : '2'
				}, function(data) {
					if (data == '0') {
						$('#checkid').html("&nbsp;사용 가능한 아이디입니다.").css("color",
								"green");
					} else {
						$('#checkid').html("&nbsp;사용 중인 아이디입니다.").css("color",
								"red");
						$('#id').focus();
					}
				});
			})
</script>



<script>
	$(document)
			.ready(
					function() {
						//라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
						$('input[type="checkbox"][name="grade"]')
								.click(
										function() {
											//클릭 이벤트 발생한 요소가 선택 상태일 경우
											//체크된 요소 확인후 복수개 선택되있을 경우 체크 해제
											if ($(this).prop('checked')
													&& $('input[type="checkbox"][name="grade"]:checked').length > 1) {
												$(this).prop('checked', false);
												alert('두개 이상 선택할 수 없습니다.');
											}
										});
						$('input:checkbox[name="grade"]').val();
					});
</script>

