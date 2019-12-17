package com.bakery.BakeryApp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.BakeryApp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductName(String name);
	
	Page<Product> findAll(Pageable pageable);
	
}
