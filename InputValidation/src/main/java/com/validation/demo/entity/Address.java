package com.validation.demo.entity;

import com.validation.demo.util.InputValidator;

public class Address {
	
	private int id;
	private String addressDetail;
	//@InputValidator(message= "Html tag not allowed !")
	private String streetNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	

}
