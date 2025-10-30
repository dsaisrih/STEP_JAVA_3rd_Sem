import java.util.Scanner;

public class CharFrequencyNested {

    // Method to find character frequencies using nested loops
    public static String[] getCharFrequencies(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        // Outer loop to initialize frequency and check duplicates
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            if (chars[i] == '0') continue;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate
                }
            }
        }

        // Count valid characters
        int count = 0;
        for (char c : chars) {
            if (c != '0') count++;
        }

        // Create 1D String array to store results
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] frequencies = getCharFrequencies(input);

        System.out.println("\nCharacter Frequencies:");
        for (String entry : frequencies) {
            System.out.println(entry);
        }

        scanner.close();
    }
}