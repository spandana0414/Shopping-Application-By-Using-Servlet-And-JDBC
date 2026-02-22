package com.DTO;

public class Customer {
	private String cName;
	private String cEmal;
	private long cMobileNumber;
	private String cPassword;
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcEmal() {
		return cEmal;
	}
	public void setcEmal(String cEmal) {
		this.cEmal = cEmal;
	}
	public long getcMobileNumber() {
		return cMobileNumber;
	}
	public void setcMobile(long cMobile) {
		this.cMobileNumber = cMobile;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public Customer(String cName, String cEmal, long cMobile, String cPassword) {
		
		this.cName = cName;
		this.cEmal = cEmal;
		this.cMobileNumber = cMobile;
		this.cPassword = cPassword;
	}
	@Override
	public String toString() {
		return "Customer [cName=" + cName + ", cEmal=" + cEmal + ", cMobile=" + cMobileNumber + ", cPassword=" + cPassword
				+ "]";
	}
	
}
