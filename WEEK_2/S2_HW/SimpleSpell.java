import java.util.*;

public class SimpleSpell {

    // Sample dictionary
    static String[] dictionary = {"hello", "world", "java", "program", "spell", "checker", "simple", "distance"};

    // a. Manual word splitting
    public static String[] splitSentence(String sentence) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ' || ch == '.' || ch == ',' || ch == '!' || ch == '?') {
                if (start < i) {
                    words.add(sentence.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < sentence.length()) {
            words.add(sentence.substring(start));
        }
        return words.toArray(new String[0]);
    }

    // b. String distance calculation
    public static int stringDistance(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();
        int distance = Math.abs(len1 - len2);

        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    // c. Find closest match from dictionary
    public static String findClosestWord(String word) {
        String closest = word;
        int minDistance = Integer.MAX_VALUE;

        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDistance) {
                minDistance = dist;
                closest = dictWord;
            }
        }

        return (minDistance <= 2) ? closest : word;
    }

    // d. Display results in tabular format
    public static void displayResults(String[] words) {
        System.out.printf("%-15s %-20s %-10s %-15s\n", "Original", "Suggested", "Distance", "Status");
        System.out.println("---------------------------------------------------------------");

        for (String word : words) {
            String suggestion = findClosestWord(word);
            int dist = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            String status = (dist == 0) ? "Correct" : "Misspelled";

            System.out.printf("%-15s %-20s %-10d %-15s\n", word, suggestion, dist, status);
        }
    }

    // e. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = splitSentence(input);
        displayResults(words);
    }
}