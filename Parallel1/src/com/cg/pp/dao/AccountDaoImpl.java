package com.cg.pp.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.pp.beans.Customer;
import com.cg.pp.beans.Account;
import com.cg.pp.exceptions.CustomerExceptions;

public class AccountDaoImpl implements AccountDao {
	Map<String, Customer> db = new HashMap<String, Customer>(); // Database stores customers identified bytheir
																		// mobileNumber
	HashMap<Integer, String> transactions = new HashMap<Integer, String>();
	static int id = 0;

	@Override
	public Customer createAccount(Customer customer) {
		//Adds new customer to db
		db.put(customer.getMobileNumber(), customer);
		return customer;
	}

	@Override
	public double showBalance(String mobileNumber) throws CustomerExceptions {
		// Identifies mobileNumber and prints account balance
		if (db.containsKey(mobileNumber)) {
			return db.get(mobileNumber).getAccount().getBalance();
		}
		
		return -1;
		
		
	}

	@Override
	public double deposit(String mobileNumber, double amount) throws CustomerExceptions {
		// Identifies mobileNumber and adds amount to account balance
		if (db.containsKey(mobileNumber)) {
			
				double balance = db.get(mobileNumber).getAccount().getBalance();
				balance = balance + amount;
				db.get(mobileNumber).getAccount().setBalance(balance);
				id++;
				transactions.put(id, " Deposit of Rs. " + amount + " to " + mobileNumber + ".");
				return db.get(mobileNumber).getAccount().getBalance();
			} 
			
			return -1;
			
	}

	
	

	public AccountDaoImpl() {// Enter customer data into database
	
		Customer rahul = new Customer("Rahul Rai", "9897782078", new Account(506.0,222));
		Customer mathew = new Customer("Mathew Marshal", "8858876567", new Account(108.0,233));
		Customer somesh = new Customer("Somesh Gupta", "9891172001", new Account(257.0,244));
		Customer rishab = new Customer("Rishab Nath", "9891182001", new Account(266.0,255));
		db.put(rahul.getMobileNumber(), rahul);
		db.put(mathew.getMobileNumber(), mathew);
		db.put(somesh.getMobileNumber(), somesh);
		db.put(rishab.getMobileNumber(), rishab);
	}

	
	@Override
	public double withdraw(String mobileNumber, double amount) throws CustomerExceptions {
		// Identifies mobileNumber and subtracts amount from account balance
		if (db.containsKey(mobileNumber)) {
			
				double bal = db.get(mobileNumber).getAccount().getBalance();
				if (amount < bal) {
					bal = bal - amount;
					db.get(mobileNumber).getAccount().setBalance(bal);
					id++;
					transactions.put(id, " Withdrawal of Rs. " + amount + " from " + mobileNumber + ".");
					return db.get(mobileNumber).getAccount().getBalance();
				} else {
					throw new CustomerExceptions("ERROR : Insufficient funds");
				}
		}
		return -1;
	}

	@Override
	public Customer transfer(String mob1, String mob2, double amount) throws CustomerExceptions {
		//transfers from 'mob1' to 'mob2'
		if (db.containsKey(mob1)) {
			if (db.containsKey(mob2)) {
				double balance1 = db.get(mob1).getAccount().getBalance();
				double balance2 = db.get(mob2).getAccount().getBalance();
				if (amount < balance1) {
					balance1 = balance1 - amount;
					balance2 = balance2 + amount;
					db.get(mob1).getAccount().setBalance(balance1);
					db.get(mob2).getAccount().setBalance(balance2);
					id++;
					transactions.put(id, " Transfer of Rs. " + amount + " from " + mob1 + " to " + mob2 + ".");
					return db.get(mob2);
				} else {
					throw new CustomerExceptions("ERROR: Insufficient funds ");
				}
			} else {
				throw new CustomerExceptions("ERROR: Reciever account not found");
			}
		} else {
			throw new CustomerExceptions("ERROR: Sender account not found.");
		}
	}

	@Override
	public HashMap<Integer, String> printTransactions() throws CustomerExceptions {//prints all transactions of one session
		
		if (id!=0)
			return transactions;
		else throw new CustomerExceptions("ERROR: No transactions done");
	}

}
