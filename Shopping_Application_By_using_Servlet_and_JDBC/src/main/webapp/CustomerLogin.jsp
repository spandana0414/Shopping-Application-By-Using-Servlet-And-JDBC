<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER LOGIN</title>
<link href="CL.css" rel="stylesheet">
</head>
<body>
 <div class="mainCon">
        <h1 class="head">Customer Login</h1>
        <div class="formContainer">
            <form action="CustLog" class="form">
                <div class="form-group">
                    <label>Email:</label>
                    <input type="text" name="email" placeholder="Enter email">
                </div>

                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" name="password" placeholder="Enter password">
                </div>

                <div class="form-group">
                    <input type="submit" value="Login" class="sub">
                </div>
            </form>
        </div>
        <div class="login-link">
            <a href="CustomerReg.jsp">Don't have an account? Register</a>
        </div>
    </div>
</body>
</html>