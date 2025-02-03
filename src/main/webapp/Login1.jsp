<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="POST" action="LoginServlet">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>

    <% 
        String loginError = (String) request.getAttribute("loginError");
        if (loginError != null) {
    %>
        <p style="color: red;">Error: <%= loginError %></p>
    <% } %>
</body>
</html>