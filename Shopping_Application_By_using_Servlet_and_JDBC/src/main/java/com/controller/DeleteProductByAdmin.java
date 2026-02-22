package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ProductService;

@WebServlet("/delete")
public class DeleteProductByAdmin extends HttpServlet
{
	ProductService service=new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		service.deleteProduct(id);
		RequestDispatcher dispatcher=req.getRequestDispatcher("showproducts");
		dispatcher.forward(req, resp);
		
	}
}
