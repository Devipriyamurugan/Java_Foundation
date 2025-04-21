package com.hexaware.ims1.entity;

public class Customer {
	private int customerID;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private int creditScore;
    public Customer() {
    	
    }
	public Customer(int customerID, String name, String email, String phoneNumber, String address, int creditScore) {
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creditScore = creditScore;
	}
	public Customer(int customerId)
	{
		this.customerID = customerId;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}


}
