<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Royal College Management System</title>
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">Welcome to College Management System</h1>
		<h2 style="text-align: center; color: hsl(188, 1%, 20%);">${college.getName()}</h2>
		<h2 class="text-center">
			Official Website: <a class="text-decoration-none"
				href="${college.getWebsite()}" target="_blank">
				${college.getWebsite()} </a>
		</h2>

		<div class="container-fluid mt-5">
			<div style="max-width: 300px; margin: 0; padding-left: 0;">
				<div class="card shadow-sm" style="border-radius: 10px;">
					<div class="card-body"
						style="background-color: #f8f9fa; padding: 20px; border-radius: 10px;">
						<h2 class="card-title text-primary"
							style="border-bottom: 2px solid #007bff; padding-bottom: 10px;">
							Address</h2>
						<div class="mt-3">
							<p>
								<strong>Street:</strong> ${college.getAddress().getStreet()}
							</p>
							<p>
								<strong>District:</strong> ${college.getAddress().getDistrict()}
							</p>
							<p>
								<strong>State:</strong> ${college.getAddress().getState()}
							</p>
							<p>
								<strong>Pin Code:</strong> ${college.getAddress().getPin()}
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>
</body>
</html>
