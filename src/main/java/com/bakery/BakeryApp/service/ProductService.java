package com.bakery.BakeryApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bakery.BakeryApp.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public Optional<Product> findById(int id);

	public void deleteById(int id);

	public void save(Product theProduct);

	public boolean nameExists(String name);

	public Product findByName(String product);

	public Page<Product> findByProductId(Pageable pageable);
	
}
