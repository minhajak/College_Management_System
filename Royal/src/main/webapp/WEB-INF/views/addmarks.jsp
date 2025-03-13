<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Marks</title>
<%@ include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">Update Mark</h1>
		<div class="card mt-5 mx-auto" style="max-width: 400px;">
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/handleaddmarks"
					method="post">
					<input type="hidden" name="subId" value="${subject.sid}" />
					<div class="form-group">
						<label for="markInput">Mark</label> <input type="number"
							name="mark" id="markInput" class="form-control">
					</div>
					<div class="form-group">
						<label for="studentSelect">Select Student</label> <select
							name="studId" id="studentSelect" class="form-control">
							<c:forEach var="student" items="${subject.batch.students}">
								<c:set var="markAdded" value="false" />
								<c:forEach var="mark" items="${subject.subjectMarks}">
									<c:if test="${mark.student.sid == student.sid}">
										<c:set var="markAdded" value="true" />
									</c:if>
								</c:forEach>
								<c:if test="${markAdded == false}">
									<option value="${student.sid}">${student.name}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div style="display: flex; justify-content: center;">
						<button type="submit" class="btn btn-primary mx-2">Submit</button>
						<a href="javascript:history.back()" class="btn btn-secondary">Go
							Back</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
