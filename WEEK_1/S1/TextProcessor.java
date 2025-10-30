import java.util.*;

public class TextProcessor {

    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder cleaned = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                cleaned.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return cleaned.toString().trim();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replace(" ", "").length();

        String longestWord = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
            for (char c : cleanWord.toLowerCase().toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("\n--- TEXT ANALYSIS ---");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (excluding spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommonChar);
    }

    public static String[] getWordsSorted(String text) {
        String[] rawWords = text.split("\\s+");
        List<String> cleanWords = new ArrayList<>();
        for (String word : rawWords) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                cleanWords.add(word);
            }
        }
        Collections.sort(cleanWords);
        return cleanWords.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text:\n> ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\nCleaned Text:\n" + cleaned);

        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\n--- SORTED WORDS ---");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nSearch for a word: ");
        String search = scanner.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(search);
        System.out.println("Word \"" + search + "\" found: " + found);

        scanner.close();
    }
}