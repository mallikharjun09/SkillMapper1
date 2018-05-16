package com.niit.skillmapper.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.services.EmployeeServices;

public class ValidateEmployeeTest {

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
	public void validateEmployeeTest() {
		Employee employee=new Employee();
		assertEquals("Valid Employee",employee,employeeService.validateEmployee("nagul.shaik@gmail.com", "nagul123"));
	}

}
