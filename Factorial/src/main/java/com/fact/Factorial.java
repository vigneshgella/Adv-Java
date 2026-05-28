package com.fact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fact")
public class Factorial extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int number = Integer.parseInt(request.getParameter("number"));
		PrintWriter out = response.getWriter();
		out.print("<h1>In doGet()</h1>");
		if(number < 0) {
			out.print("<h1>Hello "+name+" please enter positive numbers only....</h1>");
		}else {
			int fact = getFactorial(number);
			out.print("<h1>Hello "+name+" Factorial is "+fact+"</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int number = Integer.parseInt(request.getParameter("number"));
		PrintWriter out = response.getWriter();
		out.print("<h1>In doPost()</h1>");
		if(number < 0) {
			out.print("<h1>Hello "+name+" please enter positive numbers only....</h1>");
		}else {
			int fact = getFactorial(number);
			out.print("<h1>Hello "+name+" Factorial is "+fact+"</h1>");
		}
	}
	public int getFactorial(int number) {
		if(number == 0 || number == 1 ) {
			return 1;
		}else {
			return number * getFactorial(number-1);
		}
	}
}
