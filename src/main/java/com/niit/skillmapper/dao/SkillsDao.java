package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skills;

public interface SkillsDao {
	public Integer addSkills(Skills skills);
	public boolean updateSkills(Skills skills);
	public Skills displaySkills(int employeeId);
	public List<Employee> searchEmployeesBySkillis(String skill);
	
}
