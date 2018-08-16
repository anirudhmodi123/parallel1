package com.cg.pp.junittest;

import static org.junit.Assert.*;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.AccountService;
import com.cg.pp.service.AccountServiceImpl;

public class TestShow {
	AccountService wssr = new AccountServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println("test show correct");
		String mobileno = "9897782078";
		try {
			assertEquals(506.0, wssr.showBalance(mobileno));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrong() {
		System.out.println("test show correct");
		String mobileno = "9897782078";
		try {
			assertEquals(new CustomerExceptions(), wssr.showBalance(mobileno));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}
}
