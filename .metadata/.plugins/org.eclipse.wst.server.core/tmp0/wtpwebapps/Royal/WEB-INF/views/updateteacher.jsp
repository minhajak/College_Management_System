<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Teacher Profile</title>
<%@include file="./base.jsp"%>
<style>
.profile-card {
    max-width: 800px;
    background: #ffffff;
    border-radius: 15px;
    box-shadow: 0 8px 30px rgba(0,0,0,0.12);
    padding: 2rem;
    margin: 2rem auto;
}

.image-preview {
    width: 200px;
    height: 200px;
    border-radius: 50%;
    object-fit: cover;
    border: 3px solid #dee2e6;
    margin: 0 auto 1.5rem;
    display: block;
}

.form-group {
    margin-bottom: 1.5rem;
}

.form-group label {
    font-weight: 500;
    color: #495057;
}

.custom-file-label::after {
    content: "Browse";
}
</style>
</head>
<body>
    <div class="container">
        <div class="profile-card">
            <h2 class="text-center mb-4">Update Teacher Profile</h2>
            
            <form action="${pageContext.request.contextPath}/handleupdateteacher/${teacher.tid}" 
                  method="post" 
                  enctype="multipart/form-data">
                  
                <input type="hidden" name="tid" value="${teacher.tid}">

                <!-- Current Image Display & Upload -->
                <div class="form-group text-center">
                    <img id="imagePreview" class="image-preview"
                        src="${pageContext.request.contextPath}/teacher/${teacher.tid}"
                        alt="Current Image">
                        
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" 
                            id="imageUpload" name="imageUpload" 
                            accept="image/*" onchange="previewImage(event)">
                        <label class="custom-file-label" for="imageUpload">
                            Choose new profile image
                        </label>
                    </div>
                </div>

                <!-- Personal Information -->
                <div class="form-group">
                    <label for="name">Full Name</label>
                    <input type="text" class="form-control" 
                        id="name" name="name" 
                        value="${teacher.name}" required>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="gender">Gender</label>
                            <select class="form-control" id="gender" name="gender">
                                <option value="male" ${teacher.gender == 'male' ? 'selected' : ''}>male</option>
                                <option value="female" ${teacher.gender == 'female' ? 'selected' : ''}>female</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="age">Age</label>
                            <input type="number" class="form-control" 
                                id="age" name="age" 
                                value="${teacher.age}" required>
                        </div>
                    </div>
                </div>

                <!-- Contact Information -->
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="phone_no">Phone Number</label>
                            <input type="tel" class="form-control" 
                                id="phone_no" name="phone_no" 
                                value="${teacher.phone_no}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" 
                                id="email" name="email" 
                                value="${teacher.email}" required>
                        </div>
                    </div>
                </div>

                <!-- Department & Subject -->
               <%--  <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="department">Department</label>
                            <select class="form-control" id="department" name="department.did">
                                <c:forEach items="${departments}" var="dept">
                                    <option value="${dept.did}" 
                                        ${teacher.department.did == dept.did ? 'selected' : ''}>
                                        ${dept.dname}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div> --%>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="subject">Subject</label>
                            <select class="form-control" id="subject" name="subject.sid">
                                <c:forEach items="${teacher.getDepartment().getSubjects()}" var="subj">
                                    <option value="${subj.sid}" 
                                        ${teacher.subject.sid == subj.sid ? 'selected' : ''}>
                                        ${subj.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <!-- Form Actions -->
                <div class="form-group text-center mt-4">
                    <button type="submit" class="btn btn-primary btn-lg px-5">
                        <i class="fas fa-save mr-2"></i> Update Profile
                    </button>
                    <a href="${pageContext.request.contextPath}/getteacher/${teacher.getTid()}" 
                       class="btn btn-secondary btn-lg px-5 ml-3">
                        <i class="fas fa-times mr-2"></i>Cancel
                    </a>
                </div>
            </form>
        </div>
    </div>

    <script>
        function previewImage(event) {
            const preview = document.getElementById('imagePreview');
            const file = event.target.files[0];
            const reader = new FileReader();
            
            reader.onloadend = function() {
                preview.src = reader.result;
            }
            
            if (file) {
                reader.readAsDataURL(file);
            } else {
                preview.src = "${pageContext.request.contextPath}/teacher/${teacher.tid}";
            }
        }

        // Update custom file input label
        document.querySelector('.custom-file-input').addEventListener('change', function(e) {
            const fileName = e.target.files[0] ? e.target.files[0].name : "Choose file";
            this.nextElementSibling.textContent = fileName;
        });
    </script>
</body>
</html>