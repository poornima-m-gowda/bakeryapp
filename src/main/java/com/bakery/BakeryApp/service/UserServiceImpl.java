package com.bakery.BakeryApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bakery.BakeryApp.dao.UserRepository;
import com.bakery.BakeryApp.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	public UserRepository userRepository;
	
	public UserServiceImpl(UserRepository theUserRepository) {
		
		userRepository = theUserRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}


	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);	
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public boolean emailExists(String email) {
		
		User theUser = userRepository.findByEmail(email);
		
		if(theUser == null) {
			return false;
		}
		return true;
		
	}

	
}
