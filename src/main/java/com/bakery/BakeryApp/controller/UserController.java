package com.bakery.BakeryApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.BakeryApp.dao.UserRepository;
import com.bakery.BakeryApp.entity.User;
import com.bakery.BakeryApp.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public UserService userService;
	
	public UserController(UserService theUserService) {
		
		userService = theUserService;
	}
	
	@GetMapping("/users")
	public String showUsers(Model theModel, @RequestParam(defaultValue="0") int page) {
		
		List<User> theUsers = userService.findAll();
		theModel.addAttribute("users", theUsers);
		return "users";
	}
	
	@GetMapping("/users/register")
	public String registerUser(Model theModel) {
		
		User theUser = new User();
		theModel.addAttribute("user",theUser);
		return "register-user";
	}
	
	@PostMapping("/users/register")
	public String registeredUser(@ModelAttribute("user") @Valid User theUser ,
									BindingResult bindingResult,
									ModelMap theModel) {
		
		if (bindingResult.hasErrors()) {
			return "register-user";
		}

//		if(theUser.getConfirmPassword().equals(theUser.getPassword())) {
//			userService.save(theUser);
//			return "redirect:/users";
//		}else {
//			theModel.put("password", "password mismatch");
//			return "register-user";
//		}
			
		boolean emailExists = userService.emailExists(theUser.getEmail());
		
		if(emailExists) {
			theModel.put("error", "user already exists");
			return "register-user";
		}
		
		userService.save(theUser);
		return "redirect:/users";
	}
	
	
	@GetMapping("/users/update")
	public String updateUser(@RequestParam("userId") int id , Model theModel) {
		
		Optional<User> theUser = userService.findById(id);
		theModel.addAttribute("user", theUser);
		
		return "edit-user";
	}
	
	@PostMapping("/users/update")
	public String updatedUser(@ModelAttribute("user") User theUser) {
		
		userService.save(theUser);
		return "redirect:/users";
	}
	
	@GetMapping("/users/delete")
	public String deleteUser(@RequestParam("userId") int id, Model theModel) {
		
		Optional<User> theUser = userService.findById(id);
		if(theUser == null) {
			return "user not found";
		}
		userService.deleteById(id);
		return "redirect:/users";
	}
	
}
