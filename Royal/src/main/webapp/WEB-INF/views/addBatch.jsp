<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Batch</title>
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
</style>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Add Batch</div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/createBatch" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" name="BatchCode" placeholder="Enter batch code" required>
                        </div>
                        <div class="form-group">
                            <select class="form-control" name="year" required>
                                <option value="" disabled selected>Select year</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="location" placeholder="Enter location" required>
                        </div>
                        <div class="form-group">
                            <input type="text" name="department.did" value="${department.getDid()}" hidden="" >
                        </div>
                        <div class="row">
                          <div class="col-6">
                            <button type="submit" class="btn btn-primary btn-block">Submit</button>
                          </div>
                          <div class="col-6">
                            <a href="${pageContext.request.contextPath}/department/${department.getDname()}" class="btn btn-secondary btn-block">Go Back</a>
                          </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
