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

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Cookie ck1 = new Cookie("name", name);
		Cookie ck2 = new Cookie("email", email);
		
		response.addCookie(ck1);
		response.addCookie(ck2);
		
		String message = "<h1> Hello "+name+":"+email+"</h1>";
		message = message + "<h1>Welcome to Tutorials</h1>";
		message = message + "<h1><a href = 'oops'>Java</a></h1>";
		message = message + "<h1><a href = 'python'>Python</a></h1>";
		message = message + "<h1><a href = 'spring'>Spring</a></h1>";
		
		PrintWriter out = response.getWriter();
		out.print(message);
	
	}

}
