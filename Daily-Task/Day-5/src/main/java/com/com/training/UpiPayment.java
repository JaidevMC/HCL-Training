class UpiPayment extends Payment {

    @Override
    void pay(double amount) {
        System.out.println("Paid by UPI: " + amount);
    }
}