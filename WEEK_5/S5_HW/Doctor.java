import java.util.Set;

public class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String licenseNumber, String specialty, Set<String> certifications) {
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
        this.certifications = certifications;
    }

    public String getLicenseNumber() { return licenseNumber; }
    public String getSpecialty() { return specialty; }
    public Set<String> getCertifications() { return certifications; }

    @Override
    public String toString() {
        return "Doctor{license=" + licenseNumber + ", specialty=" + specialty + "}";
    }
}
