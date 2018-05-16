package com.niit.skillmapper.tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.services.EmployeeServices;


public class RegisterEmployeeTest {
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
    public void registerNewEmployeeTest(){
  	  Employee employee=new Employee();
  	  
  	  employee.setEmployeeFirstName("Shaik");
  	  employee.setEmployeeLastName("Nagul");
  	  employee.setEmployeeMailId("nagul.shaik@gmail.com");
  	  employee.setEmployeeGender("male");
  	  employee.setEmployeePhoneNumber(8247445085L);
  	  employee.setEmployeeRole("Faculty");
  	  employee.setEmployeePassword("nagul123");
  	 
  	  assertEquals("There is an Error",1,employeeService.registerNewEmployee(employee).intValue());
  	  
    }
}