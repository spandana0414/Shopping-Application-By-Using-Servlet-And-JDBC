<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN REGISTRATION</title>
<link href="AR.css" rel="Stylesheet">
</head>
<body>
	<div class="mainCon">
        <h1 class="head">Admin Registration</h1>
        <div class="formContainer">
            <form action="adminreg" method="POST" class="form">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="name" placeholder="Enter name" required>
                </div>

                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" name="email" placeholder="Enter email" required>
                </div>

                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" name="password" placeholder="Enter password" required>
                </div>

                <div class="form-group">
                    <label>Gender:</label>
                    <div class="gender-group">
                        <div class="gender-option">
                            <input type="radio" name="gender" value="Female" required>
                            <label>Female</label>
                        </div>
                        <div class="gender-option">
                            <input type="radio" name="gender" value="Male">
                            <label>Male</label>
                        </div>
                        <div class="gender-option">
                            <input type="radio" name="gender" value="Others">
                            <label>Others</label>
                        </div>
                    </div>
                </div>

                <div class="button-group">
                    <input type="submit" value="Register" class="sub">
                    <a href="AdminLogin.jsp" class="login-btn">Login</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
