package com.example.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
