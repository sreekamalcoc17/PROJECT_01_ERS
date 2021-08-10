package com.revature.pojo;

public class SessionEmailManage {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SessionEmailManage(String email) {
		super();
		this.email = email;
	}

	public SessionEmailManage() {
		super();
	}

	@Override
	public String toString() {
		return "SessionEmailManage [email=" + email + "]";
	}
	

}
