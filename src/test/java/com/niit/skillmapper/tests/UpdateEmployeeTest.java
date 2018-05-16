package com.niit.skillmapper.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.services.EmployeeServices;

public class UpdateEmployeeTest {

	@Autowired
	static EmployeeServices employeeService;
	@BeforeClass
	public static void preExecution() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		employeeService = (EmployeeServices)context.getBean("employeeServices");
		
		
	}
    
	@Test
	public void updateEmployeeTest() {
		Employee employee=employeeService.displayEmployeeDetails("10001");
		employee.setEmployeeFirstName("Shaik");
	  	  employee.setEmployeeLastName("Nagul");
	  	  employee.setEmployeeMailId("nagul.shaik@gmail.com");
	  	  employee.setEmployeeGender("male");
	  	  employee.setEmployeePhoneNumber(8247454545L);
	  	  employee.setEmployeeRole("Tech Mentor");
	  	  employee.setEmployeePassword("nagul123");
		  assertEquals("Updated Successfully", true,employeeService.updateEmployee(employee));
	}

}
