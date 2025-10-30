public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        // 1. Original length including spaces
        int originalLength = sampleText.length();

        // 2. Trim spaces and get new length
        String trimmedText = sampleText.trim();
        int trimmedLength = trimmedText.length();

        // 3. Character at index 5
        char charAt5 = sampleText.charAt(5);

        // 4. Extract substring "Programming"
        String substring = sampleText.substring(6, 17); // "Programming"

        // 5. Index of word "Fun"
        int indexOfFun = sampleText.indexOf("Fun");

        // 6. Contains "Java"
        boolean containsJava = sampleText.contains("Java");

        // 7. Starts with "Java" after trimming
        boolean startsWithJava = trimmedText.startsWith("Java");

        // 8. Ends with '!'
        boolean endsWithExclamation = sampleText.endsWith("!");

        // 9. Convert to uppercase
        String upperCaseText = sampleText.toUpperCase();

        // 10. Convert to lowercase
        String lowerCaseText = sampleText.toLowerCase();

        // Custom methods
        int vowelCount = countVowels(sampleText);
        System.out.println("All positions of character 'a':");
        findAllOccurrences(sampleText, 'a');

        // Display results
        System.out.println("\n--- String Analysis Results ---");
        System.out.println("Original Text: \"" + sampleText + "\"");
        System.out.println("Original Length: " + originalLength);
        System.out.println("Trimmed Text: \"" + trimmedText + "\"");
        System.out.println("Trimmed Length: " + trimmedLength);
        System.out.println("Character at Index 5: " + charAt5);
        System.out.println("Extracted Substring: " + substring);
        System.out.println("Index of 'Fun': " + indexOfFun);
        System.out.println("Contains 'Java': " + containsJava);
        System.out.println("Starts with 'Java' (after trim): " + startsWithJava);
        System.out.println("Ends with '!': " + endsWithExclamation);
        System.out.println("Uppercase: " + upperCaseText);
        System.out.println("Lowercase: " + lowerCaseText);
        System.out.println("Vowel Count: " + vowelCount);
    }

    // Method to count vowels using charAt()
    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.println("Found '" + target + "' at index: " + i);
            }
        }
    }
}