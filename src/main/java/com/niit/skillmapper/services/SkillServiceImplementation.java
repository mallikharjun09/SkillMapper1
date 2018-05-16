package com.niit.skillmapper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapper.dao.SkillsDao;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skills;

@Service
public class SkillServiceImplementation implements SkillService{
	@Autowired
	SkillsDao skillsDao;
	@Autowired
	EmployeeServices employeeServices;
	
	public Integer addSkills(Skills skills) {
		// TODO Auto-generated method stub
		Employee employee=employeeServices.displayEmployeeDetails(skills.getEmployeeId()+"");
		if(!employee.equals(null)){
			skillsDao.addSkills(skills);
			return 1;
		}
		else
		    return 0;
	}

	public boolean updateSkills(Skills skills) {
		// TODO Auto-generated method stub
		
		return skillsDao.updateSkills(skills);
	}

	public Skills displaySkills(int employeeId) {
		// TODO Auto-generated method stub
		return skillsDao.displaySkills(employeeId);
	}

	public List<Employee> searchEmployeesBySkillis(String skill) {
		// TODO Auto-generated method stub
		return skillsDao.searchEmployeesBySkillis(skill);
	}

}
