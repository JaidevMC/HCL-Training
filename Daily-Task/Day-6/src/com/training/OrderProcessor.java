
package com.training;

public class OrderProcessor {

    private int stock = 10;

    public void processOrder(int quantity)
            throws InsufficientStockException {

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero"
            );
        }

        try {
            if (quantity > stock) {
                throw new InsufficientStockException(
                    "Not enough stock available"
                );
            }

            stock = stock - quantity;
            System.out.println("Order successful!");
            System.out.println("Remaining stock: " + stock);

        } catch (InsufficientStockException e) {
            throw new InsufficientStockException(
                "Order failed while checking stock", e
            );
        } finally {
            System.out.println("Order audit completed.");
        }
    }
}