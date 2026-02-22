package com.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/filter")
public class FilterData extends HttpServlet
{
	ProductService service=new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String field=req.getParameter("field");
		List<Product> list=service.listOfFilteredProducts(field);
		HttpSession session=req.getSession();
		session.setAttribute("ListOfAllProduct", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("AllProductsForAdmin.jsp");
		dispatcher.include(req, resp);
		
	}
}
