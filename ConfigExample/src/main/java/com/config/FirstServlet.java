package com.config;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		String t = config.getInitParameter("trophies");
		String r = config.getInitParameter("records");
		out.print("<h1>This is RCB Team</h1>");
		out.print("<h1>Number of trophies "+t+"</h1>");
		out.print("<h1>All time record "+r+"</h1>");
	}

}
