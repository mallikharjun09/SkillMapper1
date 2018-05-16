package com.niit.skillmapper.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skills;
import com.niit.skillmapper.services.EmployeeServices;

@Repository("skillsDao")
public class SkillsDaoImplementation implements SkillsDao{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	EmployeeDao employeeDao;
	@Transactional
	public Integer addSkills(Skills skills) {
		// TODO Auto-generated method stub
		return (Integer)sessionFactory.getCurrentSession().save(skills);
	}
	@Transactional
	public boolean updateSkills(Skills skills) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(skills);
		return true;
	}
	@Transactional
	public Skills displaySkills(int employeeId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Skills.class,employeeId);
	}
	@Transactional
	private List<Skills> searchAllRecords(String skill){
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Skills.class);
		Criterion cr=Restrictions.like("technicalSkills", skill);
		criteria.add(cr);
		return criteria.list();
	}
	@Transactional
	public List<Employee> searchEmployeesBySkillis(String skill) {
		// TODO Auto-generated method stub
		List<Employee> employeeList=null;
		for(Skills skills:searchAllRecords(skill)){
			
			employeeList.add(employeeDao.displayEmployeeDetails(skills.getEmployeeId()));
		}
		return employeeList;
		
	}

	}
