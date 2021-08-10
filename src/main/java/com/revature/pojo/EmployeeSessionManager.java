package com.revature.pojo;


public class EmployeeSessionManager {
	private int id;
	
	private String firstName;

	private String lastName;
	
	private String email;

	private String password;

	private long phno;
	private int houseNo;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int pin;
	
	private String status;

	public EmployeeSessionManager(int id, String firstName, String lastName, String email, String password, int phno,
			int houseNo, String city, String state, String country, int pin, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phno = phno;
		this.houseNo = houseNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.status = status;
	}

	public EmployeeSessionManager() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeeSessionManager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", phno=" + phno + ", houseNo=" + houseNo + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pin=" + pin + ", status=" + status + "]";
	}

}
