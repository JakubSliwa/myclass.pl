<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h3>POWIADOMIENIA</h3>
	<c:url value="/../sys_school/students" var="student" />
	<c:url value="/../sys_school/addgrade" var="addGrade" />
	<c:set var="count" value="1" />
	<c:forEach items="${solutions}" var="solutions">
		<c:if test="${count <= 5 }">
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>${solutions.added}</muted>
						<br /> <a href="${addGrade}/${solutions.id}">${solutions.basicExercise.student.username}</a>
						dodał rozwiązanie do zadania: ${solutions.basicExercise.title}<br />
					</p>
				</div>
			</div>
			<c:set var="count" value="${count + 1}" />
		</c:if>
	</c:forEach>

</body>
</html>




