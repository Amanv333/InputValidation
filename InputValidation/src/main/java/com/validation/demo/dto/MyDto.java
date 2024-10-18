package com.validation.demo.dto;

import com.validation.demo.util.OnlyAlphaNumeric;



public class MyDto {
	private String name;
	
	private String email;
	@OnlyAlphaNumeric
	private String UserName;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
