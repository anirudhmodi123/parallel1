package com.cg.pp.beans;




public class Customer {
	private String mobileNumber;
	private Account account;
	private String name;


	public Customer(String name, String mobileNumber, Account account) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name: " + name + "\nMobile number.: " + mobileNumber + "\nBalance: " + account;
	}

}
