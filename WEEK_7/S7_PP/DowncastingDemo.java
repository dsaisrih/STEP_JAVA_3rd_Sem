class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}

class Car extends Vehicle {
    void openRoof() {
        System.out.println("Car's roof opened");
    }
}

public class DowncastingDemo {
    public static void main(String[] args) {
        Vehicle v = new Car(); // Upcasting
        v.start();

        // Downcasting back to Car
        Car c = (Car) v;
        c.openRoof();
    }
}
