<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Teacher Registration</title>
<%@include file="./base.jsp"%>
<style>
body {
	background-color: #f7f7f7;
	min-height: 100vh;
}

.card {
	border: none;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}

.card-header {
	background: #007bff;
	color: #fff;
	font-size: 1.5rem;
	text-align: center;
	padding: 1rem;
}

.card-body {
	padding: 2rem;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">Teacher Registration</div>
					<div class="card-body">
						<form action="${pageContext.request.contextPath}/handlestudent" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="name">Name:</label> <input type="text" id="name"
									name="name" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="gender">Gender:</label> <input type="text"
									id="gender" name="gender" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="phone_no">Phone Number:</label> <input type="number"
									id="phone_no" name="phone_no" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="age">Age:</label> <input type="number" id="age"
									name="age" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="email">Email:</label> <input type="email" id="email"
									name="email" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="profile">Profile Image:</label> <input type="file"
									id="profile" name="profile" class="form-control-file"
									accept="image/*">
							</div>
							<div class="form-group">
								<input type="text"  name="batchId"
									class="form-control" value="${batch.bid}" hidden="" >
							</div>
							<div class="form-group text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
								<a href="${pageContext.request.contextPath}/${batch.department.dname}/batch/${batch.getBatchCode()}"
									class="btn btn-secondary ml-2">Go Back</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
