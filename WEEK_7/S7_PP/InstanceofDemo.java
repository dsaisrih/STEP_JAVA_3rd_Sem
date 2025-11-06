class Payment {
    void process() {
        System.out.println("Processing generic payment...");
    }
}

class CreditCardPayment extends Payment {
    void payWithCard() {
        System.out.println("Payment done using Credit Card");
    }
}

public class InstanceofDemo {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment();

        if (p instanceof CreditCardPayment) {
            CreditCardPayment cc = (CreditCardPayment) p; // Safe downcast
            cc.payWithCard();
        } else {
            System.out.println("Not a CreditCardPayment type");
        }
    }
}
