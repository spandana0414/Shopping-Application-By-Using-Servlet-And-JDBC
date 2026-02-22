package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DTO.Customer;
import com.service.CustomerService;

@WebServlet("/CustReg")
public class CustomerRegistration extends HttpServlet
{
	CustomerService service=new CustomerService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd=req.getParameter("password");
		System.out.println(pwd);
		PrintWriter writer=resp.getWriter();
		resp.setContentType("text/html");
		if(pwd.length()!=6) {
			writer.println("<h3>Password length should be 6 characters....Please try again</h3>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerReg.jsp");
			dispatcher.include(req, resp);
		}
		else {
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			long mobile=Long.parseLong(req.getParameter("mobile"));
			Customer customer=new Customer(name, email, mobile, pwd);
			service.addCustomer(customer);
			RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerLogin.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
