package com.cg.pp.junittest;

import static org.junit.Assert.*;

import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.AccountService;
import com.cg.pp.service.AccountServiceImpl;

public class TestTransfer {

	AccountService wser = new AccountServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test transaction correct");
		String mob1 = "9897782078";
		String mob2 = "8858876567";
		double amount = 100;
		try {
			wser.transfer(mob1, mob2, amount);
			assertEquals(208.0, wser.showBalance(mob2));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAccount() {
		System.out.println(" test transaction wrong account");
		String mob1 = "9897782078";
		String mob2 = "123567890";
		double amount = 100;
		try {
			assertEquals(new CustomerExceptions(), wser.transfer(mob1, mob2, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAmount() {
		System.out.println("From test transaction wrong amount");
		String mob1 = "9897782078";
		String mob2 = "8858876567";
		double amount = 1200;
		try {
			assertEquals(new CustomerExceptions(), wser.transfer(mob1, mob2, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
