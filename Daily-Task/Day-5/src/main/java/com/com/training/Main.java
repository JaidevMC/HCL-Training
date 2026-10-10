public class Main {
    public static void main(String[] args) {

        Payment p1 = new CardPayment();
        Payment p2 = new UpiPayment();
        Payment p3 = new CashPayment();

        p1.pay(1000);
        p2.pay(500);
        p3.pay(200);

        p1.pay(1000, "INR");

        Refundable r = new CardPayment();
        r.refund(300);
    }
}