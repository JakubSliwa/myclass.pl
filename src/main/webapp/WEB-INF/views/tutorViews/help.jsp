<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
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

<title>Tutor - pomoc</title>
<!-- Bootstrap core CSS -->
<link href="/sys_school/resources/tutorDashboard/css/bootstrap.css"
	rel="stylesheet">
<!--external css-->
<link
	href="/sys_school/resources/tutorDashboard/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="/sys_school/resources/tutorDashboard/css/zabuto_calendar.css">

<link rel="stylesheet" type="text/css"
	href="/sys_school/resources/tutorDashboard/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="/sys_school/resources/tutorDashboard/css/style.css"
	rel="stylesheet">
<link
	href="/sys_school/resources/tutorDashboard/css/style-responsive.css"
	rel="stylesheet">

<script
	src="/sys_school/resources/tutorDashboard/js/chart-master/Chart.js"></script>
</head>
<body>
	<section id="container"> <%@ include
		file="/WEB-INF/parts/header.jsp"%> <%@ include
		file="/WEB-INF/parts/sidebar.jsp"%> <section
		id="main-content"> <section class="wrapper">
	<div class="row">
		<div class="col-lg-9 main-chart">
			<div class="row content-panel">
				<h2 class="centered">Pomoc</h2>
				<div class="col-md-10 col-md-offset-1 mt mb">
					<div class="accordion" id="accordion2">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion2" href="faq.html#collapseOne"> <em
									class="glyphicon glyphicon-chevron-right icon-fixed-width"></em>How
									to purchase this template?
								</a>
							</div>
							<div id="collapseOne" class="accordion-body collapse in">
								<div class="accordion-inner">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s, when an unknown
										printer took a galley of type and scrambled it to make a type
										specimen book. It has survived not only five centuries, but
										also the leap into electronic typesetting, remaining
										essentially unchanged.</p>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion2" href="faq.html#collapseTwo"> <em
									class="glyphicon glyphicon-chevron-right icon-fixed-width"></em>How
									can I install my server?
								</a>
							</div>
							<div id="collapseTwo" class="accordion-body collapse">
								<div class="accordion-inner">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s, when an unknown
										printer took a galley of type and scrambled it to make a type
										specimen book. It has survived not only five centuries, but
										also the leap into electronic typesetting, remaining
										essentially unchanged.</p>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion2" href="faq.html#collapseThree"> <em
									class="glyphicon glyphicon-chevron-right icon-fixed-width"></em>How
									to change color schemes?
								</a>
							</div>
							<div id="collapseThree" class="accordion-body collapse">
								<div class="accordion-inner">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s, when an unknown
										printer took a galley of type and scrambled it to make a type
										specimen book. It has survived not only five centuries, but
										also the leap into electronic typesetting, remaining
										essentially unchanged.</p>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion2" href="faq.html#collapseFour"> <em
									class="glyphicon glyphicon-chevron-right icon-fixed-width"></em>How
									to integrate Revolution Slider?
								</a>
							</div>
							<div id="collapseFour" class="accordion-body collapse">
								<div class="accordion-inner">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s, when an unknown
										printer took a galley of type and scrambled it to make a type
										specimen book. It has survived not only five centuries, but
										also the leap into electronic typesetting, remaining
										essentially unchanged.</p>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion2" href="faq.html#collapseFive"> <em
									class="glyphicon glyphicon-chevron-right icon-fixed-width"></em>How
									Can I get Support?
								</a>
							</div>
							<div id="collapseFive" class="accordion-body collapse">
								<div class="accordion-inner">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s, when an unknown
										printer took a galley of type and scrambled it to make a type
										specimen book. It has survived not only five centuries, but
										also the leap into electronic typesetting, remaining
										essentially unchanged.</p>
								</div>
							</div>
						</div>
					</div>
					<!-- end accordion -->
				</div>
				<! --col-md-10 -->

			</div>
			<div class="row mt">
				<!--CUSTOM CHART START -->
				<!--custom chart end-->
			</div>
			<!-- /row -->

		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->
		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

		<div class="col-lg-3 ds">
			<%@ include file="/WEB-INF/parts/notifications.jsp"%>
			<%@ include file="/WEB-INF/parts/usersOnlineSection.jsp"%>

			<!-- CALENDAR-->
			<div id="calendar" class="mb">
				<div class="panel green-panel no-margin">
					<div class="panel-body">
						<div id="date-popover" class="popover top"
							style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
							<div class="arrow"></div>
							<h3 class="popover-title" style="disadding: none;"></h3>
							<div id="date-popover-content" class="popover-content"></div>
						</div>
						<div id="my-calendar"></div>
					</div>
				</div>
			</div>
			<!-- / calendar -->

		</div>
		<!-- /col-lg-3 -->
	</div>
	</section> </section> <footer class="site-footer">
	<div class="text-center">
		myclass.pl<a href="#container" class="go-top"> <i
			class="fa fa-angle-up"></i>
		</a>
	</div>
	</footer> <!--footer end--> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/sys_school/resources/tutorDashboards/js/jquery.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/jquery-1.8.3.min.js"></script>
	<script src="/sys_school/resources/tutorDashboard/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/sys_school/resources/tutorDashboard/js/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/jquery.scrollTo.min.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="/sys_school/resources/tutorDashboard/js/common-scripts.js"></script>

	<!--script for this page-->
	<script
		src="/sys_school/resources/tutorDashboard/js/sparkline-chart.js"></script>
	<script
		src="/sys_school/resources/tutorDashboard/js/zabuto_calendar.js"></script>
	<script type="application/javascript">
		
		
		
		
				
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }


	
	
	
	
	
	
	
	</script>


</body>