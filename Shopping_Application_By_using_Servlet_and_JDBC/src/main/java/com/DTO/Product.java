package com.DTO;

public class Product {
	private int pId;
	public int getpId() {
		return pId;
	}
	private String pName;
	private double pPrice;
	private String pBrand;
	private double pDiscount;
	private String pCategory;
	private int Quantity;
	public String getpName() {
		return pName;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public double getpDiscount() {
		return pDiscount;
	}
	public void setpDiscount(double pDiscount) {
		this.pDiscount = pDiscount;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public void setpId(int pId) {
		this.pId = pId;
	}
	public Product(int pId, String pName, double pPrice, String pBrand, double pDiscount, String pCategory,
			int quantity) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pBrand = pBrand;
		this.pDiscount = pDiscount;
		this.pCategory = pCategory;
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [pName=" + pName + ", pPrice=" + pPrice + ", pBrand=" + pBrand + ", pDiscount=" + pDiscount
				+ ", pCategory=" + pCategory + ", Quantity=" + Quantity + "]";
	}
	
	
}
