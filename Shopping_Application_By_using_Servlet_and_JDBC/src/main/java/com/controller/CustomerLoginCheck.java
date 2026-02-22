package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAO;
import com.DTO.Product;
import com.service.CustomerService;

@WebServlet("/CustLog")
public class CustomerLoginCheck extends HttpServlet
{
	CartDAO cartDAO=new CartDAO();
	CustomerService service=new CustomerService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
//		System.out.println(email);
//		System.out.println(pwd);
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		int id=service.checkCustomer(email, pwd);
//		 System.out.println(id);
//		System.out.println(id);
		if(id>0) {
			//for id
			HttpSession session=req.getSession();
			session.setAttribute("cId", id);
			
			//for name
			String name=service.getCus(id);
			session.setAttribute("customer", name);
			
			//for products
			List<Product> listOfAllProducts=service.getAllproduct();
			session.setAttribute("ListOfAllProducts", listOfAllProducts);
			
			//for cart
			int items=cartDAO.getNumberOfItems(id);
			session.setAttribute("cartItems", items);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerOperations.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			writer.println("Your are not found ....Please register first");
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerReg.jsp");
			dispatcher.include(req, resp);
		}
		
		
	}
}
