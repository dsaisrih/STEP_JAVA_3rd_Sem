// File: PhoneSmartPhoneDemo.java
class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor: " + brand + " " + model);
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, String model, String os) {
        super(brand, model);               // call parent constructor
        this.operatingSystem = os;
        System.out.println("SmartPhone constructor: " + os);
    }
}

public class PhoneSmartPhoneDemo {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("Samsung", "S25", "Android");
        System.out.println(sp.brand + " " + sp.model);
    }
}
