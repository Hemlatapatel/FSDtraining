package com.example.springboot.springbootrestbasicemployee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.springboot.springbootrestbasicemployee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	
	
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		// TODO Auto-generated constructor stub
		this.entityManager = entityManager;
	}



	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		return query.getResultList();
	}



	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee  = currentSession.get(Employee.class, id);
		return employee;
	}



	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}



	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		currentSession.delete(employee);
	}

}
