public class WeatherTest {
    public static void main(String[] args) {
        Weather[] arr = {
            new Thunderstorm(),
            new Sunshine(),
            new Storm()
        };
        System.out.println("---- Forecasts ----");
        for (Weather w : arr) {
            w.forecast();
        }
    }
}