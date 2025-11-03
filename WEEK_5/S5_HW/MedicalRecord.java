import java.time.LocalDate;
import java.util.Arrays;

public final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA,
                         String[] allergies, String[] medicalHistory,
                         LocalDate birthDate, String bloodType) {
        if (recordId == null || patientDNA == null || birthDate == null || bloodType == null) {
            throw new IllegalArgumentException("Invalid medical record data (HIPAA compliance).");
        }
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies != null ? Arrays.copyOf(allergies, allergies.length) : new String[0];
        this.medicalHistory = medicalHistory != null ? Arrays.copyOf(medicalHistory, medicalHistory.length) : new String[0];
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return Arrays.copyOf(allergies, allergies.length); }
    public String[] getMedicalHistory() { return Arrays.copyOf(medicalHistory, medicalHistory.length); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        for (String allergy : allergies) {
            if (allergy.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MedicalRecord{id=" + recordId +
               ", DNA=" + patientDNA +
               ", bloodType=" + bloodType +
               ", birthDate=" + birthDate +
               ", allergies=" + Arrays.toString(allergies) +
               ", history=" + Arrays.toString(medicalHistory) + "}";
    }
}
