package com.hcl.oop.model;

public class SavingsAccount extends ParentAccount {

    private double interestRate;

    public SavingsAccount(String bankName, double interestRate) {
        super(bankName);
        this.interestRate = interestRate;
    }

    public void displayDetails() {
        super.displayBank();
        System.out.println("Interest Rate: " + interestRate);
    }
}