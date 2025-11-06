// File: Vehicle.java
import java.util.Random;

public class Vehicle {
    // 🔹 Protected fields (accessible to subclasses)
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // 🔹 Private fields (encapsulation)
    private String registrationNumber;
    private boolean isRunning;

    // 🔹 Default constructor
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // 🔹 Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // 🔹 Vehicle operations
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
                ", Engine: " + engineType + ", Registration: " + registrationNumber +
                ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
    }

    // 🔹 Getter/Setter for private fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }

    // 🔹 Helper method
    private String generateRegistrationNumber() {
        Random rand = new Random();
        return "REG" + (1000 + rand.nextInt(9000));
    }
}
// File: Car.java
