<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona w trakcie budowy</title>
</head>
<body>
	<c:url value="/../sys_school/student/logout" var="logout" />
	<c:url value="/../sys_school/student/addsolution" var="addSolution" />
	<c:url value="/../sys_school/student/sendmessage" var="sendMessage" />
	Witaj ${student.username }.
	<a href="${logout}">Logout</a>
	<br>
	<div>
		<h4>Dodaj odpowiedź do zadania ${basicExerciseToView.id}</h4>
		<h3>${basicExerciseToView.description}</h3>
		<form:form method="post" modelAttribute="basicSolution">
			<div>
				<label>Wpisz odpowiedź</label>
				<div class="col-sm-10">
					<form:input path="answer" class="form-control"
						placeholder="Wpisz odpowiedź" type="text" />
					<form:errors path="answer" />
				</div>
			</div>
			<input type="hidden" name="basicExercise.id"
				value="${basicExerciseToView.id}">
			<input type="hidden" name="student.id" value="${student.id}">
			<input class="btn btn-primary" type="submit" value="Wyślij wiadomość">
		</form:form>
	</div>
</body>
</html>