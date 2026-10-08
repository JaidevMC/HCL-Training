package com.hcl.oop.service;

import com.hcl.oop.model.BankAccount;

public class BankService {

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }
}