import java.util.*;

public class ManualReplace {

    // b. Find all occurrences of substring
    public static List<Integer> findOccurrences(String text, String target) {
        List<Integer> positions = new ArrayList<>();
        int index = 0;
        while ((index = text.indexOf(target, index)) != -1) {
            positions.add(index);
            index += target.length();
        }
        return positions;
    }

    // c. Manual replacement
    public static String manualReplace(String text, String target, String replacement) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - target.length() &&
                text.substring(i, i + target.length()).equals(target)) {
                result.append(replacement);
                i += target.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    // d. Compare with built-in replace()
    public static boolean compareResults(String manual, String builtin) {
        return manual.equals(builtin);
    }

    // e. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter main text:");
        String text = sc.nextLine();

        System.out.println("Enter substring to find:");
        String target = sc.nextLine();

        System.out.println("Enter replacement substring:");
        String replacement = sc.nextLine();

        List<Integer> positions = findOccurrences(text, target);
        String manualResult = manualReplace(text, target, replacement);
        String builtinResult = text.replace(target, replacement);
        boolean isSame = compareResults(manualResult, builtinResult);

        System.out.println("\n🔍 Occurrences at positions: " + positions);
        System.out.println("\n🛠 Manual Replacement Result:\n" + manualResult);
        System.out.println("\n⚙️ Built-in Replacement Result:\n" + builtinResult);
        System.out.println("\n✅ Match with built-in method: " + (isSame ? "Yes" : "No"));
    }
}