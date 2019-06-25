package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:humanDetails.properties")
public class Customer implements Human {

	@Value("${customerId}")
	private int customerId;
	@Value("${customerName}")
	private String customerName;
	@Autowired
	@Qualifier("homeAddress")

	private Address address;

	
	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String getHumanDetails() {
		// TODO Auto-generated method stub
		return this.toString();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address="
				+ address.toString()+ "]";
	}

}
