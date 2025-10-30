import java.util.Scanner;

public class ManualSplit {

    // b. Method to find length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // c. Method to split text into words manually
    public static String[] manualSplit(String str) {
        int length = getLength(str);
        int spaceCount = 0;

        // Count spaces to determine number of words
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount];
        int index = 0;

        // Store space indexes
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;

        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            words[i] = str.substring(start, end);
            start = end + 1;
        }

        // Last word
        words[spaceCount] = str.substring(start, length);

        return words;
    }

    // d. Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Built-in split
        String[] builtInSplit = input.split(" ");

        // Manual split
        String[] manualSplit = manualSplit(input);

        // Compare arrays
        boolean isEqual = compareArrays(builtInSplit, manualSplit);

        // Display results
        System.out.println("\nWords using built-in split():");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nWords using manual split:");
        for (String word : manualSplit) {
            System.out.println(word);
        }

        System.out.println("\nAre both arrays equal? " + isEqual);
    }
}