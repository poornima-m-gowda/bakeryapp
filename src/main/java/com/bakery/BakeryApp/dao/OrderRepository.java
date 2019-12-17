package com.bakery.BakeryApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.BakeryApp.entity.Order;
import com.bakery.BakeryApp.entity.Product;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
