<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	session.setAttribute("name", name);
	session.setAttribute("email", email);
%>

<h1>Welcome to <%= name %> : <%= email %> </h1>
<h1>Welcome to Tutorials</h1>

<%@include file = "links.jsp"%>