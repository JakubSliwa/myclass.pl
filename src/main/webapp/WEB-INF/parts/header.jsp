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
	<c:url value="/../sys_school/showmessage" var="showMessage" />
	<c:url value="/../sys_school/messages" var="messagesList" />
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
					<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">${unreaded}</span>
			</a>
				<ul class="dropdown-menu extended inbox">
					<div class="notify-arrow notify-arrow-green"></div>
					<li><c:set var="readed" value="NotReaded" /> <c:choose>
							<c:when test="${unreaded == 1}">
								<p class="green">Masz ${unreaded} nową wiadomość</p>
							</c:when>
							<c:otherwise>
								<p class="green">Masz ${unreaded} nowe wiadomości</p>
							</c:otherwise>
						</c:choose></li>
					<c:url value="/../sys_school/students" var="student" />
					<c:forEach items="${messagesLimited}" var="m">
						<li><a href="${showMessage}/${m.id}"> <span class="photo"><img
									alt="avatar"
									src="/sys_school/resources/tutorDashboard/img/ui-sam.jpg"></span>
								<span class="subject"> <span class="from">${m.sendByStudent.username}</span>
									<span class="time"> <br>${m.sent.format(dateTimeFormatter)}
								</span>
							</span> <span class="message"><br>${m.text}...</span>
						</a></li>
					</c:forEach>
					<li><a href="${messagesList}">Zobacz wszystkie</a></li>
				</ul></li>
			<!-- inbox dropdown end -->
		</ul>
		<!--  notification end -->
	</div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="${logout}">Wyloguj</a></li>
		</ul>
	</div>
	</header>


</body>
</html>



