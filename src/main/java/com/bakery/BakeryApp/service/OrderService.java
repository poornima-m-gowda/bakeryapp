package com.bakery.BakeryApp.service;

import java.util.List;
import java.util.Optional;

import com.bakery.BakeryApp.entity.Order;
import com.bakery.BakeryApp.entity.Product;

public interface OrderService {

	List<Order> findAll();

	void save(Order theOrder);

	Optional<Order> findById(int id);

	void deleteById(int id);

}
