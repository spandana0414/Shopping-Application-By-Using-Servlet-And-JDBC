package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DTO.Product;
import com.service.ProductService;

@WebServlet("/updateDetails")
public class UpdateDetails extends HttpServlet
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
		HttpSession session=req.getSession();
		int id=(int)session.getAttribute("id");
//		int id=Integer.parseInt(req.getParameter("id"));
		Product product=new Product(id, name, price, brand, discount, category, quantity);
		service.updateProductDetails(product);
		RequestDispatcher dispatcher=req.getRequestDispatcher("showproducts");
		dispatcher.forward(req, resp);
		
	}
}
