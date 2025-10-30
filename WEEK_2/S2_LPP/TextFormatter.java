import java.util.*;

public class TextFormatter {

    // b. Split text into words manually
    public static List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                if (start < i) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        return words;
    }

    // c. Justify text using StringBuilder
    public static List<String> justifyText(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        int i = 0;

        while (i < words.size()) {
            int lineLen = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && lineLen + 1 + words.get(j).length() <= width) {
                lineLen += 1 + words.get(j).length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            if (j == words.size() || gaps == 0) {
                // Last line or single word: left-aligned
                for (int k = i; k < j; k++) {
                    line.append(words.get(k));
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < width) line.append(" ");
            } else {
                int totalSpaces = width - (lineLen - gaps);
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words.get(k));
                    if (k < j - 1) {
                        for (int s = 0; s < spacePerGap; s++) line.append(" ");
                        if (extraSpaces-- > 0) line.append(" ");
                    }
                }
            }

            lines.add(line.toString());
            i = j;
        }

        return lines;
    }

    // d. Center-align text
    public static List<String> centerAlign(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int i = 0;

        while (i < words.size()) {
            line.setLength(0);
            int lineLen = 0;
            int j = i;

            while (j < words.size() && lineLen + words.get(j).length() + (j > i ? 1 : 0) <= width) {
                if (j > i) lineLen++;
                lineLen += words.get(j).length();
                j++;
            }

            for (int k = i; k < j; k++) {
                line.append(words.get(k));
                if (k < j - 1) line.append(" ");
            }

            int padding = (width - line.length()) / 2;
            StringBuilder centered = new StringBuilder();
            for (int p = 0; p < padding; p++) centered.append(" ");
            centered.append(line);
            while (centered.length() < width) centered.append(" ");
            lines.add(centered.toString());

            i = j;
        }

        return lines;
    }

    // e. Performance comparison
    public static long formatWithString(List<String> words, int width) {
        long start = System.nanoTime();
        int i = 0;
        while (i < words.size()) {
            int lineLen = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && lineLen + 1 + words.get(j).length() <= width) {
                lineLen += 1 + words.get(j).length();
                j++;
            }

            int gaps = j - i - 1;
            String line = "";

            if (j == words.size() || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line += words.get(k);
                    if (k < j - 1) line += " ";
                }
                while (line.length() < width) line += " ";
            } else {
                int totalSpaces = width - (lineLen - gaps);
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line += words.get(k);
                    if (k < j - 1) {
                        for (int s = 0; s < spacePerGap; s++) line += " ";
                        if (extraSpaces-- > 0) line += " ";
                    }
                }
            }

            i = j;
        }
        return System.nanoTime() - start;
    }

    // f. Display formatted text
    public static void displayFormatted(List<String> lines, String title) {
        System.out.println("\n📄 " + title);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            System.out.printf("Line %2d (%2d chars): %s\n", i + 1, line.length(), line);
        }
    }

    // g. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to format:");
        String text = sc.nextLine();

        System.out.print("Enter desired line width: ");
        int width = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> words = extractWords(text);
        List<String> justified = justifyText(words, width);
        List<String> centered = centerAlign(words, width);
        long builderTime = System.nanoTime();
        justifyText(words, width);
        builderTime = System.nanoTime() - builderTime;
        long stringTime = formatWithString(words, width);

        System.out.println("\n📝 Original Text:\n" + text);
        displayFormatted(justified, "Left-Justified Text");
        displayFormatted(centered, "Center-Aligned Text");

        System.out.println("\n⏱️ Performance Comparison:");
        System.out.println("StringBuilder Time: " + builderTime + " ns");
        System.out.println("String Concatenation Time: " + stringTime + " ns");
    }
}