package com.hcl.oop.model;

public class BankAccount {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    private static int accountCounter = 0;

    // Constructor 1
    public BankAccount() {
        this("Unknown", 0);
    }

    // Constructor 2
    public BankAccount(String accountHolder) {
        this(accountHolder, 0);
    }

    // Constructor 3
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountNumber = ++accountCounter;
    }

    // Deposit
    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be greater than 0"
            );
        }

        balance += amount;
    }

    // Withdraw
    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than 0"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance"
            );
        }

        balance -= amount;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        BankAccount other = (BankAccount) obj;

        return accountNumber == other.accountNumber;
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Integer.hashCode(accountNumber);
    }
}