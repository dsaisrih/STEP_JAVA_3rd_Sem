public interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}
public class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund " + amount + " to Credit Card");
    }
}
public class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund " + amount + " to UPI");
    }
}
public class PaymentTest {
    public static void main(String[] args) {
        // PaymentGateway reference -> CreditCardPayment
        PaymentGateway p1 = new CreditCardPayment();
        p1.pay(5000);
        p1.refund(2000);

        // PaymentGateway reference -> UPIPayment
        PaymentGateway p2 = new UPIPayment();
        p2.pay(1500);
        p2.refund(500);
    }
}
