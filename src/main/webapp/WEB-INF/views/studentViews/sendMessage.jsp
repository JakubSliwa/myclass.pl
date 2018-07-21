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
		<h4>Napisz do nauczyciela</h4>
		<form:form method="post" modelAttribute="message">
			<div>
				<label>Treść wiadomości</label>
				<div class="col-sm-10">
					<form:input path="text" class="form-control"
						placeholder="Wpisz treść wiadomości" type="text" />
					<form:errors path="text" />
				</div>
			</div>
			<input type="hidden" name="sendToTutor.id" value="${tutorToView.id}">
			<input type="hidden" name="sendByStudent.id" value="${student.id}">
			<input class="btn btn-primary" type="submit" value="Wyślij wiadomość">
		</form:form>
	</div>
</body>
</html>