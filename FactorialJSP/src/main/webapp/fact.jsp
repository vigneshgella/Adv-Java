<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info = "This JSP page is used to find factorial" errorPage="error.jsp"%>
<%
	String name = request.getParameter("name");
	int number = Integer.parseInt(request.getParameter("number"));
	if(number < 0){
		throw new ArithmeticException("Negitive numbers are not allowed.....");
	}
	int fact = getFactorial(number);
%>

<h1>Hello JCB <%= name %> Factorial is <%= fact %></h1>

<%!
	public int getFactorial(int number){
	if(number == 0 || number ==1){
		return 1;
	}else{
		return number * getFactorial(number - 1);
	}
}
%>


<h1><%= getServletInfo()%></h1>

