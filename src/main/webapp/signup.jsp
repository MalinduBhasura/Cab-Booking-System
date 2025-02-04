<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h2>Sign Up</h2>
    <form action="signup" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        Email: <input type="email" name="email" required><br>
        <input type="submit" value="Sign Up">
    </form>
    <a href="login.jsp">Login</a>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Sign up failed!</p>
    <% } %>
</body>
</html>