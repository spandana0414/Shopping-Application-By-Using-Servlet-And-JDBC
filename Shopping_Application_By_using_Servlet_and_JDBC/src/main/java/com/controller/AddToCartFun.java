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

import com.DAO.CartDAO;
import com.service.CartService;

@WebServlet("/addtocart")
public class AddToCartFun extends HttpServlet {
	CartDAO cartDAO=new CartDAO();
	CartService service=new CartService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pId=Integer.parseInt(req.getParameter("pid"));
		HttpSession session=req.getSession();
		
		int cId=(int)session.getAttribute("cId");
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		
		int res=service.addToCart(pId, cId);
		if(res>0) {
			int items=cartDAO.getNumberOfItems(cId);
			session.setAttribute("cartItems", items);
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerOperations.jsp");
			dispatcher.forward(req, resp);
			
		}
		else {
//			writer.println("Product out of stack..");
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerOperations.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
