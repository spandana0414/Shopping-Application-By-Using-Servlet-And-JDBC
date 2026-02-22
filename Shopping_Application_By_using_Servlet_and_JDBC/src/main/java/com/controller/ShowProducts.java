package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DTO.Product;
import com.service.ProductService;

@WebServlet("/showproducts")
public class ShowProducts extends HttpServlet
{
	ProductService service=new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list=service.listAllProducts();
		HttpSession session=req.getSession();
		session.setAttribute("ListOfAllProduct", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("AllProductsForAdmin.jsp");
		dispatcher.include(req, resp);
	}
}
