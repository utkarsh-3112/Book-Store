package com.example.demo.models;

public class UserAccount {
	
	private String userName;
	private String gender;
	private String password;
	private String mobileNo;
	private String firstName;
	private String lastName;
	
	public UserAccount(String userName, String gender, String password, String mobileNo, String firstName, String lastName) {
		this.userName = userName;
		this.gender = gender;
		this.password = password;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
