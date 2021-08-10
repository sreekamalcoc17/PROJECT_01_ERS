package com.revature.pojo;

public class Authentication {
	private String status;
	private int sessionid; 

	public Authentication(String status) {
		super();
		this.status = status;
		
	}

	public Authentication() {
		super();
	}
	

	public int getSessionid() {
		return sessionid;
	}

	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Authentication [status=" + status + "]";
	}
	

}
