package com.rd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<h1> Invalid Credentials.......</h1>");
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("login.html");
//		rd.forward(request, response);
		rd.include(request, response);
//		response.sendRedirect("login.html");
		
	}

}
