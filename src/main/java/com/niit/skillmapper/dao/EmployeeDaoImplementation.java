package com.niit.skillmapper.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImplementation implements EmployeeDao{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Integer registerNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().save(employee);
	}
	@Transactional
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}
	@Transactional
	public Employee displayEmployeeDetails(int employeeId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Employee.class, employeeId);
	}
	@Transactional
	public List<Employee> displayAllEmployees() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}
	@Transactional
	public Employee validateEmployee(String mailId, String password) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory
	            .getCurrentSession().createCriteria(Employee.class);
	    criteria.add(Expression.eq("memberUserName", mailId));
	    criteria.add(Expression.eq("password", password));
	    Employee employee=(Employee)criteria.uniqueResult();
		return employee;
	}
	@Transactional
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stATUS
		
		updateEmployee(employee);
		return true;
	}
	public boolean approveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}
}
