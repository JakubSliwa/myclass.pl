<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<c:url value="/../sys_school/dashboard" var="dashboard" />
	<c:url value="/../sys_school/logout" var="logout" />
	<c:url value="/../sys_school/students" var="student" />
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
					<i class="fa fa-envelope-o"></i> <span class="badge bg-theme"></span>
			</a>
				<ul class="dropdown-menu extended inbox">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green">You have 6 new messages</p>
					</li>
					<c:url value="/../sys_school/students" var="student" />
					<c:forEach items="${messages}" var="message">
						<li><a href="${student}/${message.sendByStudent.id}"> <span
								class="photo"><img alt="avatar"
									src="/sys_school/resources/tutorDashboard/img/ui-sam.jpg"></span>
								<span class="subject"> <span class="from">${message.sendByStudent.username}</span>
									<span class="time">${message.sent}</span>
							</span> <span class="message">${message.text}</span>
						</a></li>

					</c:forEach>
					<li><a href="index.html#">See all messages</a></li>
				</ul></li>
			<!-- inbox dropdown end -->
		</ul>
		<!--  notification end -->
	</div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="logout">Logout</a></li>
		</ul>
	</div>
	</header>


</body>
</html>



