package com.cg.pp.pl;

import java.util.Scanner;

import com.cg.pp.beans.*;
import com.cg.pp.exceptions.CustomerExceptions;
import com.cg.pp.service.*;

public class Client {

	public static void main(String[] args) {
		AccountService pssr = new AccountServiceImpl();
		Scanner scanner = new Scanner(System.in);
		int ch;
		do {
			String name, mobileNumber;
			double balance, amount;
			int accountNumber;
			System.out
					.println("Menu \n1. Create Account \n2.Add balance  \n3. Show balance \n4. Withdraw money \n5. Transfer money \n6. Transaction history \n7. Exit");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter fist name  :");
				String firstName = scanner.next();
				System.out.println("Enter last name  :");
				String lastName = scanner.next();
				name = firstName + " " + lastName;
				System.out.println("Enter mobile number");
				mobileNumber = scanner.next();
				System.out.println("Enter initial balance to be filled");
				balance = scanner.nextDouble();
				System.out.println("Enter account no.");
				accountNumber = scanner.nextInt();
				Customer cust = new Customer(name, mobileNumber, new Account(
						balance, accountNumber));
				try {
					if (pssr.validateCustomer(cust)) {
						System.out.println("Account created. Details: \n"
								+ pssr.createAccount(cust));
					} else
						break;
				} catch (CustomerExceptions e1) {
					System.out.println(e1.getMessage());
					break;
				}
				break;
				
			case 2:
				
				System.out.println("Enter mobile number: ");
				mobileNumber = scanner.next();
				System.out.println("Enter amount ");
				amount = scanner.nextDouble();
				try {
					if (pssr.validateNo(mobileNumber, amount)) {// validates
																// mobile no and
						// amount otherwise
						// throws exception

						if (pssr.showBalance(mobileNumber) != -1) {
							pssr.deposit(mobileNumber, amount);
							System.out.println("Rs. " + amount
									+ " successfully deposited");
						} else {
							System.out
									.println("ERROR: Cannot Recharge Account as Given account Does Not Exists");
						}

					}

				} catch (CustomerExceptions e1) {
					System.out.println(e1.getMessage());
				}
				break;
				
				
				
			
			case 3:
				System.out.println("Enter mobile number: ");
				mobileNumber = scanner.next();
				try {
					if (pssr.validateNo(mobileNumber)) {// checks mobile no for
														// 10 digits
						// otherwise throws exception

						if (pssr.showBalance(mobileNumber) != -1) {

							System.out.println("balance : "
									+ pssr.showBalance(mobileNumber));
						}

						else {
							System.out
									.println("ERROR : Given Account Does Not exists");
						}

					}
				} catch (CustomerExceptions e1) {
					System.out.println(e1.getMessage());
				}
				break;
				
			case 4:
				System.out.println("Enter mobile number: ");
				mobileNumber = scanner.next();
				System.out.println("Enter amount to be withdrawn: ");
				amount = scanner.nextDouble();
				try {
					if (pssr.validateNo(mobileNumber, amount)) {
						if (pssr.showBalance(mobileNumber) != -1) {
					pssr.withdraw(mobileNumber, amount);
					System.out.println("Rs. " + amount
							+ " successfully withdrawn");
				} else {
					System.out
					.println("ERROR:  Given Account Does Not exists");
		}

	}

} catch (CustomerExceptions e1) {
	System.out.println(e1.getMessage());
}
break;
			
			
			case 5:
				System.out.println("Enter mobile number: ");
				String mob1 = scanner.next();
				System.out.println("Enter number to send money: ");
				String mob2 = scanner.next();
				System.out.println("Enter amount to be sent: ");
				amount = scanner.nextDouble();
				try {
					pssr.transfer(mob1, mob2, amount);
					System.out.println("Rs. " + amount
							+ " successfully transferred to " + mob2);
				} catch (CustomerExceptions e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 6:
				try {
					System.out.println(pssr.printTransactions());
				} catch (CustomerExceptions e1) {
					System.out.println(e1.getMessage());
				}
			default:
				System.out.println("thanks for using the app");
				break;
			}
		} while (ch != 9);
		scanner.close();
	}
}