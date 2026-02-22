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
import com.service.CartService;
import com.service.CustomerService;
import com.service.ProductService;

@WebServlet("/checkTotalAmmount")
public class CartBilling extends HttpServlet
{
	CartDAO cartDAO=new CartDAO();
	CartService service=new CartService();
	CustomerService customerService=new CustomerService();
	ProductService productService=new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		int cId=(int)session.getAttribute("cId");
		System.out.println(cId);
		double totalAmmountEntered=Double.parseDouble(req.getParameter("totalAmmount"));
		double actualAmmount=(double)session.getAttribute("tA");
		List<Integer> pids=(List<Integer>)session.getAttribute("pIds");
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		if(actualAmmount!=totalAmmountEntered) {
			writer.println("<h3>Enter currectAmmount</h3>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("CartproductsForBuy.jsp");
			dispatcher.include(req, resp);
		}
		else {
			for(int pId:pids) {
				service.delecteCart(cId, pId);
				productService.updateProduct(productService.getQuant(pId), pId);
				writer.println("Order Placed Successfully...Continue your shopping..");
				int items=cartDAO.getNumberOfItems(cId);
				session.setAttribute("cartItems", items);
				List<Product> listOfAllProducts=customerService.getAllproduct();
				session.setAttribute("ListOfAllProducts", listOfAllProducts);
				RequestDispatcher dispatcher=req.getRequestDispatcher("CustomerOperations.jsp");
				dispatcher.include(req, resp);
				
			}
		}
	}
}
