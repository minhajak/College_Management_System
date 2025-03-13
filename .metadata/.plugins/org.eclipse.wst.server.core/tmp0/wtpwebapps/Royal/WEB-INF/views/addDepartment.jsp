<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Department</title>
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
        box-shadow: 0 4px 20px rgba(0,0,0,0.2);
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
    .btn-custom {
        width: 48%;
    }
</style>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    Add Department
                </div>
                <div class="card-body">
                    <form action="createDept" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" name="dname" placeholder="Enter department name" required>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="location" placeholder="Enter department location" required>
                        </div>
                        <div class="d-flex justify-content-between">
                            <button type="submit" class="btn btn-primary btn-custom">Submit</button>
                            <a href="${pageContext.request.contextPath}/department" class="btn btn-secondary btn-custom">Go Back</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
