package com.mega_city_cab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mega_city_cab.model.User;
import com.mega_city_cab.service.UserService;

@SuppressWarnings("serial")


@WebServlet("/login")
	public class LoginServlet extends HttpServlet {
		private UserService userService;

	    public LoginServlet() {  // ✅ Correct constructor
	        userService = new UserService();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
	            response.sendRedirect("login.jsp?error=1");
	            return;
	        }

	        User user = userService.login(username, password);
	        if (user != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("user", user);

	            if (user.getRole().equals("admin")) {
	                response.sendRedirect("admindashboard.jsp");
	            } else {
	                response.sendRedirect("customerdashboard.jsp");
	            }
	        } else {
	            response.sendRedirect("login.jsp?error=1");
	        }
	    }
	}
