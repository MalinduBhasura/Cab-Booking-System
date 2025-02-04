<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/loginstyles.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required autocomplete="off">
            <input type="password" name="password" placeholder="Password" required autocomplete="new-password">
            <div class="button-container">
            <input type="submit" value="Login">
            <input type="reset" value="Clear">
            </div>
        </form>
        <a href="signup.jsp">Sign Up</a>
        <% if (request.getParameter("error") != null) { %>
            <p class="error-message">Invalid username or password!</p>
        <% } %>
    </div>
</body>
</html>
