<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${department.dname}</title>
<%@include file="./base.jsp"%>
</head>
<body style="background-color: #f8f9fa;">

	<div class="container" style="margin-top: 50px;">
		<div style="text-align: right; margin-top: 20px;">
			<a href="javascript:history.back()" class="btn btn-secondary"
				style="max-width: 200px;">Go Back</a>
		</div>
		<h1 class="text-center"
			style="font-family: 'Segoe UI', sans-serif; font-weight: 700; color: #2c3e50; text-decoration: underline; margin-bottom: 40px;">
			${department.dname}</h1>
		<div class="mb-5 p-4"
			style="background-color: #ffffff; border: 1px solid #e0e0e0; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);">
			<h3 style="color: #2c3e50; margin-bottom: 15px;">Location</h3>
			<p style="font-size: 1.1rem; color: #555; margin: 0;">
				${department.getLocation()}</p>
		</div>


		<div class="mb-5">
			<h3 style="color: #2c3e50; margin-bottom: 20px;">Batches</h3>
			<div class="row">
				<c:if test="${not empty batches}">
					<c:forEach var="batch" items="${batches}">
						<div class="col-md-4" style="margin-bottom: 20px;"
							onclick="window.location.href='${pageContext.request.contextPath}/${department.getDname()}/batch/${batch.getBatchCode()}'">
							<div
								style="padding: 20px; background-color: #ffffff; border: 1px solid #e0e0e0; border-radius: 10px; box-shadow: 0 2px 6px rgba(0, 0, 0, 0.08); text-align: center;">
								<h5 style="margin-bottom: 5px; color: #2c3e50;">
									${batch.getBatchCode()}</h5>
								<p style="color: #777; margin: 0; font-size: 0.9rem;">
									${batch.year} Year</p>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<a
				href="${pageContext.request.contextPath}/department/${department.getDname()}/addBatch/"
				class="btn btn-outline-success mt-2" style="max-width: 200px;">Add
				new Batch</a>
		</div>


		<div class="mb-5">
			<h3 style="color: #2980b9; margin-bottom: 20px;">Teachers</h3>
			<div class="row">
				<c:forEach var="teacher" items="${teachers}">
					<div class="col-md-2" style="margin-bottom: 20px;">
						<div
							style="padding: 20px; background-color: #ffffff; border: 1px solid #e0e0e0; border-radius: 10px; box-shadow: 0 2px 6px rgba(0, 0, 0, 0.08); text-align: center; width: fit-content;"
							onclick="window.location.href='${pageContext.request.contextPath}/getteacher/${teacher.getTid()}'">
							<img alt="no image"
								src="${pageContext.request.contextPath}/teacher/${teacher.getTid()}"
								style="width: 100px; height: 100px; object-fit: cover; border: 2px solid #2980b9;">
							<p
								style="font-weight: bold; color: #2c3e50; margin: 15px 0 5px 0;">
								${teacher.getName()}</p>
							<p style="color: #777; font-size: 0.9rem; margin: 0;">
								Subject: ${teacher.subject.getName()}</p>
						</div>
					</div>
				</c:forEach>
			</div>
			<a
				href="${pageContext.request.contextPath}/department/${department.getDname()}/addteacher/"
				class="btn btn-outline-success mt-2" style="max-width: 200px;">Add
				new Teacher</a>
		</div>

	</div>

</body>
</html>
