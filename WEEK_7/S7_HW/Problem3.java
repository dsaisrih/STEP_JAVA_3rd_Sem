abstract class Vehicle {
    abstract void dispatch();
}

class Bus extends Vehicle {
    @Override
    void dispatch() {
        System.out.println("Bus dispatched on fixed route with passenger capacity tracking.");
    }
}

class Taxi extends Vehicle {
    @Override
    void dispatch() {
        System.out.println("Taxi dispatched for door-to-door service, fare calculated by distance.");
    }
}

class Train extends Vehicle {
    @Override
    void dispatch() {
        System.out.println("Train dispatched on schedule with multiple car capacity.");
    }
}

class Bike extends Vehicle {
    @Override
    void dispatch() {
        System.out.println("Bike dispatched for short eco-friendly trips.");
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Vehicle[] fleet = { new Bus(), new Taxi(), new Train(), new Bike() };
        for (Vehicle v : fleet) v.dispatch();
    }
}
