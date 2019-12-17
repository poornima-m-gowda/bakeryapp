package com.bakery.BakeryApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.bakery.BakeryApp.entity.User;

public interface UserService {

	public List<User> findAll();

	public Optional<User> findById(int id);

	public void deleteById(int id);

	public void save(User theUser);

	public boolean emailExists(String email);

}
