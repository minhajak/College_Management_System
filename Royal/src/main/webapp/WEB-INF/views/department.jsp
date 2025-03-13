<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
<%@include file="./base.jsp"%>
<style>
body {
	background-color: #f8f9fa;
}

.dept-card {
	background: white;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s ease, box-shadow 0.3s ease;
	cursor: pointer;
	text-align: center;
	border: 1px solid #dee2e6;
}

.dept-card:hover {
	transform: translateY(-5px);
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
	background-color: #007bff;
	color: white;
}

.dept-card:active {
	transform: translateY(2px);
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1 class="text-center mt-5">Departments</h1>
	<div class="container mt-5">
		<div class="row">
			<c:forEach var="department" items="${departments}">
				<div class="col-md-4 mb-4">
					<div class="dept-card"
						onclick="window.location.href='${pageContext.request.contextPath}/department/${department.dname}'">
						<h5 class="card-text">${department.getDid()}-
							${department.dname}</h5>
					</div>
				</div>
			</c:forEach>
		</div>
		<a href="${pageContext.request.contextPath}/addDept/"
			class="btn btn-outline-success mt-5" style="max-width: 200px;">Add new
			Department</a>
	</div>
</body>
</html>
