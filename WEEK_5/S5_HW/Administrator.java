import java.util.List;

public class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String adminId, List<String> accessPermissions) {
        this.adminId = adminId;
        this.accessPermissions = accessPermissions;
    }

    public String getAdminId() { return adminId; }
    public List<String> getAccessPermissions() { return accessPermissions; }

    @Override
    public String toString() {
        return "Administrator{id=" + adminId + ", permissions=" + accessPermissions + "}";
    }
}
