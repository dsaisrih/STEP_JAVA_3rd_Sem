import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String trimmed = input.trim();
        String replacedSpaces = trimmed.replace(" ", "_");
        String noDigits = trimmed.replaceAll("\\d", "");
        String[] words = trimmed.split("\\s+");
        String joined = String.join(" | ", words);
        String noPunctuation = removePunctuation(trimmed);
        String capitalized = capitalizeWords(noPunctuation);
        String reversed = reverseWordOrder(noPunctuation);

        System.out.println("\n--- Processed Results ---");
        System.out.println("Trimmed: " + trimmed);
        System.out.println("Spaces Replaced: " + replacedSpaces);
        System.out.println("Digits Removed: " + noDigits);
        System.out.println("Words Array: " + Arrays.toString(words));
        System.out.println("Joined with '|': " + joined);
        System.out.println("No Punctuation: " + noPunctuation);
        System.out.println("Capitalized Words: " + capitalized);
        System.out.println("Reversed Word Order: " + reversed);

        System.out.println("\n--- Word Frequency ---");
        countWordFrequency(noPunctuation);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("[\\p{Punct}]", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}