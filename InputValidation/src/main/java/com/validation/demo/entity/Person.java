package com.validation.demo.entity;

import com.validation.demo.util.InputValidValues;
import com.validation.demo.util.InputValidator;
import com.validation.demo.util.OnlyAlphaNumeric;
import com.validation.demo.util.ValidField;
import com.validation.demo.util.ValidateHtml;
import com.validation.demo.util.ValidateSpecialCharacter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;


public class Person {
	
	private long Id;
	private String name;
	@InputValidator(value = InputValidValues.HTML_VALIDATE)
	private String userName;
	@Email(message = "Email not verified !!")
	private String email;
	@InputValidator(value = InputValidValues.ALPHA_NUMERIC)
	private String message;
	
	private Address address; 
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	

}
