package com.mega_city_cab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mega_city_cab.model.User;
import com.mega_city_cab.service.UserService;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class SingUpServlet extends HttpServlet {
	
	 private UserService userService;

	    public SingUpServlet() {  // ✅ Correct constructor
	        userService = new UserService();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");

	        if (username == null || password == null || email == null || username.isEmpty() || password.isEmpty() || email.isEmpty()) {
	            response.sendRedirect("signup.jsp?error=1");
	            return;
	        }

	        User user = new User(username, password, email, "customer");
	        if (userService.signUp(user)) {
	            response.sendRedirect("login.jsp");
	        } else {
	            response.sendRedirect("signup.jsp?error=1");
	        }
	    }
	}
