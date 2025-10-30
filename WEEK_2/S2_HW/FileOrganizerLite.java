import java.util.*;

public class FileOrganizerLite {

    static class FileInfo {
        String original, base, ext, category, newName;
        boolean valid;
    }

    static String categorize(String ext) {
        if (ext.equals("txt") || ext.equals("doc")) return "Doc";
        if (ext.equals("jpg") || ext.equals("png")) return "Img";
        if (ext.equals("mp3") || ext.equals("wav")) return "Aud";
        return "Unknown";
    }

    static FileInfo parse(String name, Map<String, Integer> count) {
        FileInfo f = new FileInfo();
        f.original = name;
        int dot = name.lastIndexOf('.');
        f.valid = dot > 0 && dot < name.length() - 1;
        f.base = f.valid ? name.substring(0, dot) : name;
        f.ext = f.valid ? name.substring(dot + 1).toLowerCase() : "";
        f.valid = f.base.matches("[\\w\\- ]+");
        f.category = categorize(f.ext);
        String key = f.category + "_2025";
        int num = count.getOrDefault(key, 1);
        count.put(key, num + 1);
        f.newName = key + "_" + num + (f.ext.isEmpty() ? "" : "." + f.ext);
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FileInfo> files = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        System.out.println("Enter file names (empty line to end):");
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            files.add(parse(line, count));
        }

        System.out.printf("%-20s %-10s %-20s %-6s\n", "Original", "Category", "New Name", "Valid");
        for (FileInfo f : files)
            System.out.printf("%-20s %-10s %-20s %-6s\n", f.original, f.category, f.newName, f.valid ? "Yes" : "No");

        System.out.println("\nRename Commands:");
        for (FileInfo f : files)
            if (f.valid && !f.original.equals(f.newName))
                System.out.println("rename \"" + f.original + "\" → \"" + f.newName + "\"");
    }
}