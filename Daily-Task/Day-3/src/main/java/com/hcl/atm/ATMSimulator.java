package com.hcl.atm;

import java.util.Scanner;

public class ATMSimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int correctPin = 1234;
        int attempts = 0;
        boolean loggedIn = false;

        // 3 PIN attempts
        while (attempts < 3) {

            System.out.print("Enter PIN: ");

            String pinInput = scanner.nextLine();

            if (!pinInput.matches("\\d+")) {
                System.out.println("Invalid PIN. Enter numbers only.");
                continue;
            }

            int pin = Integer.parseInt(pinInput);

            if (pin == correctPin) {
                loggedIn = true;
                System.out.println("Login successful.");
                break;
            } else {
                attempts++;
                System.out.println("Invalid PIN.");

                if (attempts < 3) {
                    System.out.println("Try again.");
                    continue;
                }
            }
        }

        if (!loggedIn) {
            System.out.println("Maximum attempts reached. Account locked.");
            scanner.close();
            return;
        }

        int balance = 10000;
        boolean running = true;

        do {

            System.out.println();
            System.out.println("===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choiceInput = scanner.nextLine();

            if (!choiceInput.matches("\\d+")) {
                System.out.println("Invalid choice. Enter a number from 1 to 5.");
                continue;
            }

            int choice = Integer.parseInt(choiceInput);

            switch (choice) {

                case 1:
                    System.out.println("Balance: " + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");

                    String depositInput = scanner.nextLine();

                    if (!depositInput.matches("\\d+")) {
                        System.out.println("Invalid amount.");
                        continue;
                    }

                    int deposit = Integer.parseInt(depositInput);

                    if (deposit <= 0) {
                        System.out.println("Invalid amount.");
                        continue;
                    }

                    balance = balance + deposit;
                    System.out.println("Deposit successful.");
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");

                    String withdrawInput = scanner.nextLine();

                    if (!withdrawInput.matches("\\d+")) {
                        System.out.println("Invalid amount.");
                        continue;
                    }

                    int withdraw = Integer.parseInt(withdrawInput);

                    if (withdraw <= 0) {
                        System.out.println("Invalid amount.");
                        continue;
                    }

                    if (withdraw > balance) {
                        System.out.println("Insufficient balance.");
                        continue;
                    }

                    balance = balance - withdraw;
                    System.out.println("Withdrawal successful.");
                    break;

                case 4:

                    int[] transactions = {1000, -500, 2000, -300};

                    System.out.println("Mini Statement:");

                    for (int transaction : transactions) {
                        System.out.println(transaction);
                    }

                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Enter 1 to 5.");
                    continue;
            }

        } while (running);

        scanner.close();
    }
}