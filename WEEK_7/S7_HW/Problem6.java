class SmartDevice {
    String id;
    public SmartDevice(String id) { this.id = id; }
    public void status() { System.out.println("Device " + id + " is online."); }
}

class SmartTV extends SmartDevice {
    public SmartTV(String id) { super(id); }
    public void changeChannel() { System.out.println("SmartTV channel changed."); }
    public void openApp() { System.out.println("SmartTV streaming app opened."); }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String id) { super(id); }
    public void setTemperature() { System.out.println("Thermostat temperature set."); }
}

class SmartSecurity extends SmartDevice {
    public SmartSecurity(String id) { super(id); }
    public void activateAlarm() { System.out.println("Security alarm activated."); }
}

class SmartKitchen extends SmartDevice {
    public SmartKitchen(String id) { super(id); }
    public void startCooking() { System.out.println("Smart kitchen started cooking recipe."); }
}

public class Problem6 {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartTV("TV1"),
            new SmartThermostat("THERMO1"),
            new SmartSecurity("SEC1"),
            new SmartKitchen("KITCHEN1")
        };

        for (SmartDevice device : devices) {
            device.status();

            if (device instanceof SmartTV) ((SmartTV) device).openApp();
            else if (device instanceof SmartThermostat) ((SmartThermostat) device).setTemperature();
            else if (device instanceof SmartSecurity) ((SmartSecurity) device).activateAlarm();
            else if (device instanceof SmartKitchen) ((SmartKitchen) device).startCooking();
        }
    }
}
