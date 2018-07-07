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
	<c:url value="/../sys_school/students" var="studentsList" />
	<c:url value="/../sys_school/exercises" var="exercisesList" />
	<c:url value="/../sys_school/checksolutions" var="solutionsList" />
	<c:url value="/../sys_school/tutorsettings" var="tutorSettings" />
	<c:url value="/../sys_school/messages" var="messages" />
	<c:url value="../sys_school/raports" var="raports" />
	<c:url value="../sys_school/finances" var="finances" />
	<c:url value="../sys_school/calendar" var="calendar" />
	<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="${tutorSettings}"><img
					src="/sys_school/resources/login/images/hello.png"
					class="img-circle" width="60"></a>
			</p>
			<h5 class="centered">${tutor.username}</h5>

			<li class="mt"><a class="active" href="${dashboard}"> <i
					class="fa fa-dashboard"></i> <span>Panel główny</span>
			</a></li>

			<li class="sub-menu"><a href="${messages}"> <i
					class="fa fa-comments"></i> <span>Otrzymane wiadomości</span>
			</a></li>

			<li class="sub-menu"><a href="${studentsList}"> <i
					class="fa fa-users"></i> <span>Uczniowie</span>
			</a></li>
			<li class="sub-menu"><a href="${exercisesList}"> <i
					class="fa fa-tasks"></i> <span>Zadania</span>
			</a></li>
			<li class="sub-menu"><a href="${solutionsList}"> <i
					class="fa fa-archive"></i> <span>Odpowiedzi do zadań</span>
			</a></li>
			<li class="sub-menu"><a href="${raports}"> <i
					class="fa fa-bar-chart-o"></i> <span>Raporty</span>
			</a></li>
			<li class="sub-menu"><a href="${calendar}"> <i
					class="fa fa-calendar"></i> <span>Kalendarz</span>
			</a></li>
			<li class="sub-menu"><a href="${finances}"> <i
					class=" fa fa-money"></i> <span>Finanse</span>
			</a></li>
			<li class="sub-menu"><a href="${tutorSettings}"> <i
					class=" fa fa-cog"></i> <span>Ustawienia</span>
			</a></li>

		</ul>
		<!-- sidebar menu end-->
	</div>
	</aside>


</body>
</html>



