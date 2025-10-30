import java.util.*;

public class CSVAnalyser {

    // b. Parse CSV-like input manually
    public static String[][] parseCSV(String input) {
        List<String[]> rows = new ArrayList<>();
        int i = 0, start = 0;
        boolean inQuotes = false;
        List<String> currentRow = new ArrayList<>();

        while (i <= input.length()) {
            char ch = (i < input.length()) ? input.charAt(i) : '\n';

            if (ch == '"') inQuotes = !inQuotes;
            else if ((ch == ',' && !inQuotes) || ch == '\n') {
                currentRow.add(input.substring(start, i).replaceAll("^\"|\"$", ""));
                start = i + 1;
                if (ch == '\n') {
                    rows.add(currentRow.toArray(new String[0]));
                    currentRow.clear();
                }
            }
            i++;
        }

        return rows.toArray(new String[0][0]);
    }

    // c. Clean and validate data
    public static Object[] cleanData(String[][] data) {
        int rows = data.length, cols = data[0].length;
        boolean[][] invalid = new boolean[rows][cols];
        Double[][] numeric = new Double[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String field = data[r][c].trim();
                data[r][c] = field;

                if (field.isEmpty()) {
                    invalid[r][c] = true;
                } else if (field.matches("-?\\d+(\\.\\d+)?")) {
                    numeric[r][c] = Double.parseDouble(field);
                }
            }
        }

        return new Object[]{data, numeric, invalid};
    }

    // d. Analyze data
    public static Map<Integer, String> analyzeColumns(Double[][] numeric, String[][] data, boolean[][] invalid) {
        Map<Integer, String> stats = new HashMap<>();

        for (int c = 0; c < data[0].length; c++) {
            List<Double> nums = new ArrayList<>();
            Set<String> unique = new HashSet<>();
            int missing = 0;

            for (int r = 0; r < data.length; r++) {
                if (invalid[r][c]) {
                    missing++;
                } else if (numeric[r][c] != null) {
                    nums.add(numeric[r][c]);
                } else {
                    unique.add(data[r][c]);
                }
            }

            if (!nums.isEmpty()) {
                double min = Collections.min(nums);
                double max = Collections.max(nums);
                double avg = nums.stream().mapToDouble(d -> d).average().orElse(0);
                stats.put(c, String.format("Numeric → Min: %.2f, Max: %.2f, Avg: %.2f", min, max, avg));
            } else {
                stats.put(c, String.format("Categorical → Unique: %d", unique.size()));
            }

            if (missing > 0) {
                stats.put(c, stats.get(c) + String.format(" | Missing: %d", missing));
            }
        }

        return stats;
    }

    // e. Format output
    public static void formatTable(String[][] data, boolean[][] invalid) {
        int cols = data[0].length;
        int[] widths = new int[cols];

        for (int c = 0; c < cols; c++) {
            for (String[] row : data) {
                widths[c] = Math.max(widths[c], row[c].length());
            }
            widths[c] = Math.max(widths[c], 10);
        }

        StringBuilder sb = new StringBuilder();
        String border = "+";
        for (int w : widths) border += "-".repeat(w + 2) + "+";
        sb.append(border).append("\n");

        for (int r = 0; r < data.length; r++) {
            sb.append("|");
            for (int c = 0; c < cols; c++) {
                String val = data[r][c];
                if (invalid[r][c]) val = "*MISSING*";
                sb.append(" ").append(String.format("%-" + widths[c] + "s", val)).append(" |");
            }
            sb.append("\n").append(border).append("\n");
        }

        System.out.println("\nFormatted Table:\n" + sb);
    }

    // f. Summary report
    public static void summaryReport(String[][] data, boolean[][] invalid, Map<Integer, String> stats) {
        int total = data.length;
        int missing = 0;
        for (boolean[] row : invalid) {
            for (boolean cell : row) if (cell) missing++;
        }

        double completeness = 100.0 * (total * data[0].length - missing) / (total * data[0].length);

        System.out.println("📊 Data Summary Report");
        System.out.println("Total Records: " + total);
        System.out.println("Completeness: " + String.format("%.2f", completeness) + "%");
        System.out.println("Column-wise Statistics:");
        for (int c = 0; c < stats.size(); c++) {
            System.out.println("  Column " + (c + 1) + ": " + stats.get(c));
        }
    }

    // g. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV-like data (end with empty line):");

        StringBuilder input = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            input.append(line).append("\n");
        }

        String[][] rawData = parseCSV(input.toString());
        Object[] cleaned = cleanData(rawData);
        String[][] data = (String[][]) cleaned[0];
        Double[][] numeric = (Double[][]) cleaned[1];
        boolean[][] invalid = (boolean[][]) cleaned[2];

        Map<Integer, String> stats = analyzeColumns(numeric, data, invalid);
        formatTable(data, invalid);
        summaryReport(data, invalid, stats);
    }
}