import java.util.Scanner;

public class Anagram {

    // Method to check if two texts are anagrams
    public static boolean areAnagrams(String text1, String text2) {
        // Step i: Check if lengths are equal
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step ii: Create frequency arrays
        int[] freq1 = new int[256]; // ASCII size
        int[] freq2 = new int[256];

        // Step iii: Count character frequencies
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Step iv: Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();

        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();

        boolean result = areAnagrams(text1, text2);

        if (result) {
            System.out.println("\nThe texts are anagrams.");
        } else {
            System.out.println("\nThe texts are NOT anagrams.");
        }

        scanner.close();
    }
}