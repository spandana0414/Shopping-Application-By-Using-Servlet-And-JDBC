package com.DTO;

public class Cart {
	private int cId;
	private int pId;
	private int id;
	public Cart() {
		
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cart [cId=" + cId + ", pId=" + pId + ", id=" + id + "]";
	}
	public Cart(int cId, int pId, int id) {
		super();
		this.cId = cId;
		this.pId = pId;
		this.id = id;
	}
	
	
}
