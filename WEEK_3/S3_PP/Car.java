public class Car {
    // Instance variables (attributes)
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    // Constructor to initialize all attributes
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // Default state
    }

    // Method to start the engine
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    // Method to stop the engine
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    // Method to display car information
    public void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
        System.out.println("Age: " + getAge() + " years");
        System.out.println();
    }

    // Method to calculate car age
    public int getAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }

    public static void main(String[] args) {
        // Creating 3 different Car objects with different attributes
        Car car1 = new Car("Toyota", "Camry", 2018, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2015, "Black");

        // Demonstrating method calls on each object
        car1.startEngine();
        car1.displayInfo();
        car1.stopEngine();

        car2.displayInfo(); // Engine not started yet
        car2.startEngine();
        car2.displayInfo();

        car3.startEngine();
        car3.stopEngine();
        car3.displayInfo();

        // 💬 Real-world analogy explanation:
        // Each Car object represents a unique car with its own state.
        // Just like in real life, starting one car doesn't affect another.
        // Each car maintains its own brand, model, color, and running state.
    }
}