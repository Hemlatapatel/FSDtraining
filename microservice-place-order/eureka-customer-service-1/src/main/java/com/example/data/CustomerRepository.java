package com.example.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
