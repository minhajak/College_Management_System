<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Mark</title>
<%@ include file="./base.jsp"%>
</head>
<body>
  <div class="container mt-5">
    <h1 class="mb-4 text-center mx-auto">Update Mark</h1>
    <div class="card mx-auto shadow-sm" style="max-width: 400px;">
      <div class="card-body">
        <form action="${pageContext.request.contextPath}/handlupdateemark" method="post">
          <input type="hidden" name="student.sid" value="${studId}">
          <input type="hidden" name="subject.sid" value="${subId}">
          <div class="form-group">
            <input type="number" class="form-control" id="markId" name="id" value="${marks.id}" hidden="">
          </div>
          <div class="form-group">
            <label for="markValue">New Mark</label>
            <input type="number" step="0.01" class="form-control" id="markValue" name="mark" value="${marks.mark}" required>
          </div>
          <div style="display: flex; justify-content: center;">
            <button type="submit" class="btn btn-primary mx-2">Submit</button>
            <a href="javascript:history.back()" class="btn btn-secondary">Go Back</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
