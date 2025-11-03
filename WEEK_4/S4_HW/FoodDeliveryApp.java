public class FoodDeliveryApp {
    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);

        o1.printBill();
        o2.printBill();
        o3.printBill();
    }
}

class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;
    static final double fixedRate = 150;

    FoodOrder() {
        foodItem = "Unknown";
        quantity = 0;
        price = 0;
    }

    FoodOrder(String foodItem) {
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = fixedRate;
    }

    FoodOrder(String foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * fixedRate;
    }

    void printBill() {
        System.out.println("Item: " + foodItem + ", Quantity: " + quantity +
                           ", Total Price: ₹" + price);
    }
}