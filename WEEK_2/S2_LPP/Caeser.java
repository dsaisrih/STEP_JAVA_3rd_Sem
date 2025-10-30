import java.util.*;

public class Caeser {

    // Encrypt text by shifting characters forward
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            result.append((char)(ch + key));
        }
        return result.toString();
    }

    // Decrypt text by shifting characters backward
    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            result.append((char)(ch - key));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String input = sc.nextLine();

        System.out.print("Enter encryption key (integer): ");
        int key = sc.nextInt();

        String encrypted = encrypt(input, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("\n🔐 Encrypted Text: " + encrypted);
        System.out.println("🔓 Decrypted Text: " + decrypted);
    }
}