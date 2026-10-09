abstract class Payment {

    abstract void pay(double amount);

    void pay(double amount, String currency) {
        System.out.println("Amount: " + amount + " " + currency);
    }
}