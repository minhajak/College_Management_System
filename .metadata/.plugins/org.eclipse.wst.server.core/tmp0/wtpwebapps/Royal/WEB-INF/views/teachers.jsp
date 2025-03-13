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
	<h1>Teachers</h1>
	<div
		style="border: 2px solid; padding: 10px; margin-bottom: 10px; display: grid; grid-template-columns: repeat(2, auto);">
		<c:forEach var="teacher" items="${teachers}">
			<div
				style="margin: 20px; border: 1px solid; padding: 10px; border-radius: 6px;">
				<h1>Name : ${teacher.getName()}</h1>
				<h1>age : ${teacher.getAge()}</h1>
				<h1>gender : ${teacher.getGender()}</h1>
				<h1>email : ${teacher.getEmail()}</h1>
				<h1>phone number : ${teacher.getPhone_no()}</h1>
				<h1>department : ${teacher.getDepartment().dname}</h1>
				<h1>Subject : ${teacher.getSubject().getName()}</h1>
				<img alt="no image"
					src="${pageContext.request.contextPath}/teacher/${teacher.getTid()}" />
			</div>
		</c:forEach>
	</div>

</body>
</html>