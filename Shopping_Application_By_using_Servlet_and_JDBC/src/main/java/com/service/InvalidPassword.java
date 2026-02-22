package com.service;

public class InvalidPassword extends RuntimeException{
	String msg="";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public InvalidPassword(String msg) {
		
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}
	
}
