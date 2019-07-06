package comm.example.springdemo.dao;

import java.util.List;
import comm.example.springdemo.entity.*;

public interface CustomerDao {

	List<Customer> getAllCustomer();
	
	void createCustomer(Customer customer);
	
	Customer getCustomer(int id);
		
	boolean deleteCustomer(int id);
}
