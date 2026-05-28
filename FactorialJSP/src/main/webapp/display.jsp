<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	response.setIntHeader("refresh", 1);
    %>

    <h1> <%= new Date() %> </h1>