
package com.example.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		session.getTransaction().commit();

		return customers;
	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		session.save(customer);
		session.getTransaction().commit();

		System.out.println("customer added successfully");
	}


	@Override
	@Transactional
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
//		Customer cust = session.get(Customer.class, customer.getId());
		session.getTransaction().begin();

		session.merge(customer);
		session.getTransaction().commit();

	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println("id==============" + id);
		session.getTransaction().begin();
		Customer customer = session.get(Customer.class, id);
		System.out.println("name: " + customer.getFirstName());
		session.delete(customer);
		session.getTransaction().commit();

	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Customer customer = session.get(Customer.class, id);
		System.out.println("name: " + customer.getFirstName());
		
		return customer;
	}

}
