import java.util.*;

public class HospitalSystem {
    private final Map<String, Object> patientRegistry = new HashMap<>();

    public static final String POLICY_PRIVACY = "Strict HIPAA compliance";
    public static final String POLICY_ACCESS = "Role-based access control";

    public boolean admitPatient(Object patient, Object staff) {
        if (!(patient instanceof Patient)) return false;
        if (!validateStaffAccess(staff, patient)) return false;

        Patient p = (Patient) patient;
        patientRegistry.put(p.getPatientId(), p);
        return true;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        if (staff instanceof Doctor) return true;
        if (staff instanceof Nurse) return true;
        if (staff instanceof Administrator) return true;
        return false;
    }

    // Package-private internal method
    Patient getPatientById(String id) {
        return (Patient) patientRegistry.get(id);
    }

    @Override
    public String toString() {
        return "HospitalSystem{policies=[" + POLICY_PRIVACY + ", " + POLICY_ACCESS + "], patients=" + patientRegistry.size() + "}";
    }
}
