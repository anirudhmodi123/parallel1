package com.cg.pp.service;

import java.util.HashMap;


import com.cg.pp.beans.Customer;
import com.cg.pp.exceptions.CustomerExceptions;

public interface AccountService {
	Customer createAccount(Customer customer);

	double showBalance(String mobileNumber) throws CustomerExceptions;

	double deposit(String mobileNumber, double amount) throws CustomerExceptions;

	double withdraw(String mobileNumber, double amount) throws CustomerExceptions;

	Customer transfer(String mob1, String mob2, double amount) throws CustomerExceptions;
	
	boolean validateCustomer (Customer customer) throws CustomerExceptions;

	HashMap<Integer, String> printTransactions() throws CustomerExceptions;
	boolean validateNo(String mobileNo, double amount)
			throws CustomerExceptions;

	boolean validateNo(String mobileNo) throws CustomerExceptions;
}
