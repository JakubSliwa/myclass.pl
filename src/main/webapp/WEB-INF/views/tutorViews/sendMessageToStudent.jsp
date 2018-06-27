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

<title>Tutor - pokaż studenta</title>
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
	<c:url value="/../sys_school/editstudents" var="editStudent" />
	<c:url value="/../sys_school/message" var="sendToStudent" />
	<section id="container"> <%@ include
		file="/WEB-INF/parts/header.jsp"%> <%@ include
		file="/WEB-INF/parts/sidebar.jsp"%> <section
		id="main-content"> <section class="wrapper">
	<div class="row">
		<div class="col-lg-9 main-chart">
			<%@ include file="/WEB-INF/parts/topMenu.jsp"%>
			<!-- /row mt -->
			<div class="row mt">
				<div class="col-lg-12">
					<div class="form-panel">
						<h4 class="mb">
							<i class="fa fa-angle-right"></i> Wyślij nową wiadomość do
							${studentForView.username}
						</h4>
						<form:form class="form-horizontal style-form" method="post"
							modelAttribute="message">
							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Treść
									zadania</label>
								<div class="col-sm-10">
									<form:input path="text" class="form-control"
										placeholder="Wpisz treść wiadomości" type="text" />
									<form:errors path="text" />
								</div>
							</div>
							<input class="btn btn-primary" type="submit"
								value="Wyślij wiadomość">
						</form:form>
					</div>
				</div>
			</div>
			<!-- /col-md-12 -->

			<div class="row mt">
				<!--CUSTOM CHART START -->
				<!--custom chart end-->
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
	<! --/row --></section> </section> <!--main content end--> <!--footer start--> <footer
		class="site-footer">
	<div class="text-center">
		Potrzebujesz pomocy?<a href="index.html#" class="go-top"> <i
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