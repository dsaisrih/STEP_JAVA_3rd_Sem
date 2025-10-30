import java.util.Scanner;

public class StringLinerFinder {

    // Method to find string length without using length()
    public static int getLengthWithoutUsingLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // Access character at index
                count++;           // Increment count
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception thrown when index exceeds string length
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter a string: ");
        String input = scanner.next();

        // b. Call custom method
        int customLength = getLengthWithoutUsingLength(input);

        // c. Compare with built-in length()
        int actualLength = input.length();

        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + actualLength);
    }
}