class SmartDevice {
    String deviceId;

    public SmartDevice(String deviceId) {
        this.deviceId = deviceId;
    }

    public void status() {
        System.out.println("Device " + deviceId + " is active.");
    }
}

class SmartClassroom extends SmartDevice {
    public SmartClassroom(String deviceId) {
        super(deviceId);
    }

    public void controlAC() {
        System.out.println("Classroom AC controlled.");
    }

    public void controlLighting() {
        System.out.println("Classroom lights adjusted.");
    }

    public void controlProjector() {
        System.out.println("Projector switched on.");
    }
}

class SmartLab extends SmartDevice {
    public SmartLab(String deviceId) {
        super(deviceId);
    }

    public void manageEquipment() {
        System.out.println("Lab equipment managed.");
    }

    public void safetySystem() {
        System.out.println("Lab safety system activated.");
    }
}

class SmartLibrary extends SmartDevice {
    public SmartLibrary(String deviceId) {
        super(deviceId);
    }

    public void trackOccupancy() {
        System.out.println("Library occupancy tracked.");
    }

    public void checkBookAvailability() {
        System.out.println("Checking digital book availability.");
    }
}

public class Problem6 {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("CR101"),
            new SmartLab("LAB202"),
            new SmartLibrary("LIB303")
        };

        for (SmartDevice device : devices) {
            device.status();

            if (device instanceof SmartClassroom) {
                SmartClassroom c = (SmartClassroom) device;
                c.controlAC();
                c.controlLighting();
                c.controlProjector();
            } else if (device instanceof SmartLab) {
                SmartLab l = (SmartLab) device;
                l.manageEquipment();
                l.safetySystem();
            } else if (device instanceof SmartLibrary) {
                SmartLibrary lib = (SmartLibrary) device;
                lib.trackOccupancy();
                lib.checkBookAvailability();
            }
        }
    }
}
