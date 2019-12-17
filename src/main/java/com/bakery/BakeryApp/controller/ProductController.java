package com.bakery.BakeryApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bakery.BakeryApp.entity.Product;
import com.bakery.BakeryApp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	public ProductService productService;

	public ProductController(ProductService theProductService) {
		productService = theProductService;
	}

//	@GetMapping("/products")
//	public String showProducts(Model theModel) {
//
//		List<Product> theProducts = productService.findAll();
//		theModel.addAttribute("products", theProducts);
//
//		return "products";
//	}

	@GetMapping("/productDetails/{page}")
	public String showProductsById(@PathVariable("page") int page,  Model theModel) {

		Page<Product> productDetails = productService.findByProductId(PageRequest.of(page, 2, Direction.ASC, "id"));
		List<Product> product = productDetails.getContent();
		theModel.addAttribute("product", product);
		theModel.addAttribute("page",page);
		return "products";
	}
	
	
	@GetMapping("/products/register")
	public String registerProduct(Model theModel) {

		Product theProduct = new Product();
		theModel.addAttribute("product", theProduct);
		return "register-product";
	}

	@PostMapping("/products/register")
	public String registeredProduct(@ModelAttribute("product") Product theProduct, ModelMap theModel) {

		boolean nameExists = productService.nameExists(theProduct.getProductName());

		if (nameExists) {
			theModel.put("error", "product already exists");
			return "register-product";
		}

		productService.save(theProduct);
		return "redirect:/productDetails/0";
	}

	@GetMapping("/products/update")
	public String updateProduct(@RequestParam("productId") int id, Model theModel) {

		Optional<Product> theProduct = productService.findById(id);
		theModel.addAttribute("product", theProduct);

		return "edit-product";
	}

	@PostMapping("/products/update")
	public String updatedProduct(@ModelAttribute("product") Product theProduct) {

		productService.save(theProduct);
		return "redirect:/productDetails/0";
	}

	@GetMapping("/products/delete")
	public String deleteProduct(@RequestParam("productId") int id, Model theModel) {

		Optional<Product> theProduct = productService.findById(id);
		if (theProduct == null) {
			return "user not found";
		}
		productService.deleteById(id);
		return "redirect:/productDetails/0";
	}

}
