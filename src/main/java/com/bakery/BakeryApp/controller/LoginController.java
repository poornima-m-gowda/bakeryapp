package com.bakery.BakeryApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bakery.BakeryApp.entity.Product;
import com.bakery.BakeryApp.service.ProductService;

@Controller
public class LoginController {
	
	@Autowired
	public ProductService productService;

	@GetMapping("/login")
	public String loginPage() {
		return "Login-page";
	}
	
	@GetMapping("/")
	public String showHome(Model theModel){
		
		Page<Product> productDetails = productService.findByProductId(PageRequest.of(0, 2, Direction.ASC, "id"));
		List<Product> product = productDetails.getContent();
		theModel.addAttribute("product", product);
		return "products";
	}
	
	@GetMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";
	}
	
}
