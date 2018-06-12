<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<c:url value="../sys_school/adduser" var="newUser" />
	<c:url value="../sys_school/invitestudent" var="newStudent" />
	<c:url value="../sys_school/createexercise" var="newExercise" />
	<c:url value="../sys_school/checksolutions" var="checkSolutions" />
	<div class="row mtbox">
		<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
			<a href="${newStudent}"><div class="box1">
					<span class="li_study"></span>
					<h3>Dodaj nowych uczniów</h3>
				</div></a>
			<p>Wyślij zaproszenie do swojej klasy.</p>
		</div>
		<div class="col-md-2 col-sm-2 box0">
			<a href="${newExercise}"><div class="box1">
					<span class="li_note"></span>
					<h3>Dodaj nowe zadanie</h3>
				</div></a>
			<p>Dodaj i przydziel nowe zadanie.</p>
		</div>
		<div class="col-md-2 col-sm-2 box0">
			<a href="${checkSolutions}"><div class="box1">
					<span class="li_pen"></span>
					<h3>Sprawdź odpowiedzi</h3>
				</div></a>
			<p>Zweryfikuj postępy swoich uczniów.</p>
		</div>
		<div class="col-md-2 col-sm-2 box0">
			<a href="${newExercise}"><div class="box1">
					<span class="li_calendar"></span>
					<h3>Ustal datę nowej lekcji</h3>
				</div></a>
			<p>Wyślij propozycję terminu następnej lekcji.</p>
		</div>
		<div class="col-md-2 col-sm-2 box0">
			<a href="${newExercise}"><div class="box1">
					<span class="li_settings"></span>
					<h3>Sprawdź ustawienia</h3>
				</div></a>
			<p>Przejdź do ustawień swojego konta.</p>
		</div>

	</div>


</body>
</html>



