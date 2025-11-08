// Vehicle.java
abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    abstract void startEngine();
}

// Interface
interface Maintainable {
    void serviceInfo();
}

// Car class
class Car extends Vehicle implements Maintainable {

    public Car(int speed, String fuelType) {
        super(speed, fuelType);
    }

    @Override
    void startEngine() {
        System.out.println("Car engine started with " + fuelType + " fuel at speed " + speed + " km/h.");
    }

    @Override
    public void serviceInfo() {
        System.out.println("Car requires service every 6 months or 5000 km.");
    }

    public static void main(String[] args) {
        Car car = new Car(120, "Petrol");
        car.startEngine();
        car.serviceInfo();
    }
}
