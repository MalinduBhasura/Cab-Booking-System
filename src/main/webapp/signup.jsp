<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/signupstyles.css">  <!-- Link to CSS -->
    
</head>
<body>
    <div class="signup-container">
        <h2>Create an Account</h2>
        <form action="signup" method="post">
            <input type="text" name="username" placeholder="Username" required autocomplete="off"><br>
            <input type="password" name="password" placeholder="Password" required autocomplete="new-password"><br>
            <input type="email" name="email" placeholder="Email" required><br>
            <input type="submit" value="Sign Up">
        </form>

        <!-- Display Success or Error Messages -->
        <% if (request.getAttribute("successMessage") != null) { %>
            <p class="success-message"><%= request.getAttribute("successMessage") %></p>
        <% } %>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
        <% } %>

        <p class="redirect-link">Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>

