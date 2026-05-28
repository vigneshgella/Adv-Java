package com.session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/spring")
public class SpringServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie ck[]	= request.getCookies();
		String name = ck[0].getValue();
		String email =ck[1].getValue();
		
		String message = "<h1> Hello "+name+":"+email+"</h1>";
		message = message + "<h1>Welcome to Tutorials</h1>";
		message = message + "<h1>Welcome to Spring tutorial</h1>";
		message = message + "<h1><a href = 'oops'>Java</a></h1>";
		message = message + "<h1><a href = 'python'>Python</a></h1>";
		message = message + "<h1><a href = 'spring'>Spring</a></h1>";
		
		PrintWriter out = response.getWriter();
		out.print(message);
	
	}

}
