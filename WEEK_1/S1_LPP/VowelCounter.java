import java.util.Scanner;

public class VowelCounter {

    // a. Method to classify character
    public static String classifyChar(char ch) {
        // i. Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // Convert to lowercase
        }

        // ii. Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // b. Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String str) {
        int vowelCount = 0;
        int consonantCount = 0;
        int length = 0;

        // Find length using charAt() and exception
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string
        }

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            String result = classifyChar(ch);

            if (result.equals("Vowel")) {
                vowelCount++;
            } else if (result.equals("Consonant")) {
                consonantCount++;
            }
        }

        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // c. Take user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Count vowels and consonants
        int[] counts = countVowelsAndConsonants(input);

        // Display result
        System.out.println("\nVowel Count: " + counts[0]);
        System.out.println("Consonant Count: " + counts[1]);
    }
}