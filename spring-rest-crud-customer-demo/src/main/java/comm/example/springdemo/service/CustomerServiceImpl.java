package comm.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.example.springdemo.dao.CustomerDao;
import comm.example.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return dao.getCustomer(id);
	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.createCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(id);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

}
