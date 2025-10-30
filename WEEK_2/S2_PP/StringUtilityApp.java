import java.util.*;

public class StringUtilityApp {
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== STRING UTILITY APPLICATION ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Text Analysis");
            System.out.println("2. String Transformation");
            System.out.println("3. ASCII Operations");
            System.out.println("4. Performance Testing");
            System.out.println("5. String Comparison Analysis");
            System.out.println("6. Custom String Algorithms");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter text for analysis: ");
                    performTextAnalysis(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter text for transformation: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter operations (comma-separated: trim,upper,lower,replace): ");
                    String[] ops = scanner.nextLine().split(",");
                    System.out.println(performTransformations(text, ops));
                    break;
                case 3:
                    System.out.print("Enter text for ASCII operations: ");
                    performASCIIOperations(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter number of iterations: ");
                    performPerformanceTest(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Enter strings (comma-separated): ");
                    performComparisonAnalysis(scanner.nextLine().split(","));
                    break;
                case 6:
                    System.out.print("Enter text for custom algorithms: ");
                    performCustomAlgorithms(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid option.");
            }

            displayResults();
            output.setLength(0);
        }

        scanner.close();
    }

    public static void performTextAnalysis(String text) {
        String[] words = text.trim().split("\\s+");
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        output.append("Length: ").append(text.length()).append("\n");
        output.append("Word Count: ").append(words.length).append("\n");
        output.append("Character Frequency:\n");
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            output.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
    }

    public static String performTransformations(String text, String[] operations) {
        StringBuilder sb = new StringBuilder(text);
        for (String op : operations) {
            switch (op.trim().toLowerCase()) {
                case "trim":
                    sb = new StringBuilder(sb.toString().trim());
                    break;
                case "upper":
                    sb = new StringBuilder(sb.toString().toUpperCase());
                    break;
                case "lower":
                    sb = new StringBuilder(sb.toString().toLowerCase());
                    break;
                case "replace":
                    sb = new StringBuilder(sb.toString().replace(" ", "_"));
                    break;
            }
        }
        return sb.toString();
    }

    public static void performASCIIOperations(String text) {
        for (char ch : text.toCharArray()) {
            int ascii = (int) ch;
            output.append("Char: ").append(ch).append(" | ASCII: ").append(ascii).append("\n");
        }
        output.append("Caesar Cipher (+3): ").append(caesarCipher(text, 3)).append("\n");
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ((ch - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ((ch - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void performPerformanceTest(int iterations) {
        long start, end;

        start = System.nanoTime();
        String s = "";
        for (int i = 0; i < iterations; i++) s += "x";
        end = System.nanoTime();
        output.append("String time: ").append(end - start).append(" ns\n");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) sb.append("x");
        end = System.nanoTime();
        output.append("StringBuilder time: ").append(end - start).append(" ns\n");

        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) sf.append("x");
        end = System.nanoTime();
        output.append("StringBuffer time: ").append(end - start).append(" ns\n");
    }

    public static void performComparisonAnalysis(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                boolean equals = strings[i].equals(strings[j]);
                boolean ignoreCase = strings[i].equalsIgnoreCase(strings[j]);
                output.append("Compare: ").append(strings[i]).append(" vs ").append(strings[j]).append("\n");
                output.append("Equals: ").append(equals).append(" | IgnoreCase: ").append(ignoreCase).append("\n");
            }
        }
    }

    public static void performCustomAlgorithms(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        boolean isPalindrome = cleaned.equals(reversed);
        output.append("Is Palindrome: ").append(isPalindrome).append("\n");

        char[] chars = cleaned.toCharArray();
        Arrays.sort(chars);
        output.append("Sorted Characters: ").append(new String(chars)).append("\n");
    }

    public static void displayResults() {
        System.out.println("\n--- RESULTS ---");
        System.out.println(output.toString());
    }
}