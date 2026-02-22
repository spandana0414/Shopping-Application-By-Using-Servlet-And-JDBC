package com.service;

import java.util.List;

import com.DAO.CustomerDAO;
import com.DTO.Customer;
import com.DTO.Product;

public class CustomerService {
	CustomerDAO customerDAO=new CustomerDAO();
	ProductService service=new ProductService();
	public void addCustomer(Customer customer) {
		
		customerDAO.addCustomerDetails(customer);
	}
	public int checkCustomer(String email,String pass) {
		return customerDAO.getCustomer(email, pass);
	}
	public String getCus(int id) {
		return customerDAO.getCusForCart(id);
	}
	public List<Product> getAllproduct(){
		return service.listAllProducts();
	}
	public Product getBuyingProduct(int id) {
		return customerDAO.getProduct(id);
	}
}
