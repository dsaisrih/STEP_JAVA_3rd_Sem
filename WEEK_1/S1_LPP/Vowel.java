import java.util.Scanner;

public class Vowel {

    // a. Method to classify character
    public static String classifyChar(char ch) {
        // i. Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
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

    // b. Method to analyze string and return 2D array of character and type
    public static String[][] analyzeCharacters(String str) {
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

        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = classifyChar(ch);
        }

        return result;
    }

    // c. Method to display 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\nCharacter\tType");
        System.out.println("-------------------------");
        for (String[] row : table) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // d. Take user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Analyze characters
        String[][] resultTable = analyzeCharacters(input);

        // Display result
        displayTable(resultTable);
    }
}