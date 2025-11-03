package pets;

/**
 * Specialized Robot Pet class using composition.
 */
public class RobotPet {
    private boolean needsCharging;
    private int batteryLevel;
    private final VirtualPet corePet;

    public RobotPet(String name) {
        this.needsCharging = false;
        this.batteryLevel = 100;
        this.corePet = new VirtualPet(name, new PetSpecies("Robot",
                VirtualPet.DEFAULT_EVOLUTION_STAGES, 500, "Laboratory"));
    }

    public boolean isNeedsCharging() { return needsCharging; }
    public void setNeedsCharging(boolean needsCharging) { this.needsCharging = needsCharging; }

    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0) batteryLevel = 0;
        if (batteryLevel > 100) batteryLevel = 100;
        this.batteryLevel = batteryLevel;
    }

    public VirtualPet getCorePet() { return corePet; }

    @Override
    public String toString() {
        return "RobotPet{" + "battery=" + batteryLevel +
                "%, needsCharging=" + needsCharging +
                ", core=" + corePet + "}";
    }
}
