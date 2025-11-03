import java.time.LocalDateTime;
import java.util.*;

// a. Immutable Product class
final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String productId, String name, String category, String manufacturer,
                    double basePrice, double weight, String[] features, Map<String, String> specifications) {
        if (productId == null || name == null || category == null || manufacturer == null) {
            throw new IllegalArgumentException("Invalid product data");
        }
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = features.clone();
        this.specifications = new HashMap<>(specifications);
    }

    public static Product createElectronics(String id, String name, String manufacturer, double price) {
        return new Product(id, name, "Electronics", manufacturer, price, 1.0,
                new String[]{"Warranty", "Certified"}, Map.of("Voltage", "220V"));
    }

    public static Product createClothing(String id, String name, String manufacturer, double price) {
        return new Product(id, name, "Clothing", manufacturer, price, 0.5,
                new String[]{"Washable", "Comfort Fit"}, Map.of("Material", "Cotton"));
    }

    public static Product createBooks(String id, String name, String manufacturer, double price) {
        return new Product(id, name, "Books", manufacturer, price, 0.3,
                new String[]{"Paperback", "English"}, Map.of("Pages", "300"));
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        return switch (region) {
            case "US" -> basePrice * 0.07;
            case "EU" -> basePrice * 0.20;
            default -> basePrice * 0.10;
        };
    }

    @Override
    public String toString() {
        return "Product{" + name + ", category=" + category + ", price=" + basePrice + "}";
    }
}

// b. Customer class
class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private final String accountCreationDate;

    public Customer(String id, String email, String name) {
        this.customerId = id;
        this.email = email;
        this.name = name;
        this.accountCreationDate = LocalDateTime.now().toString();
    }

    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getPreferredLanguage() { return preferredLanguage; }
    public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }
    public String getAccountCreationDate() { return accountCreationDate; }

    String getCreditRating() { return "Good"; } // package-private

    public String getPublicProfile() {
        return "Customer: " + name + " (Joined: " + accountCreationDate + ")";
    }

    @Override
    public String toString() {
        return "Customer{" + name + ", email=" + email + "}";
    }
}

// c. ShoppingCart class
class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private final List<Object> items;
    private double totalAmount;
    private int itemCount;

    public ShoppingCart(String cartId, String customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.items = new ArrayList<>();
    }

    public boolean addItem(Object product, int quantity) {
        if (product instanceof Product p) {
            items.add(p);
            itemCount += quantity;
            totalAmount += (p.getBasePrice() * quantity) - calculateDiscount();
            return true;
        }
        return false;
    }

    private double calculateDiscount() {
        return itemCount > 5 ? 10.0 : 0.0;
    }

    String getCartSummary() {
        return "Cart: " + cartId + " | Items: " + itemCount + " | Total: $" + totalAmount;
    }
}

// d. Order related classes
class Order {
    private final String orderId;
    private final LocalDateTime orderTime;

    public Order(String id) {
        this.orderId = id;
        this.orderTime = LocalDateTime.now();
    }

    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderTime() { return orderTime; }

    @Override
    public String toString() {
        return "Order{" + orderId + ", time=" + orderTime + "}";
    }
}

class PaymentProcessor {
    private final String processorId;
    private final String securityKey;

    public PaymentProcessor(String id, String key) {
        this.processorId = id;
        this.securityKey = key;
    }

    public boolean processPayment(double amount) {
        return amount > 0;
    }
}

class ShippingCalculator {
    private final Map<String, Double> shippingRates;

    public ShippingCalculator(Map<String, Double> rates) {
        this.shippingRates = new HashMap<>(rates);
    }

    public double calculateShipping(String region, double weight) {
        return shippingRates.getOrDefault(region, 5.0) * weight;
    }
}

// e. Final ECommerceSystem class
final class ECommerceSystem {
    private static final Map<String, Object> productCatalog = new HashMap<>();

    public static boolean processOrder(Object order, Object customer) {
        return (order instanceof Order) && (customer instanceof Customer);
    }

    public static void addProduct(Product product) {
        productCatalog.put(product.getProductId(), product);
    }

    public static Map<String, Object> getProductCatalog() {
        return new HashMap<>(productCatalog);
    }
}

// f. Demo Main
public class ECommerceSystemDemo {
    public static void main(String[] args) {
        Product laptop = Product.createElectronics("P100", "Laptop", "Dell", 1200.0);
        Product tshirt = Product.createClothing("P200", "T-Shirt", "Nike", 40.0);
        Product book = Product.createBooks("P300", "Java Basics", "O'Reilly", 25.0);

        Customer customer = new Customer("C101", "john@example.com", "John Doe");
        ShoppingCart cart = new ShoppingCart("CART1", customer.getCustomerId());

        cart.addItem(laptop, 1);
        cart.addItem(tshirt, 2);
        cart.addItem(book, 3);

        System.out.println(cart.getCartSummary());

        Order order = new Order("O5001");
        PaymentProcessor payment = new PaymentProcessor("PAY1", "SEC123");
        ShippingCalculator shipping = new ShippingCalculator(Map.of("US", 10.0, "EU", 15.0));

        boolean paymentStatus = payment.processPayment(1305.0);
        double shippingCost = shipping.calculateShipping("US", laptop.getWeight() + tshirt.getWeight());

        System.out.println("Payment status: " + paymentStatus);
        System.out.println("Shipping cost: " + shippingCost);
        System.out.println("Order processed: " + ECommerceSystem.processOrder(order, customer));
    }
}
