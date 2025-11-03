import java.util.UUID;

public class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;

    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;

    private int roomNumber;
    private String attendingPhysician;

    // Emergency admission (minimal data)
    public Patient(String name) {
        this(UUID.randomUUID().toString(), null, name, null, null, -1, null);
    }

    // Standard admission
    public Patient(MedicalRecord record, String name, String emergencyContact,
                   String insuranceInfo, int roomNumber, String physician) {
        this(UUID.randomUUID().toString(), record, name, emergencyContact, insuranceInfo, roomNumber, physician);
    }

    // Transfer admission (import existing record)
    public Patient(String patientId, MedicalRecord record, String name,
                   String emergencyContact, String insuranceInfo,
                   int roomNumber, String physician) {
        if (patientId == null || name == null) {
            throw new IllegalArgumentException("Patient data validation failed.");
        }
        this.patientId = patientId;
        this.medicalRecord = record;
        this.currentName = name;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
        this.roomNumber = roomNumber;
        this.attendingPhysician = physician;
    }

    // Getters & Setters
    public String getPatientId() { return patientId; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }

    public String getCurrentName() { return currentName; }
    public void setCurrentName(String currentName) { this.currentName = currentName; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getInsuranceInfo() { return insuranceInfo; }
    public void setInsuranceInfo(String insuranceInfo) { this.insuranceInfo = insuranceInfo; }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public String getAttendingPhysician() { return attendingPhysician; }
    public void setAttendingPhysician(String attendingPhysician) { this.attendingPhysician = attendingPhysician; }

    // Package-private access
    String getBasicInfo() {
        return "PatientID=" + patientId + ", Name=" + currentName;
    }

    // Public safe info
    public String getPublicInfo() {
        return "Patient " + currentName + " in Room " + roomNumber;
    }

    @Override
    public String toString() {
        return "Patient{id=" + patientId +
               ", name=" + currentName +
               ", room=" + roomNumber +
               ", physician=" + attendingPhysician + "}";
    }
}
