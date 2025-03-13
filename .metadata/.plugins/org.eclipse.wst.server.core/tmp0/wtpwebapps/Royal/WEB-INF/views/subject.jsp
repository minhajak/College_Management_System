<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		style="border: 2px solid; padding: 10px; margin-bottom: 10px; display: grid; grid-template-columns: repeat(2, auto);">
		<c:forEach var="subject" items="${subjects}">
			<div
				style="margin: 20px; border: 1px solid; padding: 10px; border-radius: 6px;">
				<h1>Name : ${subject.getName()}</h1>
				<h1>name of teacher : ${subject.getTeacher().getName()}</h1>
				<h1>Department : ${subject.getDepartment().getDname()}</h1>
			</div>
		</c:forEach>
	</div>


</body>
</html>