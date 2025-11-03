import java.util.List;

public class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String nurseId, String shift, List<String> qualifications) {
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualifications = qualifications;
    }

    public String getNurseId() { return nurseId; }
    public String getShift() { return shift; }
    public List<String> getQualifications() { return qualifications; }

    @Override
    public String toString() {
        return "Nurse{id=" + nurseId + ", shift=" + shift + "}";
    }
}
