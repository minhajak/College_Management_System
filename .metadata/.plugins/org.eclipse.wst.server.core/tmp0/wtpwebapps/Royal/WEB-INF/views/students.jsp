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
		<c:forEach var="std" items="${students}">
			<div
				style="margin: 20px; border: 1px solid; padding: 10px; border-radius: 6px;">
				<img alt="no image"
					src="${pageContext.request.contextPath}/student/${std.getSid()}">
				<h1> name : ${std.name}</h1>
				<h1> age : ${std.age}</h1>
				<h1> gender : ${std.gender}</h1>
				<h1> department : ${std.getBatch().getDepartment().getDname()}</h1>
				<h1> batch : ${std.getBatch().getBatchCode()}</h1>
			</div>
		</c:forEach>
	</div>

</body>
</html>