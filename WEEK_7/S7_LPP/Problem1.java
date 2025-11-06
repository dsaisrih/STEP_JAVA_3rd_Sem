class DeliveryCalculator {
    
    // Basic delivery: based only on distance
    public void calculateCharge(double distance) {
        double cost = distance * 5; // ₹5 per km
        System.out.println("Basic Delivery: Distance = " + distance + " km, Cost = ₹" + cost);
    }

    // Premium delivery: distance + priority fee
    public void calculateCharge(double distance, double priorityFee) {
        double cost = (distance * 5) + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + " km + Priority Fee = ₹" + priorityFee + ", Total = ₹" + cost);
    }

    // Group delivery: distance + discount for number of orders
    public void calculateCharge(double distance, int numberOfOrders) {
        double cost = distance * 5;
        double discount = numberOfOrders * 2; // ₹2 discount per order
        cost -= discount;
        System.out.println("Group Delivery: Distance = " + distance + " km, Orders = " + numberOfOrders + ", Discount = ₹" + discount + ", Total = ₹" + cost);
    }

    // Festival special: distance + discount percentage + free delivery if cost > 500
    public void calculateCharge(double distance, double discountPercent, double freeOverAmount) {
        double cost = distance * 5;
        if (cost > freeOverAmount) {
            System.out.println("Festival Special: Free Delivery! (Order above ₹" + freeOverAmount + ")");
        } else {
            double discount = (cost * discountPercent) / 100;
            cost -= discount;
            System.out.println("Festival Special: Distance = " + distance + " km, Discount = " + discountPercent + "%, Total = ₹" + cost);
        }
    }
}

public class Problem1 {
    public static void main(String[] args) {
        DeliveryCalculator dc = new DeliveryCalculator();

        dc.calculateCharge(10);                        // Basic
        dc.calculateCharge(10, 50);                    // Premium
        dc.calculateCharge(10, 3);                     // Group
        dc.calculateCharge(20, 10, 500);               // Festival
    }
}
