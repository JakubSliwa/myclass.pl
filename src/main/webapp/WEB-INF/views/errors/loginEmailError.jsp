<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Myclass.pl - błąd logowania</title>

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

	<c:url value="../sys_school/loginStudent" var="loginStudent" />
	<c:url value="../sys_school/loginTutor" var="loginTutor" />
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">

				<span class="login100-form-title p-b-70"> <br>
					<h3>Myclass.pl</h3>
				</span> <span class="login100-form-avatar"> <img
					src="resources/login/images/hello.png" alt="AVATAR">
				</span> <span class="login100-form-title p-b-70"> <br>
					<h3>Wystąpił błąd podczas logowania.</h3>
					<h4>Zweryfikuj, czy wpisałeś poprawny email.</h4>
					</br> <h3>Zaloguj się ponownie na koncie:</h3>
				</span> </span>



				<div class="container-login100-form-btn">
					<a class="login100-form-btn" href="${loginStudent}">Ucznia</a>
				</div>
				<br>
				<div class="container-login100-form-btn">
					<a class="login100-form-btn" href="${loginTutor}">Nauczyciela</a>
				</div>
				<ul class="login-more p-t-190">
					<li class="m-b-8"><span class="txt1"> Potrzebujesz
							pomocy?</span> <a href="#" class="txt2"> Kliknij tutaj</a></li>
				</ul>

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











