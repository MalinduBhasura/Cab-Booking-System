package com.login;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Establish database connection
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            // Database connection failed
            response.sendRedirect("Login1.jsp?error=dbconnection");
            return;
        }

        String query = "SELECT role FROM Users WHERE username = ? AND password = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                System.out.println("Role: " + role);  // Debugging output

                // Check role and redirect accordingly
                if (role != null && role.equalsIgnoreCase("admin")) {
                    // Save user session info (optional)
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("role", role);
                    
                    // Redirect to Admin page
                    response.sendRedirect("Admin1.jsp");
                } else if (role != null && role.equalsIgnoreCase("customer")) {
                    // Save user session info (optional)
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("role", role);
                    
                    // Redirect to Customer page
                    response.sendRedirect("Coustomer1.jsp");
                } else {
                    // Role not found or invalid role
                    request.setAttribute("loginError", "Invalid role assigned.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login1.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                // Login failed due to incorrect username/password
                request.setAttribute("loginError", "Invalid username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login1.jsp");
                dispatcher.forward(request, response); // Forward to Login1.jsp for error message
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Database error occurred
            response.sendRedirect("Login1.jsp?error=database");
        }
    }
}
