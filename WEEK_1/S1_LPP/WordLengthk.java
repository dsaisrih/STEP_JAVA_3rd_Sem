import java.util.Scanner;

public class WordLengthk {

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

        // Count spaces
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

    // e. Method to find shortest and longest word
    public static int[] findShortestAndLongest(String[][] wordTable) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < wordTable.length; i++) {
            int len = Integer.parseInt(wordTable[i][1]);
            if (len < minLen) {
                minLen = len;
                minIndex = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
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

        // e. Find shortest and longest
        int[] result = findShortestAndLongest(wordTable);
        int minIndex = result[0];
        int maxIndex = result[1];

        // f. Display result
        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (String[] row : wordTable) {
            String word = row[0];
            int length = Integer.parseInt(row[1]);
            System.out.println(word + "\t" + length);
        }

        System.out.println("\nShortest word: " + wordTable[minIndex][0] + " (Length: " + wordTable[minIndex][1] + ")");
        System.out.println("Longest word: " + wordTable[maxIndex][0] + " (Length: " + wordTable[maxIndex][1] + ")");
    }
}