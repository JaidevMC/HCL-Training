package com.hcl.oop.app;

import com.hcl.oop.model.BankAccount;
import com.hcl.oop.service.BankService;
import com.hcl.oop.model.SavingsAccount;
import com.hcl.oop.model.AccessDemo;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("Jaidev", 5000);

        BankService service = new BankService();

        service.deposit(account, 1000);

        service.withdraw(account, 2000);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: " + account.getBalance());
        SavingsAccount savings = new SavingsAccount("HCL Bank", 6.5);
        savings.displayDetails();
        AccessDemo demo = new AccessDemo();
        demo.showValues();
    }
}   