<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Subject Details</title>
<%@ include file="./base.jsp"%>
</head>
<body>
	<div class="container">
		<div class="card mt-5 p-4">
			<h2 class="text-center">Subject Name: ${subject.name}</h2>
			<h3 class="text-center">Teacher Name: ${subject.getTeacher().name}</h3>
		</div>
		<div class="card mt-4 mx-auto" style="max-width: 550px; min-width: 350px;">
			<div class="card-header text-center">
				<h4>Students</h4>
			</div>
			<div class="card-body">
				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th>Name</th>
							<th>Mark</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="mark" items="${marks}">
							<tr>
								<td>${mark.getStudent().getName()}</td>
								<td>${mark.mark}</td>
								<td>
									<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/updateMarks/${mark.getStudent().getSid()}/${mark.getSubject().getSid()}/${mark.getId()}">Update</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="d-flex justify-content-center">
					<a href="${pageContext.request.contextPath}/addmarks/${subject.sid}" class="btn btn-outline-success mx-2">Add student mark</a>
					<a href="javascript:history.back()" class="btn btn-secondary">Go Back</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
