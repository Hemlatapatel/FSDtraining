package com.example.myphotogalleryaccountservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="accounts")
public class AccountEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2259900549250347763L;

	@Id
	@GeneratedValue
    private int id;
	
	@Column(nullable=false, length=50)
	private String accountHolder;
	
	@Column(nullable=false, length=50)
	private String accountType;
	

	@Column
	private String accountNumber;

	@Column
	@Pattern(regexp = "[a-zA-Z]{6}[0-9]{6}")
	private String customerId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
