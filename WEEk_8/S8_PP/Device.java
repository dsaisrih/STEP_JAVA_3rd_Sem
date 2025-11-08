// Device.java
abstract class Device {
    protected String brand;
    protected String model;

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    abstract void powerOn();
}

// Interface
interface Connectable {
    void connect();
}

// Smartphone class
class Smartphone extends Device implements Connectable {

    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    void powerOn() {
        System.out.println("Smartphone " + brand + " " + model + " is powering on...");
    }

    @Override
    public void connect() {
        System.out.println("Smartphone connected to Wi-Fi and Mobile Network.");
    }

    public static void main(String[] args) {
        Smartphone s = new Smartphone("Samsung", "Galaxy S23");
        s.powerOn();
        s.connect();
    }
}
