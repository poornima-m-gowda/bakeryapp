package com.bakery.BakeryApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="bakeryorders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="phone_number")
	@Pattern(regexp="^\\d{10}$" , message="Please enter valid phone number")
	private String phoneNumber;
	
	@Column(name="products_ordered")
	private String productsOrdered;
	
	@Column(name="price")
	private String price;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total")
	private String total;
	
	@Column(name="due_date")
	private String dueDate;
	
	@Column(name="status")
	private String status;
	
	public Order() {
		
	}

	public Order(String customerName, String phoneNumber, String productsOrdered, String price, int quantity,
			String total, String dueDate, String status) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.productsOrdered = productsOrdered;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.dueDate = dueDate;
		this.status = status;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProductsOrdered() {
		return productsOrdered;
	}

	public void setProductsOrdered(String productsOrdered) {
		this.productsOrdered = productsOrdered;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
