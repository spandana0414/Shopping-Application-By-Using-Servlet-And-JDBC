package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.Customer;
import com.DTO.Product;

public class CustomerDAO {
	//ProductDAO productDAO=new ProductDAO();
	private static final String insert=
			"insert into customer(cName, cEmail, cMobile, cPassword) values (?,?,?,?)";
	
		private static final String sCustomer=
				"select id from customer where cEmail=? and cPassword=?";
		private static final String getCustomer=
				"select cName from customer where id=?";
		private static final String getProduct=
				"select * from product where pid=?";
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=
		DriverManager.getConnection("jdbc:mysql://localhost:3307/shopping_application?user=root&password=root");
		return connection;
	}
	public void addCustomerDetails(Customer customer) {
		try {
			Connection con=CustomerDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1, customer.getcName());
			ps.setString(2, customer.getcEmal());
			ps.setLong(3, customer.getcMobileNumber());
			ps.setString(4, customer.getcPassword());
			if(ps.executeUpdate()>0) {
				System.out.println("Inserted sucessfull");
			}
			else {
				System.out.println("Insertion not done");
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getCustomer(String email,String password) {
		int res=0;
		try {
			Connection con=CustomerDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(sCustomer);
			ps.setString(1, email);
			ps.setString(2, password);
//			System.out.println(email);
//			System.out.println(password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				res=rs.getInt(1);
//				System.out.println(res);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public String getCusForCart(int id) {
		String name="";
		try {
			Connection con=CustomerDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(getCustomer);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				name=rs.getString(1);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	public Product getProduct(int id) {
		Product p=new Product();
		try {
			Connection con=CustomerDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(getProduct);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpPrice(rs.getDouble(3));
				p.setpBrand(rs.getString(4));
				p.setpDiscount(rs.getDouble(5));
				p.setpCategory(rs.getString(6));
				p.setQuantity(rs.getInt(7));				
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
