package com.bakery.BakeryApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bakery.BakeryApp.dao.OrderRepository;
import com.bakery.BakeryApp.entity.Order;
import com.bakery.BakeryApp.entity.Product;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	public ProductService productService;
	
	public OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderRepository theOrderRepository) {
		orderRepository = theOrderRepository;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public void save(Order theOrder) {
		orderRepository.save(theOrder);
	}

	@Override
	public Optional<Order> findById(int id) {
		return orderRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		orderRepository.deleteById(id);
	}

	
}
