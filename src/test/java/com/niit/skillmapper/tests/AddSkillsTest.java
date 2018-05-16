package com.niit.skillmapper.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.skillmapper.model.Skills;
import com.niit.skillmapper.services.EmployeeServices;
import com.niit.skillmapper.services.SkillService;

public class AddSkillsTest {
	@Autowired
	static SkillService skillService;
	@BeforeClass
	public static void preExecution() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		skillService = (SkillService)context.getBean("skillService");
		
		
	}
	@Test
	public void addSkillTest(){
		Skills skill=new Skills();
		skill.setCertifications("OCJP,OCPP,OSQL");
		skill.setEmployeeId(2);
		skill.setFeedback(" very good ");
		skill.setKnown_languages("Telugu, Hindi, English");
		skill.setNo_of_students_placed(198L);
		skill.setTechnicalSkills("Java, Adv. Java, SQL, PLSQL, Android");
		skill.setTotal_no_of_students(1200L);
		skill.setTotal_no_of_hours(2000L);
		skill.setYears_of_experience(4.2);
		
		assertEquals("Successfully added",1,skillService.addSkills(skill).intValue());
	}
}
