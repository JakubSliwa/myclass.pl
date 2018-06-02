<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Myclass.pl - korepetycje pod kontrolą</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/homepage/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/homepage/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="vendor/homepage/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="css/stylish-portfolio.min.css" rel="stylesheet">
<link href="css/stylish-portfolio.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body id="page-top">
	<!-- Navigation -->
	<a class="menu-toggle rounded" href="#"> <i class="fa fa-bars"></i>
	</a>
	<nav id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<li class="sidebar-brand"><a class="js-scroll-trigger"
			href="#page-top">myclass.pl</a></li>
		<li class="sidebar-nav-item"><a class="js-scroll-trigger"
			href="#about">Załóż konto nauczyciela</a></li>
		<li class="sidebar-nav-item"><a class="js-scroll-trigger"
			href="#about">Poznaj szczegóły</a></li>
		<li class="sidebar-nav-item"><a class="js-scroll-trigger"
			href="#services">Cennik</a></li>
		<li class="sidebar-nav-item"><a class="js-scroll-trigger"
			href="#portfolio">Portfolio</a></li>
		<li class="sidebar-nav-item"><a class="js-scroll-trigger"
			href="#callout">Kontakt</a></li>
	</ul>
	</nav>

	<!-- Header -->
	<header class="masthead d-flex">
	<div class="container text-center my-auto">
		<h1 class="mb-1">myclass.pl</h1>
		<h3 class="mb-5">
			<em>Twój system zarządzania lekcjami.</em>
		</h3>
		<c:url value="../sys_school/login" var="login" />
		` <a class="btn btn-primary btn-xl js-scroll-trigger" href="${login}">Zaloguj
			się</a> &nbsp; &nbsp; &nbsp;<a
			class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Poznaj
			szczegóły</a>
	</div>
	<div class="overlay"></div>
	</header>
	<!-- About -->
	<section class="content-section bg-light" id="about">
	<div class="container text-center">
		<div class="row">
			<div class="col-lg-10 mx-auto">
				<h2>Zarejestruj się w portalu myclass.pl!</h2>
				<p class="lead mb-5">
					Zanim zaczniesz korzystać z myclass, zapoznaj się z <a
						href="#pricing">cennikiem</a>
				</p>
				<a class="btn btn-dark btn-xl js-scroll-trigger" href="#services">Załóż
					konto</a>
			</div>
		</div>
	</div>
	</section>

	<!-- Services -->
	<section class="content-section bg-primary text-white text-center"
		id="services">
	<div class="container">
		<div class="content-section-heading">
			<h3 class="text-secondary mb-0">myclass.pl</h3>
			<h2 class="mb-5">Zobacz jakie to proste!</h2>
		</div>
		<div class="row">
			<div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
				<span class="service-icon rounded-circle mx-auto mb-3"> <i>
						<img src="<c:url value="img/account.png"/>" />
				</i>
				</span>
				<h4>
					<strong>Załóż konto</strong>
				</h4>
				<p class="text-faded mb-0">Dodaj swoją klasę i zaproś do niej
					swoich uczniów!</p>
			</div>
			<div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
				<span class="service-icon rounded-circle mx-auto mb-3"> <i>
						<img src="<c:url value="img/control.png"/>" />
				</i>
				</span>
				<h4>
					<strong>Pełna kontrola</strong>
				</h4>
				<p class="text-faded mb-0">Ustalaj datę lekcji. Zadawaj zadania
					domowe, oceniaj je i dawaj feedback</p>
			</div>
			<div class="col-lg-3 col-md-6 mb-5 mb-md-0">
				<span class="service-icon rounded-circle mx-auto mb-3"> <i>
						<img src="<c:url value="img/growth.png"/>" />
				</i>
				</span>
				<h4>
					<strong>Śledź postępy</strong>
				</h4>
				<p class="text-faded mb-0">Dzięki systemowi ocen, w prosty
					sposób uzyskasz raport o postępach ucznia.</p>
			</div>
			<div class="col-lg-3 col-md-6">
				<span class="service-icon rounded-circle mx-auto mb-3"> <i>
						<img src="<c:url value="img/cash.png"/>" />
				</i>
				</span>
				<h4>
					<strong>Płatności</strong>
				</h4>
				<p class="text-faded mb-0">Utrzymaj kontrolę nad finansami.</p>

			</div>
		</div>
	</div>
	</section>



	<!-- PRICING -->
	<section class="content-section bg-light" id="pricing">
	<div class="container text-center">
		<div id="generic_price_table">
			<section>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<!--PRICE HEADING START-->
						<div class="price-heading clearfix">
							<h3>Cennik myclass.pl</h3>
						</div>
						<!--//PRICE HEADING END-->
					</div>
				</div>
			</div>
			<div class="container">

				<!--BLOCK ROW START-->
				<div class="row">
					<div class="col-md-4">

						<!--PRICE CONTENT START-->
						<div class="generic_content clearfix">

							<!--HEAD PRICE DETAIL START-->
							<div class="generic_head_price clearfix">

								<!--HEAD CONTENT START-->
								<div class="generic_head_content clearfix">

									<!--HEAD START-->
									<div class="head_bg"></div>
									<div class="head">
										<span>Basic</span>
									</div>
									<!--//HEAD END-->

								</div>
								<!--//HEAD CONTENT END-->

								<!--PRICE START-->
								<div class="generic_price_tag clearfix">
									<span class="price"> <span class="sign"></span> <span
										class="currency">Bez opłat</span>
									</span>
								</div>
								<!--//PRICE END-->

							</div>
							<!--//HEAD PRICE DETAIL END-->

							<!--FEATURE LIST START-->
							<div class="generic_feature_list">
								<ul>
									<li><span>1</span> klasa</li>
									<li>do <span>15</span> uczniów
									</li>
									<li><span>podstawowe</span> raporty</li>
									<li><span>1 GB</span> powierzchnia dysku</li>
									<li><span>24/7</span> support</li>
								</ul>
							</div>
							<!--//FEATURE LIST END-->

							<!--BUTTON START-->
							<div class="generic_price_btn clearfix">
								<a href="">Wybierz</a>
							</div>
							<!--//BUTTON END-->

						</div>
						<!--//PRICE CONTENT END-->

					</div>

					<div class="col-md-4">

						<!--PRICE CONTENT START-->
						<div class="generic_content active clearfix">

							<!--HEAD PRICE DETAIL START-->
							<div class="generic_head_price clearfix">

								<!--HEAD CONTENT START-->
								<div class="generic_head_content clearfix">

									<!--HEAD START-->
									<div class="head_bg"></div>
									<div class="head">
										<span>Standard</span>
									</div>
									<!--//HEAD END-->

								</div>
								<!--//HEAD CONTENT END-->

								<!--PRICE START-->
								<div class="generic_price_tag clearfix">
									<span class="price"> <span class="sign">ZŁ</span> <span
										class="currency">49</span> <span class="cent">.99</span> <span
										class="month">/miesięcznie</span>
									</span>
								</div>
								<!--//PRICE END-->

							</div>
							<!--//HEAD PRICE DETAIL END-->

							<!--FEATURE LIST START-->
							<div class="generic_feature_list">
								<ul>
									<li><span>1</span> klasy</li>
									<li>do <span>35</span> uczniów
									</li>
									<li><span>zaawansowane</span> raporty</li>
									<li><span>3 GB</span> powierzchnia dysku</li>
									<li><span>24/7</span> support</li>
								</ul>
							</div>
							<!--//FEATURE LIST END-->

							<!--BUTTON START-->
							<div class="generic_price_btn clearfix">
								<a href="">Wybierz</a>
							</div>
							<!--//BUTTON END-->

						</div>
						<!--//PRICE CONTENT END-->

					</div>
					<div class="col-md-4">

						<!--PRICE CONTENT START-->
						<div class="generic_content clearfix">

							<!--HEAD PRICE DETAIL START-->
							<div class="generic_head_price clearfix">

								<!--HEAD CONTENT START-->
								<div class="generic_head_content clearfix">

									<!--HEAD START-->
									<div class="head_bg"></div>
									<div class="head">
										<span>School</span>
									</div>
									<!--//HEAD END-->

								</div>
								<!--//HEAD CONTENT END-->

								<!--PRICE START-->
								<div class="generic_price_tag clearfix">
									<span class="price"> <span class="sign">ZŁ</span> <span
										class="currency">199</span> <span class="cent">.99</span> <span
										class="month">/miesięcznie</span>
									</span>
								</div>
								<!--//PRICE END-->

							</div>
							<!--//HEAD PRICE DETAIL END-->

							<!--FEATURE LIST START-->
							<div class="generic_feature_list">
								<ul>
									<li><span>5</span> klas</li>
									<li>do <span>150</span> uczniów
									</li>
									<li>do <span>5</span> nauczycieli
									</li>
									<li><span>zaawansowane</span> raporty</li>
									<li><span>10 GB</span> powierzchnia dysku</li>
									<li><span>24/7</span> support</li>
								</ul>
							</div>
							<!--//FEATURE LIST END-->

							<!--BUTTON START-->
							<div class="generic_price_btn clearfix">
								<a href="">Wybierz</a>
							</div>
							<!--//BUTTON END-->
						</div>
						<!--//PRICE CONTENT END-->
					</div>
				</div>
				<!--//BLOCK ROW END-->

			</div>
			</section>
		</div>
	</div>
	</section>




	<!-- Callout -->
	<section class="callout">
	<div class="container text-center">
		<h2 class="mx-auto mb-5">
			Zacznij zarządzać <em>swoją</em> klasą!
		</h2>
		<a class="btn btn-primary btn-xl" href="${login}">Zaloguj się!</a>
	</div>
	</section>

	<footer class="footer text-center">
	<div class="container">
		<ul class="list-inline mb-5">
			<li class="list-inline-item"><a
				class="social-link rounded-circle text-white mr-3" href="#"> <i
					class="icon-social-facebook"></i>
			</a></li>
			<li class="list-inline-item"><a
				class="social-link rounded-circle text-white mr-3" href="#"> <i
					class="icon-social-twitter"></i>
			</a></li>
			<li class="list-inline-item"><a
				class="social-link rounded-circle text-white" href="#"> <i
					class="icon-social-github"></i>
			</a></li>
		</ul>

	</div>
	</footer>



	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded js-scroll-trigger" href="#page-top">
		<i class="fa fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/homepage/jquery/jquery.min.js"></script>
	<script src="vendor/homepage/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/homepage/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/stylish-portfolio.min.js"></script>




</body>

</html>











