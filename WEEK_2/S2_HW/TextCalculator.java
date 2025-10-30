import java.util.*;

public class TextCalculator {

    // b. Validate expression format
    public static boolean isValid(String expr) {
        int parenCount = 0;
        char prev = ' ';
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            int ascii = (int) ch;

            if (!(Character.isDigit(ch) || "+-*/() ".indexOf(ch) != -1)) return false;
            if (ch == '(') parenCount++;
            if (ch == ')') parenCount--;
            if ("+-*/".indexOf(ch) != -1 && "+-*/".indexOf(prev) != -1) return false;
            if (parenCount < 0) return false;
            if (ch != ' ') prev = ch;
        }
        return parenCount == 0;
    }

    // c. Parse numbers and operators
    public static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < expr.length()) {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch)) {
                int start = i;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) i++;
                tokens.add(expr.substring(start, i));
            } else if ("+-*/()".indexOf(ch) != -1) {
                tokens.add(String.valueOf(ch));
                i++;
            } else {
                i++; // skip spaces
            }
        }
        return tokens;
    }

    // d. Evaluate expression without parentheses
    public static int evaluateSimple(List<String> tokens, StringBuilder steps) {
        // First pass: *, /
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("*") || tokens.get(i).equals("/")) {
                int a = Integer.parseInt(tokens.get(i - 1));
                int b = Integer.parseInt(tokens.get(i + 1));
                int res = tokens.get(i).equals("*") ? a * b : a / b;
                steps.append(a).append(" ").append(tokens.get(i)).append(" ").append(b).append(" = ").append(res).append("\n");
                tokens.set(i - 1, String.valueOf(res));
                tokens.remove(i); tokens.remove(i); i--;
            }
        }

        // Second pass: +, -
        int result = Integer.parseInt(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String op = tokens.get(i);
            int num = Integer.parseInt(tokens.get(i + 1));
            if (op.equals("+")) result += num;
            else result -= num;
            steps.append("Result ").append(op).append(" ").append(num).append(" = ").append(result).append("\n");
        }

        return result;
    }

    // e. Handle parentheses
    public static int evaluate(String expr, StringBuilder steps) {
        while (expr.contains("(")) {
            int close = expr.indexOf(")");
            int open = expr.lastIndexOf("(", close);
            String subExpr = expr.substring(open + 1, close);
            List<String> subTokens = tokenize(subExpr);
            int subResult = evaluateSimple(subTokens, steps);
            expr = expr.substring(0, open) + subResult + expr.substring(close + 1);
            steps.append("Sub-expression: (").append(subExpr).append(") = ").append(subResult).append("\n");
        }

        List<String> tokens = tokenize(expr);
        return evaluateSimple(tokens, steps);
    }

    // f. Display steps
    public static void display(String expr) {
        System.out.println("\nExpression: " + expr);
        if (!isValid(expr)) {
            System.out.println("Invalid expression format.");
            return;
        }

        StringBuilder steps = new StringBuilder();
        int result = evaluate(expr, steps);
        System.out.println("Steps:\n" + steps);
        System.out.println("Final Result: " + result);
    }

    // g. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of expressions:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Enter expression " + (i + 1) + ":");
            String expr = sc.nextLine();
            display(expr);
        }
    }
}