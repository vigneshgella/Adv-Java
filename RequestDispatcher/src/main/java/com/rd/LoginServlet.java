package com.rd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		if(email.equals("admin@rcb.com") && password.equals("pandey@49")) {
//			response.sendRedirect("home");
			out.print("<h1>Validation Success</h1>");
			rd = request.getRequestDispatcher("home");
//			rd.forward(request, response);
			rd.include(request, response);
		}else {
//			response.sendRedirect("error");
			out.print("<h1>Validation Failed</h1>");
			rd = request.getRequestDispatcher("error");
//			rd.forward(request, response);
			rd.include(request, response);
			
		}
	}

}
