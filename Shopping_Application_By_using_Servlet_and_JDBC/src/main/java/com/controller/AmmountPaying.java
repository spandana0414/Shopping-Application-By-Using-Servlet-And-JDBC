package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DTO.Product;
import com.service.ProductService;

@WebServlet("/ammount")
public class AmmountPaying extends HttpServlet
{
	ProductService service=new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double ammount=Double.parseDouble(req.getParameter("ammount"));
		HttpSession session=req.getSession();
		double pay=(double)session.getAttribute("ammountpay");
		System.out.println(ammount);
		System.out.println(pay);
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		if(ammount!=pay) {
			writer.println("<h3 style'=color:red;>Please Enter currect ammount..</h3>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Buying.jsp");
			dispatcher.include(req, resp);
		}
		else{
			int pQuant=(int)session.getAttribute("pQuant");
			int prodId=(int)session.getAttribute("prodId");
			
			System.out.println(pQuant);
			System.out.println(prodId);
			service.updateProduct(pQuant, prodId);
			writer.println("<h3 style'=color:green;>Order Placed Successfully..</h3>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerOperations.jsp");
			dispatcher.include(req, resp);
		}
		
		
	}

}
