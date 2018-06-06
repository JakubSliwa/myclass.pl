<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<c:url value="../sys_school/dashboard" var="dashboard" />
	<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start--> <a href="${dashboard}" class="logo"><b>MYCLASS.PL</b></a>
	<!--logo end-->
	<div class="nav notify-row" id="top_menu">
		<!--  notification start -->
		<ul class="nav top-menu">

			<!-- inbox dropdown start-->
			<li id="header_inbox_bar" class="dropdown"><a
				data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
					<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">10</span>
			</a>
				<ul class="dropdown-menu extended inbox">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green">You have 5 new messages</p>
					</li>
					<li><a href=""> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-zac.jpg"></span>
							<span class="subject"> <span class="from">Zac
									Snider</span> <span class="time">Just now</span>
						</span> <span class="message"> Hi mate, how is everything? </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-divya.jpg"></span>
							<span class="subject"> <span class="from">Divya
									Manian</span> <span class="time">40 mins.</span>
						</span> <span class="message"> Hi, I need your help with this. </span>
					</a></li>
					<li><a href=""> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-danro.jpg"></span>
							<span class="subject"> <span class="from">Dan
									Rogers</span> <span class="time">2 hrs.</span>
						</span> <span class="message"> Love your new Dashboard. </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-sherman.jpg"></span>
							<span class="subject"> <span class="from">Dj
									Sherman</span> <span class="time">4 hrs.</span>
						</span> <span class="message"> Please, answer asap. </span>
					</a></li>
					<li><a href="index.html#">See all messages</a></li>
				</ul></li>
			<!-- inbox dropdown end -->
		</ul>
		<!--  notification end -->
	</div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="login.html">Logout</a></li>
		</ul>
	</div>
	</header>


</body>
</html>



