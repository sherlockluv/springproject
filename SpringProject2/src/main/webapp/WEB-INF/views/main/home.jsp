<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

</style>


<style type="text/css">
<!--
	body {font-size:11pt; padding:0; margin:0; text-align: center;}
	h3 {color: #85144b; font-size: 14pt; margin:10 auto; padding: 10px;}
	.contents { background-color: #d6d6d6; margin: 0 auto; overflow: hidden;}
	
	/* banner */
	.banner {position: relative; width: 1080px; height: 500px;  margin:0 auto; padding:0; overflow: hidden;}
	.banner ul {position: absolute; margin: 0px; padding:0; list-style: none; }
	.banner ul li {float: left;  height: 500px; margin:0; padding:0;}



//-->
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>




	<div class="contents">


		<div class="banner">
			<ul>
				
				<li><img src="/resources/img/img2.png" width="1080px" height="500px" class="mySlides fade" id="banner_img1"></li>
					<li><img src="/resources/img/img2.png" width="1080px" height="500px" class="mySlides fade" id="banner_img2"></li>
						<li><img src="/resources/img/img2.png" width="1080px" height="500px" class="mySlides fade" id="banner_img3"></li>
							<li><img src="/resources/img/img2.png" width="1080px" height="500px" class="mySlides fade" id="banner_img4"></li>
				
			</ul>
		</div>
		
	
		<div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span> 
    <span class="dot" onclick="currentSlide(2)"></span> 
    <span class="dot" onclick="currentSlide(3)"></span>
    <span class="dot" onclick="currentSlide(4)"></span>
</div>
	</div>



	




 

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	//사용할 배너

	
	var $banner = $(".banner").find("ul");
	var slide = $(".mySlides");
	var $bannerWidth = $banner.children().outerWidth();//배너 이미지의 폭
	var $bannerHeight = $banner.children().outerHeight(); // 높이
	var $bannerLength = $banner.children().length;//배너 이미지의 갯수
	var rollingId;
	var n = 1;
	var dot = $(".dot");
	
	
	//정해진 초마다 함수 실행
	rollingId = setInterval(function() { rollingStart(); }, 5000);//다음 이미지로 롤링 애니메이션 할 시간차

	//마우스 오버시 롤링을 멈춘다.
	$banner.mouseover(function(){
		//중지
		clearInterval(rollingId);
		$(this).css("cursor", "pointer");
	});
	//마우스 아웃되면 다시 시작
	$banner.mouseout(function(){
		rollingId = setInterval(function() { rollingStart(n); }, 3000);
		$(this).css("cursor", "default");
	});
	
	
	
	function rollingStart() {
		$banner.css("width", $bannerWidth * $bannerLength + "px");
		$banner.css("height", $bannerHeight + "px");
		//alert(bannerHeight);
		//배너의 좌측 위치를 옮겨 준다.
		$banner.animate({left: - $bannerWidth + "px"}, 1500, function() { //숫자는 롤링 진행되는 시간이다.
			//첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
			$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
			//뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
			$(this).find("li:first").remove();
			//다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
			$(this).css("left", 0);
			//이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
		});
	}
	
	function currentSlide(index) {
        if (index> slide.length) {index = 1}
        else if(index<1){index = slide.length}
        for (i = 0; i < slide.length; i++) {
           slide[i].style.display = "none";  
        }
        for (i = 0; i < dot.length; i++) {
            dot[i].className = dot[i].className.replace(" active", "");
            slide[index-1].style.display = "block";  
            dot[index-1].className += " active";
        }
    }
	
}); 





</script>


