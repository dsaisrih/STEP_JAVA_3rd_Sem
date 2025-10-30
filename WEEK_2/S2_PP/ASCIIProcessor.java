import java.util.*;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            String type = classifyCharacter(ch);
            System.out.println("Character: " + ch + " | ASCII: " + ascii + " | Type: " + type);

            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                int diff = Math.abs((int) upper - (int) lower);
                System.out.println("Uppercase: " + upper + " (" + (int) upper + ")");
                System.out.println("Lowercase: " + lower + " (" + (int) lower + ")");
                System.out.println("ASCII Difference: " + diff);
            }
        }

        System.out.println("\nASCII Table (32 to 126):");
        displayASCIITable(32, 126);

        System.out.print("\nEnter shift for Caesar Cipher: ");
        int shift = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter text to encrypt: ");
        String cipherInput = scanner.nextLine();
        String encrypted = caesarCipher(cipherInput, shift);
        System.out.println("Encrypted Text: " + encrypted);

        int[] asciiArray = stringToASCII(input);
        System.out.println("\nASCII Array: " + Arrays.toString(asciiArray));
        String reconstructed = asciiToString(asciiArray);
        System.out.println("Reconstructed String: " + reconstructed);

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        else if (Character.isLowerCase(ch)) return (char) (ch - 32);
        else return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ((ch - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ((ch - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " : " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder result = new StringBuilder();
        for (int val : asciiValues) {
            result.append((char) val);
        }
        return result.toString();
    }
}