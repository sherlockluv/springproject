<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE 2 | Log in</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- iCheck -->
<link href="/resources/plugins/iCheck/square/blue.css" rel="stylesheet"
	type="text/css" />
</head>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="/"><b>Spring Project</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>

<form action="/loginPost" method="post">
<div class="form-group has-feedback">
<input type="text" name="id" class="form-control" placeholder="USER ID"/>
<span class="glyphicon glyphicon-envelope form-control-feedback" >
</span>

</div>

<div class="form-group has-feedback">
<input type="password" name="pwd" class="form-control" placeholder="Password"/>
<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
</div>

<div class="row">
<div class="col-xs-8">
<div class="checkbox icheck">
<label>
<input type="checkbox" name="useCookie"> Remember Me
</label>
</div>
</div>
<div class="col-xs-4">
<button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
</div>
</div>

</form>
	<a href="#">I forgot my password</a><br> <a href="#"
				class="text-center">Register a new membership</a>

</div>
</div>
	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>

	<!-- 순서에 유의 -->
<!-- 	<script type="text/javascript" src="/resources/js/rsa.js"></script>
	<script type="text/javascript" src="/resources/js/jsbn.js"></script>
	<script type="text/javascript" src="/resources/js/prng4.js"></script>
	<script type="text/javascript" src="/resources/js/rng.js"></script>  -->

	<!-- Bootstrap 3.3.2 JS -->
	<script src="/resources/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- iCheck -->
	<script src="/resources/plugins/iCheck/icheck.min.js"
		type="text/javascript"></script>
	<script>
		$(function() {

$(".btn-login").on("click", function(e) {

				e.preventDefault();

			
				console.log($("input[name='id']").val());
				console.log($("input[name='pwd']").val());

				//사용자 계정정보를 암호화 처리
				var encuid = rsa.encrypt($("input[name='id']").val());
				var encpwd = rsa.encrypt($("input[name='pwd']").val());

				$("input[name='id']").val(encuid);
				$("input[name='pwd']").val(encpwd);

				$("#loginForm").submit();

			});
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>
