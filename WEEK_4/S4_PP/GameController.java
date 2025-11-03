public class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    // Default constructor
    public GameController() {
        controllerBrand = "GenericPad";
        connectionType = "USB";
        hasVibration = true;
        batteryLevel = 100;
        sensitivity = 1.0;
    }

    // Full parameterized constructor
    public GameController(String controllerBrand, String connectionType, boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = Math.max(0, Math.min(batteryLevel, 100));
        this.sensitivity = Math.max(0.1, Math.min(sensitivity, 3.0));
    }

    // Two-parameter convenience constructor
    public GameController(String brand, String connectionType) {
        this(brand, connectionType, true, 100, 1.0);
    }

    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Brand: " + controllerBrand + ", Connection: " + connectionType +
                ", Vibration: " + hasVibration + ", Battery: " + batteryLevel + "%, Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        System.out.println(hasVibration ? "*BUZZ* Vibration test successful!" : "Vibration disabled on this controller.");
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        GameController defaultController = new GameController();
        GameController customController = new GameController("ProPad", "Bluetooth", false, 85, 2.5);
        GameController quickController = new GameController("SpeedyStick", "Wireless");

        defaultController.displayConfiguration();
        defaultController.calibrateController();
        defaultController.testVibration();

        customController.displayConfiguration();
        customController.calibrateController();
        customController.testVibration();

        quickController.displayConfiguration();
        quickController.calibrateController();
        quickController.testVibration();
    }
}