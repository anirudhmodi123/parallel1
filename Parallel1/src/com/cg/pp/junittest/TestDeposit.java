package com.cg.pp.junittest;

import static org.junit.Assert.*;

import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.AccountService;
import com.cg.pp.service.AccountServiceImpl;

public class TestDeposit {

	AccountService wssr = new AccountServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test deposit correct");
		
		double amount = 100.0;
		String mobileNumber = "9897782078";
		try {
			assertEquals(606.0, wssr.deposit(mobileNumber, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}



	@org.junit.Test
	public void testWrongAmount() {
		System.out.println("test deposit wrong balance");
		
		double amount = -100;
		String mobileNumber = "9897782078";
		try {
			assertEquals(new CustomerExceptions(), wssr.deposit(mobileNumber, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}
	@org.junit.Test
	public void testWrong() {
		System.out.println("From test deposit wrong number");
		
		double amount = 100;
		String mobileNumber = "9897782076";
		try {
			assertEquals(new CustomerExceptions(), wssr.deposit(mobileNumber, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}
}
