package com.service;

import java.util.List;

import com.DAO.ProductDAO;
import com.DTO.Product;

public class ProductService {
	ProductDAO productDAO=new ProductDAO();
	public boolean addProduct(Product product) {
		if(product.getpName().equals("")||product.getpBrand().equals("")||product.getpCategory().equals("")||product.getpDiscount()==0||product.getQuantity()==0) {
			return false;
		}
		else {
		productDAO.addProduct(product);
		return true;
		}
	}
	public List<Product> listAllProducts(){
		return productDAO.displayProducts();
	}
	public List<Product> listOfFilteredProducts(String field){
		return productDAO.filterData(field);
	}
	public Product getProduct(int id) {
		return productDAO.getProductForUpdate(id);
	}
	public void updateProductDetails(Product p) {
		productDAO.updateDetails(p);
	}
	public void deleteProduct(int id) {
		productDAO.deleteProductByAdmin(id);
	}
	public void updateProduct(int quant,int id) {
		productDAO.updateQuantity(quant, id);
	}
	public int getQuant(int pid) {
		return productDAO.getQuantity(pid);
	}
}
