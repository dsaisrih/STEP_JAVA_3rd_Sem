public class ShoppingDemo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Amit", "amit@gmail.com");

        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mouse", 500);
        Product product3 = new Product("Mobile", 15000);

        Order order1 = new Order("ORD001");
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order("ORD002");
        order2.addProduct(product3);

        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        customer1.showCustomerOrders();
    }
}