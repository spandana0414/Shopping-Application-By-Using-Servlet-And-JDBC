package com.service;

import java.util.List;

import com.DAO.CartDAO;
import com.DTO.Product;

public class CartService 
{
	CartDAO cDao=new CartDAO();
	public int addToCart(int pId,int cId) {
		return cDao.insertIntoCart(pId, cId);
	}
	public int getItems(int cId) {
		return cDao.getNumberOfItems(cId);
	}
	public List<Product> getAllProductsForBuy(int cId){
		return cDao.getAllProductsFromCart(cId);
	}
	public void delecteCart(int cid,int pid) {
		cDao.deleteCartDetails(cid, pid);
	}
}
