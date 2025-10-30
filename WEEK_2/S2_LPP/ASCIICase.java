import java.util.*;

public class ASCIICase {

    static char toUpper(char ch) {
        return (ch >= 'a' && ch <= 'z') ? (char)(ch - 32) : ch;
    }

    static char toLower(char ch) {
        return (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
    }

    static String toUpperCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) sb.append(toUpper(ch));
        return sb.toString();
    }

    static String toLowerCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) sb.append(toLower(ch));
        return sb.toString();
    }

    static String toTitleCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                sb.append(ch);
                newWord = true;
            } else {
                sb.append(newWord ? toUpper(ch) : toLower(ch));
                newWord = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println("Uppercase: " + toUpperCase(input));
        System.out.println("Lowercase: " + toLowerCase(input));
        System.out.println("Title Case: " + toTitleCase(input));
    }
}