package com.bakery.BakeryApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.BakeryApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
