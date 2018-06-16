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
	<c:url value="../sys_school/students" var="studentsList" />
	<c:url value="../sys_school/exercises" var="exercisesList" />
	<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="profile.html"><img
					src="/sys_school/resources/login/images/hello.png"
					class="img-circle" width="60"></a>
			</p>
			<h5 class="centered">${tutor.username}</h5>

			<li class="mt"><a class="active" href="${dashboard}"> <i
					class="fa fa-dashboard"></i> <span>Panel główny</span>
			</a></li>

			<li class="sub-menu"><a href=""> <i class="fa fa-comments"></i>
					<span>Wiadomości</span>
			</a></li>

			<li class="sub-menu"><a href="${studentsList}"> <i
					class="fa fa-users"></i> <span>Uczniowie</span>
			</a></li>
			<li class="sub-menu"><a href="${exercisesList}"> <i class="fa fa-tasks"></i>
					<span>Zadania</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i class="fa fa-archive"></i>
					<span>Odpowiedzi do zadań</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i
					class="fa fa-bar-chart-o"></i> <span>Raporty</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i class=" fa fa-money"></i>
					<span>Finanse</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i class=" fa fa-cog"></i>
					<span>Ustawienia</span>
			</a></li>

		</ul>
		<!-- sidebar menu end-->
	</div>
	</aside>


</body>
</html>



