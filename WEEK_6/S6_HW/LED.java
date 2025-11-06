public class LED extends Light {
    private boolean dimmable;

    // No-arg constructor
    public LED() {
        this(false);
        System.out.println("LED(): default constructor");
    }

    // One-arg constructor
    public LED(boolean dimmable) {
        super(); // call parent no-arg constructor
        this.dimmable = dimmable;
        System.out.println("LED(boolean): sets dimmable");
    }

    public static void main(String[] args) {
        new LED();
        System.out.println("----------------");
        new LED(true);
    }
}