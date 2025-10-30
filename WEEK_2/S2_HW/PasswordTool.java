import java.util.*;

public class PasswordTool {

    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", lower = "abcdefghijklmnopqrstuvwxyz",
                 digits = "0123456789", special = "!@#$%^&*()-_=+[]{}|;:,.<>?/";
    static String[] patterns = {"123", "abc", "qwerty", "password", "admin"};

    static int[] analyze(String pwd) {
        int u = 0, l = 0, d = 0, s = 0;
        for (char ch : pwd.toCharArray()) {
            int a = ch;
            if (a >= 65 && a <= 90) u++;
            else if (a >= 97 && a <= 122) l++;
            else if (a >= 48 && a <= 57) d++;
            else if (a >= 33 && a <= 126) s++;
        }
        return new int[]{u, l, d, s};
    }

    static int score(String pwd, int[] c) {
        int sc = pwd.length() > 8 ? 2 * (pwd.length() - 8) : 0;
        for (int x : c) if (x > 0) sc += 10;
        for (String p : patterns) if (pwd.toLowerCase().contains(p)) sc -= 10;
        return sc;
    }

    static String level(int sc) {
        return sc <= 20 ? "Weak" : sc <= 50 ? "Medium" : "Strong";
    }

    static String generate(int len) {
        if (len < 8) len = 8;
        String all = upper + lower + digits + special;
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        sb.append(upper.charAt(r.nextInt(upper.length())));
        sb.append(lower.charAt(r.nextInt(lower.length())));
        sb.append(digits.charAt(r.nextInt(digits.length())));
        sb.append(special.charAt(r.nextInt(special.length())));
        while (sb.length() < len) sb.append(all.charAt(r.nextInt(all.length())));
        List<Character> chars = new ArrayList<>();
        for (char ch : sb.toString().toCharArray()) chars.add(ch);
        Collections.shuffle(chars);
        sb.setLength(0);
        for (char ch : chars) sb.append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many passwords? ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.printf("%-15s %-5s %-6s %-6s %-6s %-8s %-6s %-8s\n",
                "Password", "Len", "Up", "Lo", "Di", "Special", "Score", "Level");

        for (int i = 0; i < n; i++) {
            String pwd = sc.nextLine();
            int[] c = analyze(pwd);
            int scVal = score(pwd, c);
            System.out.printf("%-15s %-5d %-6d %-6d %-6d %-8d %-6d %-8s\n",
                    pwd, pwd.length(), c[0], c[1], c[2], c[3], scVal, level(scVal));
        }

        System.out.print("Generate strong password? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Length: ");
            System.out.println("Generated: " + generate(Integer.parseInt(sc.nextLine())));
        }
    }
}