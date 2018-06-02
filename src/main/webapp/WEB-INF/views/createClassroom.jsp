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

<title>Myclass.pl - panel nowej klasy</title>

<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="vendor/login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/login/css/util.css">
<link rel="stylesheet" type="text/css" href="vendor/login/css/main.css">
<!--===============================================================================================-->
</head>

<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form:form method="post" modelAttribute="classrooms"
					class="login100-form validate-form">
					<span class="login100-form-title p-b-70"> Witaj, obecnie
						jedynym dostępnym pakietem jest pakiet basic. </span>
					<span class="login100-form-avatar"> <img
						src="vendor/login/images/hello.png" alt="AVATAR">
					</span>

					<div class="wrap-input100 validate-input m-t-85 m-b-35"
						data-validate="Wprowadź nazwę swojej klasy">
						<form:input path="name" class="input100" type="text" name="name" />
						<span class="focus-input100"
							data-placeholder="Jak nazwiesz swoją klasę?"></span>
					</div>


					<div class="container-login100-form-btn">
						<button class="login100-form-btn">Utwórz klasę</button>
					</div>

					<ul class="login-more p-t-190">
						<li class="m-b-8"><span class="txt1"> Potrzebujesz
								pomocy?</span> <a href="#" class="txt2"> Kliknij tutaj</a></li>
					</ul>
				</form:form>
			</div>
		</div>
	</div>
	<script src="vendor/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/login/vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/login/js/main.js"></script>

</body>

</html>











