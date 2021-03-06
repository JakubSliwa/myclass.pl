<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h3>UCZNIOWIE</h3>
	<c:url value="/../sys_school/students" var="student" />
	<c:forEach items="${students}" var="students">
		<div class="desc">
			<div class="thumb">
				<a href="${student}/${students.id}"><img class="img-circle"
					src="/sys_school/resources/tutorDashboard/img/ui-sam.jpg"
					width="35px" height="35px"></a>
			</div>
			<div class="details">
				<p>
					<a href="${student}/${students.id}">${students.username }</a><br />
					<muted> <c:choose>
						<c:when test="${students.status == 'offline'}">
							<span class="label label-danger">${students.status}</span>
						</c:when>
						<c:otherwise>
							<span class="label label-success">${students.status}</span>
						</c:otherwise>
					</c:choose></muted>
				</p>
			</div>
		</div>
	</c:forEach>


</body>
</html>



