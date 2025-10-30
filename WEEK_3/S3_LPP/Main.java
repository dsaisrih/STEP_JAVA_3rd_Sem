class Vehicle {
    // Instance variables
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;

    // Static variables
    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName = "Default Rentals";
    private static int rentalDays = 0;

    // Constructor
    public Vehicle(String vehicleId, String brand, String model, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    // Instance method to rent vehicle
    public void rentVehicle(int days) {
        if (isAvailable) {
            double rent = calculateRent(days);
            isAvailable = false;
            System.out.println(vehicleId + " rented for " + days + " days. Rent: ₹" + rent);
        } else {
            System.out.println(vehicleId + " is currently not available.");
        }
    }

    // Instance method to return vehicle
    public void returnVehicle() {
        isAvailable = true;
        System.out.println(vehicleId + " has been returned and is now available.");
    }

    // Instance method to calculate rent and update static counters
    public double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        rentalDays += days;
        return rent;
    }

    // Instance method to display vehicle info
    public void displayVehicleInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rent per Day: ₹" + rentPerDay);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Rented"));
        System.out.println("-----------------------------");
    }

    // Static method to set company name
    public static void setCompanyName(String name) {
        companyName = name;
    }

    // Static method to get total revenue
    public static double getTotalRevenue() {
        return totalRevenue;
    }

    // Static method to get average rent per day
    public static double getAverageRentPerDay() {
        return rentalDays == 0 ? 0 : totalRevenue / rentalDays;
    }

    // Static method to display company stats
    public static void displayCompanyStats() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: ₹" + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Average Rent per Day: ₹" + getAverageRentPerDay());
        System.out.println("=============================");
    }
}
public class Main {
    public static void main(String[] args) {
        // Set company name (static)
        Vehicle.setCompanyName("ZoomGo Rentals");

        // Create vehicle objects (instance members)
        Vehicle v1 = new Vehicle("V001", "Toyota", "Innova", 1500.0);
        Vehicle v2 = new Vehicle("V002", "Honda", "City", 1200.0);
        Vehicle v3 = new Vehicle("V003", "Hyundai", "Creta", 1300.0);

        // Display individual vehicle info
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        // Rent vehicles
        v1.rentVehicle(3); // ₹4500
        v2.rentVehicle(2); // ₹2400

        // Try renting an already rented vehicle
        v1.rentVehicle(1); // Should show not available

        // Return a vehicle
        v1.returnVehicle();

        // Rent again
        v1.rentVehicle(1); // ₹1500

        // Display company stats (shared static data)
        Vehicle.displayCompanyStats();
    }
}