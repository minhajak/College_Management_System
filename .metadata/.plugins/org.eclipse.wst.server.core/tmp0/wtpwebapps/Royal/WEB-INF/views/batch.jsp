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
	<h1>Batchs</h1>
	<div
		style="border: 2px solid; padding: 10px; margin-bottom: 10px; display: grid; grid-template-columns: repeat(2, auto);">
		<c:forEach var="batch" items="${batchs}">
			<div
				style="margin: 20px; border: 1px solid; padding: 10px; border-radius: 6px;">
				<h1>Batch Code : ${batch.getBatchCode()}</h1>
				<h1>year : ${batch.getYear()}</h1>
				<h1>location : ${batch.getLocation()}</h1>
				<h1>department : ${batch.getDepartment().getDname()}</h1>
			</div>
		</c:forEach>
	</div>
	
</body>
</html>