<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add College</title>
    <%@include file="./base.jsp"%>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 10px; }
        label { display: inline-block; width: 150px; }
        input { padding: 5px; }
    </style>
</head>
<body>
    <h2>Add College</h2>
    <form action="handlecollege" method="post">
        <div class="form-group">
            <label for="collegeName">College Name:</label>
            <input type="text" id="collegeName" name="name" placeholder="Enter name of college">
        </div>
        <div class="form-group">
            <label for="collegeWebsite">Website:</label>
            <input type="text" id="collegeWebsite" name="website" placeholder="Enter website">
        </div>
        <fieldset>
            <legend>Address</legend>
            <div class="form-group">
                <label for="addressState">State:</label>
                <input type="text" id="addressState" name="address.state" placeholder="Enter state">
            </div>
            <div class="form-group">
                <label for="addressDistrict">District:</label>
                <input type="text" id="addressDistrict" name="address.district" placeholder="Enter district">
            </div>
            <div class="form-group">
                <label for="addressStreet">Street:</label>
                <input type="text" id="addressStreet" name="address.street" placeholder="Enter street">
            </div>
            <div class="form-group">
                <label for="addressPin">Pin:</label>
                <input type="text" id="addressPin" name="address.pin" placeholder="Enter pin">
            </div>
        </fieldset>
        <div class="form-group">
            <button type="submit">Submit</button>
        </div>
    </form>
</body>
</html>
