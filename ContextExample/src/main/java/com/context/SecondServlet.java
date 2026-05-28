package com.context;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		String d = context.getInitParameter("driver");
		String u = context.getInitParameter("url");
		out.print("<h1>This is Second Servlet Team</h1>");
		out.print("<h1>Driver is "+d+"</h1>");
		out.print("<h1>Url is "+u+"</h1>");
	}
}
