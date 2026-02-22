package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.DTO.Product;

public class ProductDAO 
{
	private static final String url="jdbc:mysql://localhost:3307/shopping_application?user=root&password=root";
	private static final String insert="insert into product(pName, pPrice, pBrand, pDiscount, pCategory, pQuantity) values(?,?,?,?,?,?)";
	private static final String display="select * from product";
	
	private static final String updateProductQuantity="update product set pQuantity=? where pId=?";
	private static final String filterQ="select * from product where pName=? or pPrice=? or pBrand=? or pDiscount=? or pCategory=? or pQuantity=?";
	public void addProduct(Product product) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1, product.getpName());
			try {
			ps.setDouble(2, product.getpPrice());
			}
			catch (Exception e) {
				System.out.println("Enter currect details");
			}
			ps.setString(3, product.getpBrand());
			ps.setDouble(4, product.getpDiscount());
			ps.setString(5, product.getpCategory());
			try {
				ps.setInt(6, product.getQuantity());
				}
				catch (Exception e) {
					System.out.println("Enter currect details");
				}
			
			ps.executeUpdate();
			System.out.println("Product inserted");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Product> displayProducts() {
		List<Product> list=new ArrayList<Product>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(display);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product(rs.getInt(1) ,rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getInt(7));
				list.add(product);
			}
			System.out.println(list);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Product> filterData(String field){
		List<Product> list=new ArrayList<Product>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(filterQ);
			ps.setString(1, field);
			try {
			ps.setDouble(2, Double.parseDouble(field));
			
			}
			catch (NumberFormatException e) {
				ps.setDouble(2, 0);
			}
			ps.setString(3, field);
			try {
				ps.setDouble(4, Double.parseDouble(field));
				
				}
				catch (NumberFormatException e) {
					ps.setDouble(4, 0);
				}
			ps.setString(5, field);
			try {
				ps.setInt(6, Integer.parseInt(field));
				
				}
				catch (NumberFormatException e) {
					ps.setDouble(6, 0);
				}
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getInt(7));
				list.add(product);
			}
			System.out.println(list);
			System.out.println(list);
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public Product getProductForUpdate(int id) {
		Product product=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			String query="select * from product where pId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				product=new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getInt(7));
				
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	public void updateDetails(Product product) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			String query="update product set pName=?, pPrice=?, pBrand=?, pDiscount=?, pCategory=?, pQuantity=? where pId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, product.getpName());
			ps.setDouble(2, product.getpPrice());
			ps.setString(3, product.getpBrand());
			ps.setDouble(4, product.getpDiscount());
			ps.setString(5, product.getpCategory());
			ps.setInt(6, product.getQuantity());
			ps.setInt(7, product.getpId());
			ps.executeUpdate();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteProductByAdmin(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			String query="delete from product where pId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateQuantity(int quant,int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(updateProductQuantity);
			ps.setInt(1, quant-1);
			ps.setInt(2, id);
			ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getQuantity(int pid) {
		int quant=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			String query="select pQuantity from product where pId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				quant=rs.getInt(1);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quant;
	}
	
	
}
