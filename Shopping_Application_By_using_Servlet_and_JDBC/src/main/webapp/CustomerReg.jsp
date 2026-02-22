<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
<link href="CR.css" rel="Stylesheet">
</head>
<body>

	<!-- <div class="mainCon">
        <div class="Con">
            <h1 class="head">Customer Registration</h1>
        </div>
        <div class="formContainer">
            <form action="CustReg" method="get" class="form">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input placeholder="Enter your name" type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>MobileNumber:</td>
                        <td><input placeholder="Enter your MobileNumber" type="number" name="mobile"></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input placeholder="Enter your emailId" type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input placeholder="Enter your password" type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" class="sub" value="Register"></td>
                    </tr>
                </table>
            </form>
        </div>
        <a href="login">Already have? Login</a>
    </div> -->
    
    <div class="mainCon">
        <div class="Con">
            <h1 class="head">Customer Registration</h1>
        </div>
        <div class="formContainer">
            <form action="CustReg" method="get" class="form">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input placeholder="Enter your name" type="text" name="name" required></td>
                    </tr>
                    <tr>
                        <td>Mobile:</td>
                        <td><input placeholder="Enter your MobileNumber" type="number" name="mobile" required></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input placeholder="Enter your emailId" type="email" name="email" required></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input placeholder="Enter your password" type="password" name="password" required></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" class="sub" value="Register"></td>
                    </tr>
                </table>
            </form>
        </div>
        <a href="login">Already have an account? Login</a>
    </div>
</body>
</html>