//src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">

$(document).ready(function() {
	// 사용할 배너
	var $banner = $(".main_silde").find("ul");
	var $tablink = $(".tablink");
	var $bannerWidth = $banner.children().outerWidth();// 배너 이미지의 폭
	var $bannerHeight = $banner.children().outerHeight(); // 높이
	var $bannerLength = $banner.children().length;// 배너 이미지의 갯수
	var rollingId;

	rollingId = setInterval(function() {
		rollingStart();
	}, 5000);
	$banner.mouseover(function() {

		clearInterval(rollingId);
		$(this).css("cursor", "pointer");

	});
	$banner.mouseout(function() {
		rollingId = setInterval(function() {
			rollingStart();
		}, 5000);
		$(this).css("cursor", "default");

	});

	$tablink.click(function() {
		var i, tabcontent, tablinks;

		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";

		}
		tablinks = document.getElementsByClassName("tablink");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].style.backgroundColor = "#f0f0f0";
		}
		document.getElementById("study_01").style.display = "block";
		document.getElementById("study_02").style.display = "block";

	})

	function rollingStart() {
		$banner.css("width", $bannerWidth * $bannerLength + "px");
		$banner.css("height", $bannerHeight + "px");
		$banner.animate({
			left : -$bannerWidth + "px"
		}, 1500, function() {
			$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
			$(this).find("li:first").remove();
			$(this).css("left", 0);
		});
	}

});

// src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">

// 쿠키저장 함수
function setCookie(name, value, expiredays) {
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + expiredays);
	document.cookie = name + "=" + escape(value) + "; path=/; expires="
			+ todayDate.toGMTString() + ";"
}

$(document).ready(function() {
	$("#promotionBanner .btnClose").click(function() {
		// 오늘만 보기 체크박스의 체크 여부를 확인 해서 체크되어 있으면 쿠키를 생성한다.
		if ($("#chkday").is(':checked')) {
			setCookie("topPop", "done", 1);
			// alert("쿠키를 생성하였습니다.");
		}
		// 팝업창을 위로 애니메이트 시킨다. 혹은 slideUp()
		// $('#promotionBanner').animate({height: 0}, 500);
		$('#promotionBanner').slideUp(100);
	});
});

// open_win()

$(document).ready(
		function() {

			setViewTime = function() { // 함수로 만들어 준다.

				// 아래 부분 입력창에서 가져오지 않고 그냥 셋팅해도 된다.
				var getYear = '2018';
				var getMonth = '11';
				var getDay = '11';

				var dat1 = new Date(); // 현재날짜
				var dat2 = new Date(getYear, getMonth - 1, getDay); // 월에서 1 빼줘야
				// 함

				var diff = dat2 - dat1; // 날짜 빼기

				var currSec = 1000; // 밀리세컨
				var currMin = 60 * 1000; // 초 * 밀리세컨
				var currHour = 60 * 60 * 1000; // 분 * 초 * 밀리세컨
				var currDay = 24 * 60 * 60 * 1000; // 시 * 분 * 초 * 밀리세컨

				var day = parseInt(diff / currDay);
				var hour = parseInt(diff / currHour);
				var min = parseInt(diff / currMin);
				var sec = parseInt(diff / currSec);

				var viewHour = hour - (day * 24);
				var viewMin = min - (hour * 60);
				var viewSec = sec - (min * 60);

				// 시분초 말고 일까지만 보여주면 day만 노출하면 된다.
				var viewStr = day + "일 " + viewHour + "시 " + viewMin + "분 "
						+ viewSec + "초";

				$("#dateView").html(
						"<span style='font-size: 10pt;'><b>" + viewStr
								+ "</b></span>");

			}

			setInterval('setViewTime()', 1000);

		});
// 저장된 해키가 있으면 창을 안 띄운다 없으면 뛰운다.

$(document).ready(function() {
	cookiedata = document.cookie;
	if (cookiedata.indexOf("topPop=done") < 0) {
		document.all['promotionBanner'].style.display = "block";
	} else {
		document.all['promotionBanner'].style.display = "none";
	}

});

function appendYear() {

	var date = new Date();

	var year = date.getFullYear();

	var selectValue = document.getElementById("year");

	var optionIndex = 0;

	for (var i = year - 100; i <= year; i++) {

		selectValue.add(new Option(i + "년", i), optionIndex++);

	}

}

function appendMonth() {

	var selectValue = document.getElementById("month");

	var optionIndex = 0;

	for (var i = 1; i <= 12; i++) {

		selectValue.add(new Option(i + "월", i), optionIndex++);

	}

}

function appendDay() {

	var selectValue = document.getElementById("day");

	var optionIndex = 0;

	for (var i = 1; i <= 31; i++) {

		selectValue.add(new Option(i + "일", i), optionIndex++);

	}

}





