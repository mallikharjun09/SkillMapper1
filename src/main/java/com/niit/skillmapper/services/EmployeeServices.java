package com.niit.skillmapper.services;

import java.util.List;

import com.niit.skillmapper.model.Employee;

public interface EmployeeServices {
	public Integer registerNewEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public Employee displayEmployeeDetails(String employeeId);
	public List<Employee> displayAllEmployees();
	public Employee validateEmployee(String mailId,String password);
	public boolean deleteEmployee(Employee employee);
	public boolean approveEmployee(Employee employee);
}
