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

@WebServlet("/update")
public class UpdateProductsByAdmin extends HttpServlet
{
	ProductService service=new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Product product= service.getProduct(id);
		HttpSession session=req.getSession();
		session.setAttribute("productDetails", product);
		session.setAttribute("id", product.getpId());
		RequestDispatcher dispatcher=req.getRequestDispatcher("UpdateDetails.jsp");
		dispatcher.forward(req, resp);
		
	}
}
