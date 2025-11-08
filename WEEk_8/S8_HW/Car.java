class Car extends Vehicle implements Fuel {
    @Override
    void start() {
        System.out.println("Car started with ignition key.");
    }

    @Override
    public void refuel() {
        System.out.println("Car is refueled with petrol.");
    }
}
