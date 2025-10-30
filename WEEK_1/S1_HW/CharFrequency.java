import java.util.Scanner;

public class CharFrequency {

    // Method to compute character frequencies and return as 2D array
    public static char[][] getCharFrequencies(String text) {
        int[] freq = new int[256]; // ASCII size

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count how many unique characters are present
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }

        // Create 2D array to store characters and their frequencies
        char[][] result = new char[uniqueCount][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = ch;
                result[index][1] = (char)(freq[ch]); // Store frequency as char
                freq[ch] = 0; // Mark as processed
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char[][] frequencies = getCharFrequencies(input);

        System.out.println("\nCharacter Frequencies:");
        for (char[] pair : frequencies) {
            System.out.println(pair[0] + " : " + (int)pair[1]);
        }

        scanner.close();
    }
}