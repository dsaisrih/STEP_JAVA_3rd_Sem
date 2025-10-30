import java.util.Scanner;

public class WordLength {

    // c. Method to find string length without using length()
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

    // b. Method to split text into words manually
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

    // d. Method to create 2D array of word and its length
    public static String[][] getWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            table[i][0] = words[i];
            table[i][1] = String.valueOf(len); // Convert int to String
        }

        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // b. Split manually
        String[] words = manualSplit(input);

        // d. Get 2D array of word and length
        String[][] wordTable = getWordLengthTable(words);

        // e. Display result in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (String[] row : wordTable) {
            String word = row[0];
            int length = Integer.parseInt(row[1]); // Convert String to int
            System.out.println(word + "\t" + length);
        }
    }
}