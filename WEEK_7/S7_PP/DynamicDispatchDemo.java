class FoodDelivery {
    void deliver() {
        System.out.println("Delivering generic food...");
    }
}

class PizzaDelivery extends FoodDelivery {
    @Override
    void deliver() {
        System.out.println("Delivering Pizza...");
    }
}

class BurgerDelivery extends FoodDelivery {
    @Override
    void deliver() {
        System.out.println("Delivering Burger...");
    }
}

public class DynamicDispatchDemo {
    public static void main(String[] args) {
        FoodDelivery delivery;

        delivery = new PizzaDelivery(); // reference type is FoodDelivery
        delivery.deliver();             // runtime → PizzaDelivery

        delivery = new BurgerDelivery();
        delivery.deliver();             // runtime → BurgerDelivery
    }
}
