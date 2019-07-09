package com.example.springboot.springbootrestbasicemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.springbootrestbasicemployee.entity.Customer;

public interface CustomerRepositoryDAO extends JpaRepository<Customer, Integer> {

}
