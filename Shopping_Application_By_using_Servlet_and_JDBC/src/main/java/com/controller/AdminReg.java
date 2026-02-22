package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DTO.Admin;
import com.service.AdminRegService;
import com.service.InvalidPassword;
@WebServlet("/adminreg")
public class AdminReg extends HttpServlet
{
	AdminRegService service=new AdminRegService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		Admin admin=new Admin(name, email, password, gender);
		try {
			service.validateAdminDetails(admin);
			RequestDispatcher dispatcher=req.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(req, resp);
		}
		catch (InvalidPassword e) {
			writer.println("Invalid Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("AdminRegistration.jsp");
			dispatcher.include(req, resp);
			
		}
	}
}
