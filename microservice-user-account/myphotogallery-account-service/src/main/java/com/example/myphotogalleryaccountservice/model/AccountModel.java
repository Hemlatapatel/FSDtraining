package com.example.myphotogalleryaccountservice.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AccountModel {
	
	@NotNull(message="account holder can not be null")
	private String accountHolder;
	
	@NotNull(message="account type can not be null")
	private String accountType;
	
	@NotNull(message="customer id can not be null")
	@Pattern(regexp = "[a-zA-Z]{6}[0-9]{6}")
	private String customerId;

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
