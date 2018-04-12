package edu.UMUC.CMIS242.Project2;

/**
 * File Name: Account.java
 * Name: riceak.isr
 * Date: April 8, 2018
 * Purpose: Established methods for BankGUI to manage account.
 */
public class Account {

    private double balance;

    // Default constructor for account is needed for the sub classes
    public Account() { }

    // Sets the balance of the Account
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Returns the balance of the account
    public double getBalance() {
        return this.balance;
    }

    /**
     * Sub Classes
     */

    // Subclass for Checking accounts
    public class Checking extends Account {

        public Checking() {
        }
    }

    // Subclass for Savings accounts
    public class Savings extends Account {

        public Savings() {
        }
    }

    /**
     * Methods
     */

    // Method for Withdraw action listener
    public void withdraw(double withdrawAmount) throws InsufficientFunds {

        // If the desired amount would bring balance less than 0, throws error
        if (this.balance - withdrawAmount < 0) {
            throw new InsufficientFunds();
        }

        this.balance = this.balance - withdrawAmount;
    }

    // Method for the Deposit action listener
    public void deposit(double depositAmount) {
        this.balance = this.balance + depositAmount;
    }

    // Method for the Transfer To action listener that adds amount
    public void transferTo(double transferAmount) {
        this.balance = this.balance + transferAmount;
    }

    // Method for the Transfer To action listener that removes amount
    public void transferFrom(double transferAmount) throws InsufficientFunds {
        // Checks to ensure sufficient funds
        if (this.balance - transferAmount < 0) {
            throw new InsufficientFunds();
        }

        this.balance = this.balance - transferAmount;
    }
}
