package com.service;

import com.DAO.AdminRegDAO;
import com.DTO.Admin;

public class AdminRegService {
	AdminRegDAO adminRegDAO =new AdminRegDAO();
	public void validateAdminDetails(Admin admin) {
		
			String psw=admin.getPassword();
			if(psw.length()!=4) {
				throw new InvalidPassword("Invalid Password");
			}
			else {
				adminRegDAO.inserAdminDetails(admin);
			}
		}
	public String fetchAdmin(String email,String pwd) {
		return adminRegDAO.fetchAdmin(email, pwd);
	}

}
