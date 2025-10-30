import java.util.*;

public class TextCompressor {

    // b. Count character frequency
    public static Object[] countFrequency(String text) {
        List<Character> chars = new ArrayList<>();
        List<Integer> freqs = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = chars.indexOf(ch);
            if (index == -1) {
                chars.add(ch);
                freqs.add(1);
            } else {
                freqs.set(index, freqs.get(index) + 1);
            }
        }

        char[] charArray = new char[chars.size()];
        int[] freqArray = new int[freqs.size()];
        for (int i = 0; i < chars.size(); i++) {
            charArray[i] = chars.get(i);
            freqArray[i] = freqs.get(i);
        }

        return new Object[]{charArray, freqArray};
    }

    // c. Generate compression codes
    public static String[][] generateCodes(char[] chars, int[] freqs) {
        int n = chars.length;
        String[][] map = new String[n][2];

        // Sort by frequency (simple bubble sort for clarity)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (freqs[j] < freqs[j + 1]) {
                    int tempFreq = freqs[j];
                    freqs[j] = freqs[j + 1];
                    freqs[j + 1] = tempFreq;

                    char tempChar = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = tempChar;
                }
            }
        }

        // Assign codes: most frequent get shortest codes
        for (int i = 0; i < n; i++) {
            map[i][0] = String.valueOf(chars[i]);
            map[i][1] = (i < 10) ? String.valueOf(i) : "#" + i;
        }

        return map;
    }

    // d. Compress text
    public static String compress(String text, String[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            String ch = String.valueOf(text.charAt(i));
            for (String[] pair : map) {
                if (pair[0].equals(ch)) {
                    sb.append(pair[1]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    // e. Decompress text
    public static String decompress(String compressed, String[][] map) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < compressed.length()) {
            String code = String.valueOf(compressed.charAt(i));
            if (code.equals("#")) {
                code += compressed.charAt(i + 1);
                i += 2;
            } else {
                i++;
            }

            for (String[] pair : map) {
                if (pair[1].equals(code)) {
                    sb.append(pair[0]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    // f. Display analysis
    public static void displayAnalysis(String text, char[] chars, int[] freqs, String[][] map,
                                       String compressed, String decompressed) {
        System.out.println("\nCharacter Frequency:");
        System.out.printf("%-10s %-10s\n", "Char", "Frequency");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-10s %-10d\n", chars[i], freqs[i]);
        }

        System.out.println("\nCompression Mapping:");
        System.out.printf("%-10s %-10s\n", "Char", "Code");
        for (String[] pair : map) {
            System.out.printf("%-10s %-10s\n", pair[0], pair[1]);
        }

        System.out.println("\nOriginal Text:\n" + text);
        System.out.println("\nCompressed Text:\n" + compressed);
        System.out.println("\nDecompressed Text:\n" + decompressed);

        int originalSize = text.length();
        int compressedSize = compressed.length();
        double efficiency = 100.0 * (originalSize - compressedSize) / originalSize;
        System.out.printf("\nCompression Efficiency: %.2f%%\n", efficiency);
    }

    // g. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        Object[] freqData = countFrequency(text);
        char[] chars = (char[]) freqData[0];
        int[] freqs = (int[]) freqData[1];

        String[][] map = generateCodes(chars, freqs);
        String compressed = compress(text, map);
        String decompressed = decompress(compressed, map);

        displayAnalysis(text, chars, freqs, map, compressed, decompressed);
    }
}