package com.cg.pp.beans;

public class Account {
	private double balance;
	private int accountNumber;
	

	public Account() {
	};

	@Override
	public String toString() {
		return "" + balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(double balance,int i ) {
		this.balance = balance;
		this.accountNumber=i;
	}

	public double getBalance() {
		return balance;
	}
	
	
	public void setaccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;}
		
		public int getaccountNumber() {
			return accountNumber;
		}
	
}
