package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DTO.Product;

public class CartDAO {
	ProductDAO productDAO=new ProductDAO();
	private static final String insert="insert into cart(pId, Id) values (?,?)";
	private static final String getC="select cid from cart where pid=? and id=?";
	private static final String getProduct="select pQuantity from product where pId=?";
	private static final String deleteCart="delete from cart where id=? and pid=?";
	private static final String getCartItems="select count(*) from cart where Id=?";
	private static final String getProductsFromCart="select pId from cart where id=? group by pid,id ";
	private static final String url="jdbc:mysql://localhost:3307/shopping_application?user=root&password=root";
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url);
		return con;
	}
	private int getPQuantity(int id) {
		int quant=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(getProduct);
			ps.setInt(1, id);
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
	public int insertIntoCart(int pId,int id) {
//		List<Product> allproducts=cartDAO.getAllProductsFromCart(id);
		int cid=getCIdBasedOnPidandId(pId, id);
		int res=0;
		if(getPQuantity(pId)>0 && cid==0) {
			try {
				Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement(insert);
				ps.setInt(1, pId);
				ps.setInt(2, id);
				
				res=ps.executeUpdate();
				
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	public int getNumberOfItems(int cId) {
		int res=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(getCartItems);
			ps.setInt(1, cId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				res=rs.getInt(1);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public List<Product> getAllProductsFromCart(int cId){
		List<Product> list=new ArrayList<Product>();
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(getProductsFromCart);
			ps.setInt(1, cId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(productDAO.getProductForUpdate(rs.getInt(1)));
				
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void deleteCartDetails(int cid,int pid) {
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(deleteCart);
			ps.setInt(1, cid);
			ps.setInt(2, pid);
			ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getCIdBasedOnPidandId(int pid,int id) {
		int cid=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(getC);
			ps.setInt(1, pid);
			ps.setInt(2, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cid=rs.getInt(1);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cid;
	}
}
