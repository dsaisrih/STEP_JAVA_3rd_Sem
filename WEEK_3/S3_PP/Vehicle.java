// Base class
public class Vehicle {
    // Protected instance variables (accessible to subclasses)
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    // Constructor
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    // Common methods
    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled by " + amount + " liters.");
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Info:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel + " liters");
        System.out.println();
    }

    public static void main(String[] args) {
        // Subclasses
        class Car extends Vehicle {
            public Car(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }
        }

        class Truck extends Vehicle {
            public Truck(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }
        }

        class Motorcycle extends Vehicle {
            public Motorcycle(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }
        }

        // Creating different types of vehicles
        Vehicle v1 = new Car("Toyota", "Corolla", 2020, 40);
        Vehicle v2 = new Truck("Ford", "F-150", 2018, 60);
        Vehicle v3 = new Motorcycle("Yamaha", "MT-15", 2022, 15);

        // Array of Vehicle objects (polymorphism)
        Vehicle[] fleet = {v1, v2, v3};

        // Demonstrating polymorphic behavior
        for (Vehicle v : fleet) {
            v.startVehicle();
            v.refuel(10);
            v.displayVehicleInfo();
            v.stopVehicle();
        }

        /*
         * 💬 Explanation:
         * - Reusability: The Vehicle class defines shared behavior reused by Car, Truck, Motorcycle.
         * - Extensibility: We can easily add new vehicle types (e.g., ElectricCar, Bus) by extending Vehicle.
         * - Benefits over separate classes:
         *   - Avoids code duplication (startVehicle, stopVehicle, etc.).
         *   - Enables polymorphism (treat all as Vehicle).
         *   - Easier maintenance and scalability.
         */
    }
}