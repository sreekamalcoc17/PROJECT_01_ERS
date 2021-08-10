package com.revature.pojo;


public class Login {
	
	private String email;
	
	private String password;
	
	private String designation;
	
	

	public Login(String email, String password, String designation) {
		this.email = email;
		this.password = password;
		this.designation = designation;
	}

	public Login() {
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + ", designation=" + designation + "]";
	}

	

}
