package com.cg.pp.service;

import java.util.HashMap;





import com.cg.pp.beans.Customer;
import com.cg.pp.dao.*;
import com.cg.pp.exceptions.*;

public class AccountServiceImpl implements AccountService {

	public AccountServiceImpl() {

	}

	AccountDao wssr = new AccountDaoImpl();

	@Override
	public Customer createAccount(Customer customer) {
		return wssr.createAccount(customer);
	}


	@Override
	public double withdraw(String mobileNumber, double amount) throws CustomerExceptions {
		return wssr.withdraw(mobileNumber, amount);
	}
	
	@Override
	public double deposit(String mobileNumber, double amount) throws CustomerExceptions {
		return wssr.deposit(mobileNumber, amount);
	}


	
	@Override
	public double showBalance(String mobileNumber) throws CustomerExceptions {
		return wssr.showBalance(mobileNumber);
	}
	

	@Override
	public Customer transfer(String mob1, String mob2, double amount) throws CustomerExceptions {
		return wssr.transfer(mob1, mob2, amount);

	}

	

	@Override
	public HashMap<Integer, String> printTransactions() throws CustomerExceptions {
		return wssr.printTransactions();
	}
	@Override
	public boolean validateNo(String mobileNumber, double amount)//validates no. and amount
			throws CustomerExceptions {
		if (!mobileNumber.matches("[0-9]{10}"))
			throw new CustomerExceptions("Enter valid phone No.");
		if (amount <= 0) {
			throw new CustomerExceptions(
					"The recharge amount should be a positive value");
		}

		else {
			return true;
		}
	}
	@Override
	public boolean validateCustomer(Customer customer) throws CustomerExceptions {
		if (!customer.getName().matches("[A-Za-z ]{1,50}")) {
			throw new CustomerExceptions("ERROR: Your name should be alphabetical in nature and less than 50 characters long.");
		}
		if (customer.getAccount().getBalance()<0) {
			throw new CustomerExceptions("ERROR: Balance should be non negative");
		}
		if (!customer.getMobileNumber().matches("[0-9]{10}")) {
			throw new CustomerExceptions("ERROR: Mobile number should have 10 digits");
		}
		 else {
			return true;
		}
	}

	@Override
	public boolean validateNo(String mobileNumber) throws CustomerExceptions {//validates no.
		if (!mobileNumber.matches("[0-9]{10}"))
			throw new CustomerExceptions("Enter valid phone No.");
		else {
			return true;
		}
	}


}
