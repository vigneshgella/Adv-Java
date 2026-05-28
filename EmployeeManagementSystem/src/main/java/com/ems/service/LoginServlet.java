package com.ems.service;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.dao.EmployeeDAO;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		EmployeeDAO dao = new EmployeeDAO();
		
		if(email.equals("admin@gmail.com") && password.equals("admin@49")) {
			session.setAttribute("email", email);
			response.sendRedirect("admin.jsp");
		}else {
			boolean status = dao.checkLogin(email,password);
			if(status) {
				session.setAttribute("email", email);
				response.sendRedirect("employee.jsp");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("status", "Invalid credentials");
				rd.forward(request, response);
			}
		}
	}

}
