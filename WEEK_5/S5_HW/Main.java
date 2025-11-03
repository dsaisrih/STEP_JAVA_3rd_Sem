import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a medical record
        MedicalRecord record = new MedicalRecord(
                "REC001", "DNA12345",
                new String[]{"Peanuts", "Dust"},
                new String[]{"Asthma", "Hypertension"},
                LocalDate.of(1995, 5, 20), "O+");

        // Admit patient
        Patient patient = new Patient(record, "Alice", "1234567890", "InsuranceX", 101, "Dr. Smith");

        // Staff
        Doctor doctor = new Doctor("DOC001", "Cardiology", Set.of("BLS", "ACLS"));
        Nurse nurse = new Nurse("NUR001", "Night", List.of("Critical Care"));
        Administrator admin = new Administrator("ADM001", List.of("Read", "Write"));

        // Hospital system
        HospitalSystem hospital = new HospitalSystem();
        hospital.admitPatient(patient, doctor);

        System.out.println(record);
        System.out.println(patient.getPublicInfo());
        System.out.println(doctor);
        System.out.println(nurse);
        System.out.println(admin);
        System.out.println(hospital);
    }
}
