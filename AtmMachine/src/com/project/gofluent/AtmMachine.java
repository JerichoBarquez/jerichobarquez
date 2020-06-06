package com.project.gofluent;

import java.util.Scanner;

/**
* An ATM machine allows a user to deposit and withdraw cash. 
* It also allows a user to check their balance.
*
*/
public class AtmMachine {

	private static Scanner input;
	private static double balance = 0;
	private static String transcation;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		transactions();
	}
	
	public static void transactions() {
		int var = 0;
		System.out.println("Please select an option.");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Balance");
		var = input.nextInt();
		switch (var) {
		case 1:
			double withdraw;
			System.out.printf("Enter the amount to withdraw: ");
			withdraw = input.nextDouble();
			if (withdraw > balance || withdraw == 0) {
				System.out.println("You have insufficient balance.\n\n");
				nextTransaction();
			}
			else {
				balance = balance - withdraw;
				System.out.println("You have withdrawn " + withdraw + ".");
				System.out.println("New balance is " + balance + ".\n\n");
				nextTransaction();
			}
			break;
		case 2:
			double deposit;
			System.out.println("Enter the amount for Deposit");
			deposit = input.nextDouble();
			balance = deposit + balance;
			
			System.out.println("Deposit completed!\n\n");
			nextTransaction();
			break;
		case 3:
			System.out.println("Your current balance is " + balance + "\n\n");
			nextTransaction();
			break;
		default:
			break;
		}
		
	}
	
	public static void nextTransaction() {
		System.out.println("Do you want another transaction?");
		System.out.println("Press Y to proceed. Press N to EXIT.");
		transcation = input.next();
		if (transcation.equalsIgnoreCase("Y")) {
			transactions();
		}
		else if (transcation.equalsIgnoreCase("N")){
			System.out.println("Transaction ended. Come again...Thank you!");
		}
		else {
			System.out.println("You entered wrong command. Please enter again.");
			nextTransaction();
		}
	}

}
