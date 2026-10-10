class CashPayment extends Payment {

    @Override
    void pay(double amount) {
        System.out.println("Paid by Cash: " + amount);
    }
}