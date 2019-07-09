package com.example.springboot.springbootrestbasicemployee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		
		return query.getResultList();
	}



	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
    	Employee employee  =entityManager.find(Employee.class, id);
		return employee;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

		Employee theEmployee = entityManager.merge(employee);
		employee.setId(theEmployee.getId());
		return theEmployee;
	}



	@Override
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee employee = entityManager.find(Employee.class, id);
		if(employee != null)
			entityManager.remove(employee);
		return employee;
	}

}
