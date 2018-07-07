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

<title>Tutor - zarządzaj swoją klasą</title>
<!-- Bootstrap core CSS -->
<link href="resources/tutorDashboard/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/tutorDashboard/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="resources/tutorDashboard/css/zabuto_calendar.css">

<link rel="stylesheet" type="text/css"
	href="resources/tutorDashboard/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="resources/tutorDashboard/css/style.css" rel="stylesheet">
<link href="resources/tutorDashboard/css/style-responsive.css"
	rel="stylesheet">
<script src="resources/tutorDashboard/js/chart-master/Chart.js"></script>
</head>
<body>
	<c:url value="../sys_school/addgrade" var="addGrade" />
	<c:url value="../sys_school/students" var="studentsList" />
	<c:url value="../sys_school/deleteexercises" var="deleteExercises" />
	<c:url value="../sys_school/editexercises" var="editExercises" />
	<c:url value="../sys_school/exercises/reminder" var="reminder" />
	<c:url value="../sys_school/solutions/setexercise" var="setExercise" />
	<section id="container"> <%@ include
		file="/WEB-INF/parts/header.jsp"%> <%@ include
		file="/WEB-INF/parts/sidebar.jsp"%> <section
		id="main-content"> <section class="wrapper">
	<div class="row">
		<div class="col-lg-9 main-chart">
			<%@ include file="/WEB-INF/parts/topMenu.jsp"%>
			<div class="row mt">
				<div class="col-md-12">
					<div class="content-panel">
						<table class="table table-striped table-advance table-hover">
							<h4>
								<i class="fa fa-angle-right"></i> Ostatnio dodane odpowiedzi
							</h4>
							<hr>
							<thead>
								<tr>
									<th><i class="fa fa-user"></i> Uczeń</th>
									<th class="hidden-phone"><i class="fa fa-tasks"></i>
										Zadanie</th>
									<th><i class="fa fa-archive"></i>Odpowiedź</th>
									<th><i class=" fa fa-calendar-check-o"></i> Dodano</th>

									<th><i class="fa fa-flash"></i>Ocena</th>
									<th><i class="fa fa-flash"></i>Dostępne akcje</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${solutions}" var="solutions">
									<c:if test="${solutions.basicExercise.student.id != null}">
										<tr>
											<td>${solutions.basicExercise.student.username}</td>
											<td>${solutions.basicExercise.title}</td>
											<td>${solutions.answer}</td>
											<td>${solutions.added}</td>
											<td>${solutions.grade}</td>
											<td><a id="add-sticky" class="label label-primary"
												href="${addGrade}/${solutions.id}">Wystaw ocene</a> <a
												id="add-without-image" class="label label-success"
												href="${studentsList}/${solutions.basicExercise.student.id}">Sprawdź
													ucznia</a></td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /content-panel -->
				</div>
				<!-- /col-md-12 -->
			</div>

			<div class="row mt">
				<div class="col-md-12">
					<div class="content-panel">
						<table class="table table-striped table-advance table-hover">
							<h4>
								<i class="fa fa-angle-right"></i> Ostatnio dodane zadania
							</h4>
							<hr>
							<thead>
								<tr>
									<th><i class="fa fa-user"></i> Uczeń</th>
									<th class="hidden-phone"><i class="fa fa-tasks"></i>
										Zadanie</th>
									<th><i class="fa fa-archive"></i>Treść zadania</th>
									<th><i class="fa fa-calendar"></i>Dodano</th>
									<th><i class="fa fa-calendar"></i>Deadline</th>
									<th><i class="fa fa-flash"></i>Dostępne akcje</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${basicExercises}" var="basicExercise">
									<tr>
										<td>${basicExercise.student.username}</td>
										<td>${basicExercise.title}<br></td>
										<td>${basicExercise.description}</td>
										<td>${basicExercise.added}</td>
										<td>${basicExercise.deadline}</td>
										<td><a id="add-without-image" class="label label-success"
											href="${editExercises}/${basicExercise.id}">Edytuj</a> <a
											id="remove-all" class="label label-warning"
											href="${reminder}/${basicExercise.id}">Przypomnij</a> <a
											id="remove-all" class="label label-danger"
											href="${deleteExercises}/${basicExercise.id}">Usuń</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /content-panel -->
				</div>
				<!-- /col-md-12 -->
			</div>


			<div class="row mt">
				<!--CUSTOM CHART START -->
				<!--custom chart end-->
			</div>
			<!-- /row -->

		</div>
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
	<! --/row --> </section> </section> <!--main content end--> <!--footer start--> <footer
		class="site-footer">
	<div class="text-center">
		myclass.pl<a href="#container" class="go-top"> <i
			class="fa fa-angle-up"></i>
		</a>
	</div>
	</footer> <!--footer end--> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/tutorDashboards/js/jquery.js"></script>
	<script src="resources/tutorDashboard/js/jquery-1.8.3.min.js"></script>
	<script src="resources/tutorDashboard/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="resources/tutorDashboard/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/tutorDashboard/js/jquery.scrollTo.min.js"></script>
	<script src="resources/tutorDashboard/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script src="resources/tutorDashboard/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="resources/tutorDashboard/js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="resources/tutorDashboard/js/sparkline-chart.js"></script>
	<script src="resources/tutorDashboard/js/zabuto_calendar.js"></script>
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
                    url: "show_data.?action=1",
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