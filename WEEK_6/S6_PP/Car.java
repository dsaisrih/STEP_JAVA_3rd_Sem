public class Car extends Vehicle {
    // 🔹 Car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // 🔹 Default constructor
    public Car() {
        super(); // Explicit call to Vehicle()
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // 🔹 Parameterized constructor
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Calls Vehicle constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // 🔹 Overridden methods
    @Override
    public void start() {
        super.start(); // Call parent logic first
        System.out.println("Car-specific startup sequence: Engine roaring, systems check OK");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs(); // Show vehicle specs first
        System.out.println("Car Specs:");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    // 🔹 Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // 1. Test constructor chaining
        System.out.println("=== Testing Default Constructor ===");
        Car defaultCar = new Car();
        defaultCar.displaySpecs();

        System.out.println("\n=== Testing Parameterized Constructor ===");
        Car paramCar = new Car("Toyota", "Corolla", 2022, "Hybrid", 4, "Petrol", "Automatic");
        paramCar.displaySpecs();

        // 2. Test inherited methods
        System.out.println("\n=== Testing Inherited Methods ===");
        paramCar.start();  // overridden method
        System.out.println(paramCar.getVehicleInfo());
        paramCar.stop();

        // 3. Test car-specific methods
        System.out.println("\n=== Testing Car-specific Methods ===");
        paramCar.openTrunk();
        paramCar.playRadio();

        // 4. Test super keyword usage
        System.out.println("\n=== Testing Super Keyword ===");
        paramCar.start(); // calls Vehicle.start() first, then Car.start()
    }
}
