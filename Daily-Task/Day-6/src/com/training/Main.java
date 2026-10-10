
package com.training;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderProcessor processor = new OrderProcessor();

        while (true) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1. Place Order");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 2) {
                    System.out.println("Exiting program...");
                    break;
                }

                if (choice == 1) {
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    processor.processOrder(quantity);

                } else {
                    System.out.println("Invalid menu choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");

            } catch (InsufficientStockException |
                     InvalidQuantityException e) {
                System.out.println("Order error: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Program ended.");
    }
}