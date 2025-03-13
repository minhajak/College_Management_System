<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./base.jsp"%>
</head>
<body>
	<div class="container">
		<div style="text-align: right; margin-top: 20px;">
			<a href="javascript:history.back()" class="btn btn-secondary" style="max-width: 200px;">Go Back</a>
		</div>
		<h1 class="text-center mt-5">Batch Details</h1>
		<div class="card mt-4">
			<div class="card-body">
				<h3>Batch Code : ${batch.getBatchCode()}</h3>
				<h3>Year : ${batch.getYear()}</h3>
				<h3>Department : ${batch.getDepartment().getDname()}</h3>
			</div>
		</div>
		<h2 class="mt-5 mb-4">Subjects</h2>
		<div class="mb-5">
			<div class="row">
				<c:forEach var="subject" items="${batch.getSubjects()}">
					<div class="col-md-1" style="margin-bottom: 20px;" onclick="window.location.href='${pageContext.request.contextPath}/subject/${subject.getSid()}'">
						<div style="padding: 10px; background-color: #ffffff; border: 1px solid #e0e0e0; border-radius: 10px; box-shadow: 0 2px 6px rgba(0, 0, 0, 0.08); text-align: center; width: fit-content; height: fit-content;">
							<p style="font-weight: bold; color: #2c3e50; margin: 5px 0;">${subject.name}</p>
						</div>
					</div>
				</c:forEach>
			</div>
			<a href="${pageContext.request.contextPath}/batch/${batch.bid}/addsubject/" class="btn btn-outline-success mt-2" style="max-width: 200px;">Add new Subject</a>
		</div>
		<h2 class="mt-5">Students</h2>
		<div class="mb-5">
			<div class="row">
				<c:forEach var="student" items="${students}">
					<div class="col-md-2" style="margin-bottom: 20px;" onclick="window.location.href='${pageContext.request.contextPath}/getstudent/${student.getSid()}'">
						<div style="padding: 20px; background-color: #ffffff; border: 1px solid #e0e0e0; border-radius: 10px; box-shadow: 0 2px 6px rgba(0, 0, 0, 0.08); text-align: center; width: fit-content;">
							<img alt="no image" src="${pageContext.request.contextPath}/student/${student.getSid()}" style="width: 100px; height: 100px; object-fit: cover; border: 2px solid #2980b9;">
							<p style="font-weight: bold; color: #2c3e50; margin: 15px 0 5px 0;">${student.name}</p>
						</div>
					</div>
				</c:forEach>
			</div>
			<a href="${pageContext.request.contextPath}/batch/${batch.bid}/addstudent/" class="btn btn-outline-success mt-2" style="max-width: 200px;">Add new Student</a>
		</div>
	</div>
</body>
</html>
