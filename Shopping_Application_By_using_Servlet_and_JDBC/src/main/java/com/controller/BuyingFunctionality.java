package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DTO.Product;
import com.service.CustomerService;

@WebServlet("/buy")
public class BuyingFunctionality extends HttpServlet {
	CustomerService service=new CustomerService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		int pid=Integer.parseInt(req.getParameter("pid"));
		int cId=(int)session.getAttribute("cId");
		//System.out.println(pid);
		Product product=service.getBuyingProduct(pid);
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		if(product!=null && product.getQuantity()!=0) {
			session.setAttribute("product", product);
		RequestDispatcher dispatcher=req.getRequestDispatcher("Buying.jsp");
		dispatcher.forward(req, resp);
		}
		else {
			writer.println("<h3 style='color:red;'>Product out of stack...Please choose another</h3>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerOperations.jsp");
			dispatcher.include(req, resp);
		}
		
	}

}
