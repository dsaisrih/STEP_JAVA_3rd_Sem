public class Light {
    private int watt;
    private String color;

    // No-arg constructor
    public Light() {
        this(60); // chain to 1-arg constructor
        System.out.println("Light(): default constructor");
    }

    // One-arg constructor
    public Light(int watt) {
        this(watt, "White"); // chain to 2-arg constructor
        System.out.println("Light(int): sets watt");
    }

    // Two-arg constructor
    public Light(int watt, String color) {
        this.watt = watt;
        this.color = color;
        System.out.println("Light(int,String): sets watt & color");
    }
}
