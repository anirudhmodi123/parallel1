
package com.cg.pp.junittest;

import static org.junit.Assert.*;
import com.cg.pp.beans.Customer;
import com.cg.pp.beans.Account;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.AccountService;
import com.cg.pp.service.AccountServiceImpl;

public class TestValidate {

	AccountService wssr = new AccountServiceImpl();

	@org.junit.Test
	public void testCorrect() {
		System.out.println(" test customer correct");
		Customer c = new Customer("AnirudhModi", "1023456789", new Account(600.0,323));
		try {
			assertEquals(true, wssr.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	

	@org.junit.Test
	public void testWrongNumber() {
		System.out.println(" test customer wrong number");
		Customer c = new Customer("AnirudhModi", "10345", new Account(600.0,323));
		try {
			assertEquals(new CustomerExceptions(), wssr.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}
	@org.junit.Test
	public void testWrongName() {
		System.out.println(" test customer wrong name");
		Customer c = new Customer("AnirudhModi103", "10234567890", new Account(600.0,323));
		try {
			assertEquals(new CustomerExceptions(), wssr.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrongBalance() {
		System.out.println("From test customer wrong balance");
		Customer c = new Customer("AnirudhModi", "1023456789", new Account(-600.0,323));
		try {
			assertEquals(new CustomerExceptions(), wssr.validateCustomer(c));
		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
