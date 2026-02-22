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
import com.service.CartService;

@WebServlet("/cartItems")
public class MyCart extends HttpServlet
{
	CartService service=new CartService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(req.getParameter("caId"));
		int cId=Integer.parseInt(req.getParameter("caId"));
		List<Product> listOfProductsInCart=service.getAllProductsForBuy(cId);
		HttpSession session=req.getSession();
		session.setAttribute("cId", cId);
		session.setAttribute("listOfProductsInCart", listOfProductsInCart);
		RequestDispatcher dispatcher=req.getRequestDispatcher("CartproductsForBuy.jsp");
		dispatcher.forward(req, resp);
	}
}
