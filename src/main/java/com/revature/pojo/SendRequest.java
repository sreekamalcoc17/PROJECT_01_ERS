package com.revature.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class SendRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reqid;
	@Column(name = "email")
	private String email;
	@Column(name = "reason")
	private String reason;
	@Column(name = "amount")
	private int amount;
	@Column(name = "status")
	private String statusOfReq;
	
	public SendRequest(String email,String reason, int amount, String statusOfReq) {

		this.email = email;
		this.reason = reason;
		this.amount = amount;
		this.statusOfReq = statusOfReq;
	}
	
	
	public int getReqid() {
		return reqid;
	}


	public void setReqid(int reqid) {
		this.reqid = reqid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public SendRequest() {
		super();
	}
	
	public String getStatusOfReq() {
		return statusOfReq;
	}

	public void setStatusOfReq(String statusOfReq) {
		this.statusOfReq = statusOfReq;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "SendRequest [reqid=" + reqid + ", email=" + email + ", reason=" + reason + ", amount=" + amount
				+ ", statusOfReq=" + statusOfReq + "]";
	}

	



}
