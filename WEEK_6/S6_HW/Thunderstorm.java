public class Thunderstorm extends Storm {
    public Thunderstorm() {
        super();
        System.out.println("Thunderstorm constructor");
    }
    @Override
    public void forecast() {
        System.out.println("Thunderstorm with lightning");
    }
}