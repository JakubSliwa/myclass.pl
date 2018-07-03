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

<title>Tutor - zarządzaj kalendarzem</title>
<link href="/sys_school/resources/tutorDashboard/css/bootstrap.css"
	rel="stylesheet">
<!--external css-->
<link
	href="/sys_school/resources/tutorDashboard/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link
	href="/sys_school/resources/tutorDashboard/js/fullcalendar/bootstrap-fullcalendar.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="/sys_school/resources/tutorDashboard/css/style.css"
	rel="stylesheet">
<link
	href="/sys_school/resources/tutorDashboard/css/style-responsive.css"
	rel="stylesheet">

</head>
<body>
	<section id="container"> <%@ include
		file="/WEB-INF/parts/header.jsp"%> <%@ include
		file="/WEB-INF/parts/sidebar.jsp"%> <section
		id="main-content"> <section class="wrapper">
	<h3>
		<i class="fa fa-angle-right"></i> Kalendarz jest obecnie nie dostępny.
	</h3>
	<!-- page start-->
	<div class="row mt">
		<aside class="col-lg-3 mt">
		<h4>
			<i class="fa fa-angle-right"></i> Kalendarz jest obecnie nie
			dostępny.
		</h4>
		<div id="external-events">

			<div class="external-event label label-warning">Kalendarz jest
				obecnie nie dostępny.</div>

		</div>
		</aside>
		<aside class="col-lg-9 mt"> <section class="panel">
		<div class="panel-body">
			<div id="calendar" class="has-toolbar"></div>
		</div>
		</section> </aside>
	</div>
	</section></section> <footer class="site-footer">
	<div class="text-center">
		myclass.pl<a href="#container" class="go-top"> <i
			class="fa fa-angle-up"></i>
		</a>
	</div>
	</footer> </section>
	<script src="/sys_school/resources/tutorDashboard/js/jquery.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/fullcalendar/fullcalendar.min.js"></script>
	<script src="/sys_school/resources/tutorDashboard/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/sys_school/resources/tutorDashboard/js/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/jquery.scrollTo.min.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script src="/sys_school/resources/tutorDashboard/js/common-scripts.js"></script>

	<script
		src="/sys_school/resources/tutorDashboard/js/calendar-conf-events.js"></script>

	<script>
		$(function() {
			$("select.styled").customSelect();
		});
	</script>

</body>
</html>
