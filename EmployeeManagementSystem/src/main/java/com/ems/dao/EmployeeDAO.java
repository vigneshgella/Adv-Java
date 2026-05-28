package com.ems.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;
public class EmployeeDAO {
	Connection connection = null;
	public boolean saveEmployee(Employee obj) {
		connection = ConnectionManager.getConnection();
		String query = "insert into employee(name,email,password,age,gender,mobile,department,address) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, obj.getName());
			statement.setString(2, obj.getEmail());
			statement.setString(3, obj.getPassword());
			statement.setInt(4, obj.getAge());
			statement.setString(5, obj.getGender());
			statement.setString(6, obj.getMobile());
			statement.setString(7, obj.getDepartment());
			statement.setString(8, obj.getAddress());
			
			int count = statement.executeUpdate();
			if(count == 0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void commit() {
		try {
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void rollback() {
		try {
			connection.rollback();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean checkLogin(String email, String password) {
		Connection connection = ConnectionManager.getConnection();
		String query = "select count(*) from employee where email = ? and password = ?";
		System.out.println(email);
		System.out.println(password);
		int count = 0;
		try {
			connection.setAutoCommit(true);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet set = ps.executeQuery();
			if(set.next()) {
				count = set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count == 1) {
			return true;
		}else {
			return false;
		}
	}
	public List<Employee> getAllData() {
		Connection connection = ConnectionManager.getConnection();
		List<Employee> empList = new ArrayList<Employee>();
		String query = "select * from employee";
		try {
			connection.setAutoCommit(true);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				Employee obj = new Employee();
				obj.setId(set.getInt(1));
				obj.setName(set.getString(2));
				obj.setEmail(set.getString(3));
				obj.setAge(set.getInt(5));
				obj.setGender(set.getString(6));
				obj.setMobile(set.getString(7));
				obj.setDepartment(set.getString(8));
				obj.setAddress(set.getString(9));
				empList.add(obj);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}
	public Employee searchEmployee(String email) {
		Connection connection = ConnectionManager.getConnection();
		Employee obj = new Employee();
		String query = "select * from employee where email = ?";
		try {
			connection.setAutoCommit(true);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet set = ps.executeQuery();
			if(set.next()) {
				obj.setId(set.getInt(1));
				obj.setName(set.getString(2));
				obj.setEmail(set.getString(3));
				obj.setAge(set.getInt(5));
				obj.setGender(set.getString(6));
				obj.setMobile(set.getString(7));
				obj.setDepartment(set.getString(8));
				obj.setAddress(set.getString(9));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}
	public boolean editEmployee(Employee obj) {
		connection = ConnectionManager.getConnection();
		String query = "update employee set name = ?, email = ?, age = ?, gender = ?, mobile = ?, department = ?, address = ? where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, obj.getName());
			statement.setString(2, obj.getEmail());
			statement.setInt(3, obj.getAge());
			statement.setString(4, obj.getGender());
			statement.setString(5, obj.getMobile());
			statement.setString(6, obj.getDepartment());
			statement.setString(7, obj.getAddress());
			statement.setInt(8, obj.getId());
			
			int count = statement.executeUpdate();
			if(count == 0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
	public boolean deleteEmployee(int id) {
		connection = ConnectionManager.getConnection();
		String query = "delete from employee where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			int count = statement.executeUpdate();
			if(count == 0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
