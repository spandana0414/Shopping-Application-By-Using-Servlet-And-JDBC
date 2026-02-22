<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN LOGIN</title>
<link href="AL.css" rel="stylesheet">
</head>
<body>
	<!-- <div class="mainCon">
        <div class="head">
            <h1>ADMIN LOGIN</h1>
        </div>
        <div class="tail">
            <form action="adminLogin"  class="form">
                <table>
                    <tr>
                        <td>EMAIL:</td>
                        <td>
                            <input type="text" placeholder="Enter email" name="email" required>
                        </td>
                    </tr>
                    <tr>
                        <td>PASSWORD:</td>
                        <td>
                            <input type="password" placeholder="Enter password" name="password" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Login" class="sub">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div> -->
    <div class="mainCon">
        <div class="head">
            <h1>ADMIN LOGIN</h1>
        </div>
        <div class="tail">
            <form action="adminLogin"  class="form">
                <table>
                    <tr>
                        <td>EMAIL:</td>
                        <td>
                            <input type="text" placeholder="Enter email" name="email" required>
                        </td>
                    </tr>
                    <tr>
                        <td>PASSWORD:</td>
                        <td>
                            <input type="password" placeholder="Enter password" name="password" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="button-cell">
                            <input type="submit" value="Login" class="sub">
                            <a href="AdminRegistration.jsp" class="reg-btn">Register</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
</body>
</html>