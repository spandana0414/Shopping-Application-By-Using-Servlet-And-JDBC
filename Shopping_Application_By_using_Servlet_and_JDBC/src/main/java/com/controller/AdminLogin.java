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

import com.service.AdminRegService;
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet
{
	AdminRegService service=new AdminRegService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		String name=service.fetchAdmin(email, password);
		HttpSession session=req.getSession();
		session.setAttribute("name", name);
		if(!name.equals("")) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("AdminOperations.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			writer.println("Admin Not found");
			RequestDispatcher dispatcher=req.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.include(req, resp);
		}
	}
}
