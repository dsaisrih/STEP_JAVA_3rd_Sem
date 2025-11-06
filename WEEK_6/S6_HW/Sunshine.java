public class Sunshine extends Weather {
    public Sunshine() {
        super();
        System.out.println("Sunshine constructor");
    }
    @Override
    public void forecast() {
        System.out.println("Bright and sunny");
    }
}