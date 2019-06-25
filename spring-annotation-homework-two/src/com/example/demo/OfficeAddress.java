package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:officeAddress.properties")

public class OfficeAddress implements Address {

	@Value("${office.land}")
	private String land;
	@Value("${office.phone}")
	private int phone;
	
	public String getLand() {
		return land;
	}

	public int getPhone() {
		return phone;
	}


	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return this.toString();
	}

	@Override
	public String toString() {
		return "OfficeAddress land=" + land + "and phone=" + phone ;
	}
	
	

}
