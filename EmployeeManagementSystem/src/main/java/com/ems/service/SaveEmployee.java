package com.ems.service;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
@WebServlet("/save")
public class SaveEmployee extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee obj=new Employee();
		obj.setName(request.getParameter("name"));
		obj.setEmail(request.getParameter("email"));
		obj.setPassword(request.getParameter("password"));
		obj.setAge(Integer.parseInt(request.getParameter("age")));
		obj.setGender(request.getParameter("gender"));
		obj.setMobile(request.getParameter("mobile"));
		obj.setDepartment(request.getParameter("department"));
		obj.setAddress(request.getParameter("address"));
		
		EmployeeDAO dao = new EmployeeDAO();
		
		boolean status = dao.saveEmployee(obj);
		
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		if(status) {
			dao.commit();
			request.setAttribute("status", "Registered Successfully..........");
			rd.forward(request, response);
		}else {
			dao.rollback();
			request.setAttribute("status", "Error in registering employee.........");
			rd.forward(request, response);
		}
	}

}