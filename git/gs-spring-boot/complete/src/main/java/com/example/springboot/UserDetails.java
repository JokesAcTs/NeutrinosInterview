package com.example.springboot;


public class UserDetails {
	private String userName;
	private String password;
	private String designation;
	
	public UserDetails() {
	}
	
	public UserDetails(String userName, String password, String designation) {
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
