<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./base.jsp"%>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
	background-color: #f7f7f7;
}

.form-container {
	max-width: 400px;
	margin: 0 auto;
	padding: 25px;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

input[type="text"], select {
	width: 100%;
	padding: 8px 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.button-group {
	display: flex;
	justify-content: space-between;
	gap: 10px;
}

.button-group button, .button-group a {
	flex: 1;
	padding: 10px;
	text-align: center;
	border-radius: 4px;
	font-size: 16px;
	text-decoration: none;
	color: #fff;
	border: none;
	cursor: pointer;
}

.button-group button {
	background-color: #007bff;
}

.button-group button:hover {
	background-color: #0056b3;
}

.button-group a {
	background-color: #6c757d;
}

.button-group a:hover {
	background-color: #5a6268;
}
</style>
</head>
<body>
	<div class="form-container">
		<form action="handlesubject" method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text" id="name"
					name="name" required>
			</div>
			<div class="form-group">
				<input type="text" id="name" name="department.did"
					value="${batch.getDepartment().getDid()}" hidden="" required>
			</div>
			<div class="form-group">
				<input type="text" id="batchId" name="batchId"
					value="${batch.getBid()}" hidden="" required>
			</div>
			<div class="button-group">
				<button type="submit">Submit</button>
				<a
					href="${pageContext.request.contextPath}/${batch.department.dname}/batch/${batch.getBatchCode()}"
					class="btn btn-secondary ml-2">Go Back</a>
			</div>
		</form>
	</div>
</body>
</html>
