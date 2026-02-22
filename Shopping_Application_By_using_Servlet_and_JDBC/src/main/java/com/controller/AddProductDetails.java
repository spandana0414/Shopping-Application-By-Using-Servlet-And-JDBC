package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DTO.Product;
import com.service.ProductService;

@WebServlet("/productDetails")
public class AddProductDetails extends HttpServlet
{
	ProductService service=new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		double price=Double.parseDouble(req.getParameter("price"));
		String brand=req.getParameter("brand");
		double discount=Double.parseDouble(req.getParameter("discount"));
		String category=req.getParameter("category");
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		PrintWriter writer=resp.getWriter();
		resp.setContentType("text/html");
		Product product=new Product(0,name, price, brand, discount, category, quantity);
		boolean pro= service.addProduct(product);
		if(!pro) {
			writer.println("Name should not be empty");
			RequestDispatcher dispatcher=req.getRequestDispatcher("ProductDetails.jsp");
			dispatcher.include(req, resp);
		}
		else {
		RequestDispatcher dispatcher=req.getRequestDispatcher("AdminOperations.jsp");
		dispatcher.include(req, resp);
		}
	}
}
