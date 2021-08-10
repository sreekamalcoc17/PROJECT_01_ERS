package com.revature.pojo;

public class Sessionidmanage {
private int sessid;
	
	public int getSessid() {
		return sessid;
	}

	public void setSessid(int sessid) {
		this.sessid = sessid;
	}

	public Sessionidmanage(int sessid) {
		super();
		this.sessid = sessid;
	}

	public Sessionidmanage() {
		super();
	}

	@Override
	public String toString() {
		return "Sessionidmanage [sessid=" + sessid + "]";
	}
		


}
