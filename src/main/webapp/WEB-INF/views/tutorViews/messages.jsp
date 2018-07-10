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

<title>Tutor - wiadomości</title>
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
	<c:url value="/../sys_school/students" var="student" />
	<c:url value="/../sys_school/message" var="sendToStudent" />
	<c:url value="/../sys_school/messages" var="messagesHistory" />
	<c:url value="/../sys_school/deletemessages" var="deleteMessages" />
	<c:url value="/../sys_school/mailview" var="mailView" />

	<section id="container"> <%@ include
		file="/WEB-INF/parts/header.jsp"%> <%@ include
		file="/WEB-INF/parts/sidebar.jsp"%> <section
		id="main-content"> <section class="wrapper">
	<div class="row">
		<div class="col-lg-9 main-chart">
			<%@ include file="/WEB-INF/parts/topMenu.jsp"%>
			<div class="row mt">
				<div class="col-lg-12 mt">
					<div class="row content-panel">
						<div class="panel-heading">
							<ul class="nav nav-tabs nav-justified">
								<li class="active"><a data-toggle="tab" href="#inbox"><h4
											class="gen-case">Skrzynka odbiorcza</h4></a></li>
								<li class=""><a data-toggle="tab" href="#sendMail"
									class="contact-map"><h4 class="gen-case">Wysłane</h4></a></li>
							</ul>
						</div>
						<div class="panel-body">
							<div class="tab-content">
								<div id="inbox" class="tab-pane active">
									<section class="panel"> <header
										class="panel-heading wht-bg"> </header>
									<div class="panel-body minimal">
										<div class="table-inbox-wrap ">
											<table class="table table-inbox table-hover">
												<tbody>
													<c:forEach items="${messageSendToTutor}"
														var="messageSendToTutor">
														<c:set var="readed" value="NotReaded" />
														<c:choose>
															<c:when
																test="${messageSendToTutor.readed == 'NotReaded'}">
																<tr class="unread">
															</c:when>
															<c:otherwise>
																<tr class="">
															</c:otherwise>
														</c:choose>
														<td>${messageSendToTutor.sendByStudent.username}</td>
														<td><a href="${mailView}/${messageSendToTutor.id}">${messageSendToTutor.text}</a></td>
														<td>${messageSendToTutor.sent.format(dateTimeFormatter)}</td>
														<td><a id="add-without-image"
															class="label label-success"
															href="${messagesHistory}/${messageSendToTutor.sendByStudent.id}">Sprawdź
																wszystkie</a> <a id="remove-all" class="label label-danger"
															href="${deleteMessages}/${messageSendToTutor.id}">Usuń</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div id="sendMail" class="tab-pane">
									<section class="panel"> <header
										class="panel-heading wht-bg"> </header>
									<div class="panel-body minimal">
										<div class="table-inbox-wrap ">
											<table class="table table-inbox table-hover">
												<tbody>
													<c:forEach items="${messageSendByTutor}"
														var="messageSendByTutor">
														<c:set var="readed" value="NotReaded" />
														<c:choose>
															<c:when
																test="${messageSendByTutor.readed == 'NotReaded'}">
																<tr class="unread">
															</c:when>
															<c:otherwise>
																<tr class="">
															</c:otherwise>
														</c:choose>
														<td>Do ${messageSendByTutor.sendToStudent.username}</td>
														<td></td>
														<td><a href="${mailView}/${messageSendByTutor.id}">${messageSendByTutor.text}</a></td>
														<td>${messageSendByTutor.sent.format(dateTimeFormatter)}</td>
														<td><a id="remove-all" class="label label-danger"
															href="${deleteMessages}/${messageSendByTutor.id}">Usuń</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row mt"></div>

		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->
		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

		<div class="col-lg-3 ds">
			<%@ include file="/WEB-INF/parts/notifications.jsp"%>
			<%@ include file="/WEB-INF/parts/usersOnlineSection.jsp"%>


		</div>

	</div>
	</section> </section> <!--main content end--> <!--footer start--> <footer
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