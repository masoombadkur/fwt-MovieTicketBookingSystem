package com.yash.mtbs.model;

public class Customer {

	private int customerId;

	private String name;

	private int age;

	private long mobileNo;

	private String email;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String name, int age, long mobileNo, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
