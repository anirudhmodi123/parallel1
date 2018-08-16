package com.cg.pp.junittest;

import static org.junit.Assert.*;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.AccountService;
import com.cg.pp.service.AccountServiceImpl;

public class TestWithdraw {

	AccountService wssr = new AccountServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("test withdraw correct");
		String mobileno = "8858876567";
		double amount = 100;
		try {
			assertEquals(8.0, wssr.withdraw(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}



	@org.junit.Test
	public void testWrongAmount() {
		System.out.println("test transaction wrong amount");
		String mobileno = "8858876567";
		double amount = 600;
		try {
			assertEquals(new CustomerExceptions(), wssr.withdraw(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongAccount() {
		System.out.println("test withdraw wrong account");
		String mobileno = "8858876565";
		double amount = 100;
		try {
			assertEquals(new CustomerExceptions(), wssr.withdraw(mobileno, amount));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
