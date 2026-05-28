<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String)session.getAttribute("name");
	String email = (String)session.getAttribute("email");
%>

<h1>Welcome to <%= name %> : <%= email %> </h1>
<h1>Welcome to Tutorials</h1>
<h1>This is Java Tutorial</h1>
<%@include file = "links.jsp"%>