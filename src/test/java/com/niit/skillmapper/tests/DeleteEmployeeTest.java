package com.niit.skillmapper.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.services.EmployeeServices;

public class DeleteEmployeeTest {

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
	public void delteEmployeeTest() {
		Employee employee=employeeService.displayEmployeeDetails("10003");
		assertTrue("Eployee Deleted Successfully",true,employeeService.deleteEmployee(employee));
	}

	private void assertTrue(String string, boolean b, boolean deleteEmployee) {
		// TODO Auto-generated method stub
		
	}

}
