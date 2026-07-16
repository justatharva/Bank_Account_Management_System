package com.main;
import java.util.*;
//---------------------Interface Declartion---------------------
interface Transactions{
	void deposit(double amount, int number);
	void withdraw(double amount, int number);
	void displayBalance(int number);
}

//---------------------Class which implements transaction interface---------------------
abstract class BankAccount implements Transactions{
	private double savbalance;
	private double currbalance;
	
//---------------------Deposit Method---------------------
	public void deposit(double amount, int number) {
		if(number == 1) {			
			savbalance += amount;
			System.out.println("Rs. "+amount+" Credited to Ac.XXXXXX3536");
		}
		else {
			currbalance += amount;
			System.out.println("Rs. "+amount+" Credited to Ac.XXXXXX3536");
		}
	}
	
//---------------------Withdraw Method---------------------
	public void withdraw(double amount, int number) {
		if(number == 1) {
			if(savbalance - amount<1000) {
				System.out.println("You have reach the minimum balance limit");
				displayBalance(number);
			}
			else {
				savbalance -= amount;
				System.out.println("Rs. "+amount+" Debited from Ac.XXXXXX3536");
			}
		}
		else {
			if(currbalance - amount<5000) {
				System.out.println("You have reach the minimum balance limit");
				displayBalance(number);
			}
			else {
				currbalance -= amount;
				System.out.println("Rs. "+amount+" Debited from Ac.XXXXXX3536");
			}
		}
		
	}
	
//---------------------Balance Display Method---------------------
	public void displayBalance(int number) {
		if(number==1) {
			System.out.println("Dear Ac. Holder Your Saving Account Balance is Rs. "+savbalance);
		}
		else {
			System.out.println("Dear Ac. Holder Your Current Account Balance is Rs. "+currbalance);
		}
	}
}

//---------------------Choose Account Type---------------------
class AccountType extends BankAccount{
	public void accountType(int number, Scanner sc) {
		if(number == 1) {
			System.out.println("Welcome to Saving Account");
			displayMenu(number);
		}
		else if(number == 2) {
			System.out.println("Welcome to Current Account");
			displayMenu(number);
		}
		else {
			System.err.println("Invalid Choice!!");
			System.out.println("Choose Your Account Type : ");
			number = sc.nextInt();
			accountType(number, sc);
		}
	}
	
//---------------------Account Choosing Method---------------------
	public void account(Scanner sc) {
		
		int amount,number;
		System.out.println("---------->Indian Bank<----------");
		System.out.println("1.Saving Account");
		System.out.println("2.Current Account");
		System.out.print("Choose Your Account Type : ");
		number = sc.nextInt();
		accountType(number,sc);
	}
	
//---------------------Operational Dashboard---------------------
	public void displayMenu(int number) {
		Scanner sc = new Scanner(System.in);
		int amount;
		// Main Dashboard
				outerLoop: 
				while(true) {
					System.out.println("---------->Indian Bank<----------");
					System.out.println("1. Deposit Amount");
					System.out.println("2. Withdraw Amount");
					System.out.println("3. Check Balance");
					System.out.println("4. Exit");
					System.out.println("Enter Your Choice : ");
					int ch = sc.nextInt();
					
					switch(ch) {
					case 1:
						System.out.println("Enter Amount : ");
						amount = sc.nextInt();
						deposit(amount,number);
						break;
					case 2:
						System.out.println("Enter Amount : ");
						amount = sc.nextInt();
						withdraw(amount,number);
						break;
					case 3:
						displayBalance(number);
						break;
					case 4:
						System.out.println("Thank You.... Visit Again");
						break outerLoop;
					}
				}
	}
}

//---------------------Main Class---------------------
public class BankTranscations{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountType bank = new AccountType();
		bank.account(sc);
	}

}
