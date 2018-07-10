<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Myclass.pl - panel logowania</title>

<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="resources/login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/css/util.css">
<link rel="stylesheet" type="text/css"
	href="resources/login/css/main.css">
<!--===============================================================================================-->
</head>

<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form method="post" action="loginTutor"
					class="login100-form validate-form">

					<span class="login100-form-title p-b-70"> <br>
						<h3>Myclass.pl</h3>
					</span> <span class="login100-form-avatar"> <img
						src="resources/login/images/hello.png" alt="AVATAR">
					</span>


					<div class="wrap-input100 validate-input m-b-50"
						data-validate="Wprowadź email">
						<input class="input100" type="text" name="email" /> <span
							class="focus-input100" data-placeholder="Podaj swój email"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-50"
						data-validate="Wprowadź hasło">
						<input class="input100" type="password" name="password" /> <span
							class="focus-input100" data-placeholder="Podaj swoje hasło"></span>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">Zaloguj się</button>
					</div>
					<ul class="login-more p-t-190">
						<li class="m-b-8"><span class="txt1"> myclass.pl</span></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<script src="resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/login/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="resources/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="resources/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="resources/login/js/main.js"></script>
</body>

</html>











