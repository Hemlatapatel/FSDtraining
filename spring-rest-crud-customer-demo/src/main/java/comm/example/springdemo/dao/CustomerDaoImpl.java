
package comm.example.springdemo.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.example.springdemo.entity.*;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private Session session;
	private Customer customer;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();

		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		session.saveOrUpdate(customer);
		session.getTransaction().commit();
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		/*
		 * // delete object with primary key Query theQuery =
		 * currentSession.createQuery("delete from Customer where id=:customerId");
		 * theQuery.setParameter("customerId", theId);
		 * 
		 * theQuery.executeUpdate();
		 */
		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			session.delete(customer);
			session.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
}
