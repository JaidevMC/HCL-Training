package com.hcl.oop.model;

public class ParentAccount {

    protected String bankName;

    public ParentAccount(String bankName) {
        this.bankName = bankName;
    }

    public void displayBank() {
        System.out.println("Bank: " + bankName);
    }
}