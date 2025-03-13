<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Profile</title>
<%@include file="./base.jsp"%>
<style>
.profile-card {
    max-width: 800px;
    background: #ffffff;
    border-radius: 15px;
    box-shadow: 0 8px 30px rgba(0,0,0,0.12);
    overflow: hidden;
}

.profile-header {
    background: linear-gradient(135deg, #6366f1, #8b5cf6);
    padding: 2rem;
    text-align: center;
    color: white;
}

.profile-image {
    width: 200px;
    height: 200px;
    border-radius: 5%;
    border: 4px solid white;
    margin: 0 auto 1.5rem;
    object-fit: cover;
    box-shadow: 0 4px 12px rgba(0,0,0,0.15);
}

.detail-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 1.5rem;
    padding: 2rem;
}

.detail-item {
    background: #f8f9fa;
    border-radius: 10px;
    padding: 1.25rem;
    transition: transform 0.2s ease;
}

.detail-item:hover {
    transform: translateY(-3px);
}

.detail-label {
    font-size: 0.9rem;
    color: #6c757d;
    margin-bottom: 0.5rem;
    font-weight: 500;
}

.detail-value {
    font-size: 1.1rem;
    color: #212529;
    font-weight: 600;
    margin: 0;
}

.action-buttons {
    padding: 1.5rem;
    border-top: 1px solid #e9ecef;
    text-align: center;
}

.no-image {
    background: #e0e7ff;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 1rem;
    color: #4f46e5;
}
</style>
</head>
<body>
    <div class="container my-5">
          <h2 class="mb-3 text-center">Student Profile</h2>
        <div class="profile-card mx-auto">
            <div class="profile-header">
                <div class="profile-image-container">
                    <c:choose>
                        <c:when test="${not empty student.image}">
                            <img src="${pageContext.request.contextPath}/student/${student.getSid()}"
                                alt="Profile Image" class="profile-image">
                        </c:when>
                        <c:otherwise>
                            <div class="profile-image no-image">
                                <span>No Photo</span>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <h3 class="mb-0">${student.name}</h3>
                <p class="mb-0">${student.getBatch().getDepartment().dname}</p>
            </div>

            <div class="detail-grid">
                <div class="detail-item">
                    <div class="detail-label">Gender</div>
                    <div class="detail-value">${student.gender}</div>
                </div>
                
                <div class="detail-item">
                    <div class="detail-label">Age</div>
                    <div class="detail-value">${student.age}</div>
                </div>
                
                <div class="detail-item">
                    <div class="detail-label">Contact</div>
                    <div class="detail-value">${student.phone_no}</div>
                </div>
                
                <div class="detail-item">
                    <div class="detail-label">Email</div>
                    <div class="detail-value">${student.email}</div>
                </div>
                
                <div class="detail-item">
                    <div class="detail-label">Department</div>
                    <div class="detail-value">${student.batch.department.dname}</div>
                </div>
                <div class="detail-item">
                    <div class="detail-label">Batch</div>
                    <div class="detail-value">${student.batch.getBatchCode()}</div>
                </div>
            </div>

            <div class="action-buttons">
                <a href="${pageContext.request.contextPath}/${student.getBatch().getDepartment().getDname()}/batch/${student.getBatch().getBatchCode()}"
                    class="btn btn-outline-secondary px-4 mr-3">
                    <i class="fas fa-arrow-left mr-2"></i>Back
                </a>
                <a href="${pageContext.request.contextPath}/updatestudent/${student.sid}"
                    class="btn btn-primary px-4">
                    <i class="fas fa-edit mr-2"></i>Edit Profile
                </a>
            </div>
        </div>
    </div>
</body>
</html>