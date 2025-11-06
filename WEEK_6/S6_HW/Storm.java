public class Storm extends Weather {
    public Storm() {
        super();
        System.out.println("Storm constructor");
    }
    @Override
    public void forecast() {
        System.out.println("Stormy weather");
    }
}