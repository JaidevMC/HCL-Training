class CardPayment extends Payment implements Refundable {

    @Override
    void pay(double amount) {
        System.out.println("Paid by Card: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Card refund: " + amount);
    }
}