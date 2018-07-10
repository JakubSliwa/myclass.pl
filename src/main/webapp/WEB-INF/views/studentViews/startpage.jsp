<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona w trakcie budowy</title>
</head>
<body>
	Witaj ${student.username }
	<br>
	<table>
		<h4>Otrzymane wiadomości</h4>
		<thead>
			<tr>
				<th>Od</th>
				<th>Treść</th>
				<th>Kiedy</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${messagesToView}" var="messagesToView">
				<tr>
					<td>${messagesToView.sendByTutor.username}</td>
					<td>${messagesToView.text}</td>
					<td>${messagesToView.sent.format(dateTimeFormatter)}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<h4>Przydzielone zadania</h4>
		<thead>
			<tr>
				<th>Tytuł</th>
				<th>Opis zadania</th>
				<th>Deadline</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${basicExercises}" var="basicExercises">
				<tr>
					<td>${basicExercises.title}</td>
					<td>${basicExercises.description}</td>
					<td>${basicExercises.deadline}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>