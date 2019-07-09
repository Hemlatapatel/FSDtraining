package com.example.springboot.springbootrestbasicemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.springbootrestbasicemployee.entity.Employee;


public interface EmployeeRepositoryDAO extends JpaRepository<Employee, Integer>{

}
