package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.Admin;

public class AdminRegDAO {
	private static final String url="jdbc:mysql://localhost:3307/shopping_application?user=root&password=root";
	private static final String insert="insert into admin_details(name, email, password, gender) values(?,?,?,?)";
	private static final String fetch="select name from admin_details where email=? and password=?";
	
	
	
	
	public void inserAdminDetails(Admin admin) {
		//load and register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getGender());
			ps.executeUpdate();
			System.out.println("----inserted-----");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String fetchAdmin(String email,String password) {
		String name="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(fetch);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet= ps.executeQuery();
			while(resultSet.next()) {
				name=resultSet.getString(1);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
