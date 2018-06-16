<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h3>UCZNIOWIE</h3>
	<c:forEach items="${students}" var="students">
		<div class="desc">
			<div class="thumb">
				<img class="img-circle"
					src="/sys_school/resources/tutorDashboard/img/ui-sam.jpg"
					width="35px" height="35px" align="">
			</div>
			<div class="details">
				<p>
					<a href="#">${students.username }</a><br />
					<muted>${students.status }</muted>
				</p>
			</div>
		</div>
	</c:forEach>


</body>
</html>



