package com.cg.pp.dao;

import java.util.HashMap;

import com.cg.pp.beans.Customer;
import com.cg.pp.exceptions.CustomerExceptions;

public interface AccountDao {
	Customer createAccount(Customer customer);


	HashMap<Integer, String> printTransactions() throws CustomerExceptions;
	double showBalance(String mobileNumber) throws CustomerExceptions;


	Customer transfer(String mob1, String mob2, double amount) throws CustomerExceptions;

	double deposit(String mobileNumber, double amount) throws CustomerExceptions;

	double withdraw(String mobileNumber, double amount) throws CustomerExceptions;

}
