package com.niit.skillmapper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.niit.skillmapper.dao.EmployeeDao;
import com.niit.skillmapper.model.Employee;


@Service
public class EmployeeServicesImplementation implements EmployeeServices{
	
	/*public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
*/
	@Autowired
	EmployeeDao employeeDao;

	public Integer registerNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.registerNewEmployee(employee);
	}

	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setStatus("active");
		
		return employeeDao.updateEmployee(employee);
	}

	public Employee displayEmployeeDetails(String employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.displayEmployeeDetails(Integer.parseInt(employeeId));
	}

	public List<Employee> displayAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.displayAllEmployees();
	}

	public Employee validateEmployee(String mailId, String password) {
		// TODO Auto-generated method stub
		return employeeDao.validateEmployee(mailId, password);
	}

	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setStatus("INACTIVE");
		
		employeeDao.deleteEmployee(employee);
		return true;
	}

	public boolean approveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setStatus("ACTIVE");
		
		employeeDao.updateEmployee(employee);
		
		return true;
	}
	
}
